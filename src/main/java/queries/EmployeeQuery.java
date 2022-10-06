package queries;

import entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class EmployeeQuery {

    private JpaManager jpaManager = new JpaManager();
    private EntityManager manager;
    private EntityTransaction transaction;

    public EmployeeQuery(){
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }

    public List<Employee> getAllEmployees(){
        return manager.createQuery("FROM employee").getResultList();
    }

    public Employee getEmployeeById(int id){
        return manager.find(Employee.class,id);
    }

    public List<Employee> getEmployeeByLastname(String lastname){
        return manager.createQuery("SELECT em FROM employee em WHERE em.lastname = :lastname").setParameter("lastname", lastname).getResultList();
    }

    public int insertEmployee(Employee employee) {
        transaction.begin();
        manager.persist(employee);
        return tryToReturnId(employee);
    }

    public int updateEmployee(int id, HashMap<String, String> values){

        Employee employee = getEmployeeById(id);

        if(employee != null){
            //Update company attributes
            String name = values.get("firstName");
            String lastname = values.get("lastName");
            String email = values.get("email");
            String phoneNumber = values.get("phoneNumber");
            String address = values.get("address");
            String salary = values.get("salary");
            String birthDate = values.get("birthDate");
            String company = values.get("idCompany");
            String institution = values.get("idInstitution");

            if (name != null) employee.setName(name);
            if (lastname != null) employee.setLastname(lastname);
            if (email != null) employee.setEmail(email);
            if (phoneNumber != null) employee.setPhoneNumber(phoneNumber);
            if (address != null) employee.setAddress(address);
            if (salary != null){
                try{
                    employee.setSalary(Double.parseDouble(salary));
                }catch (Exception exception){
                    System.out.println("Invalid salary value!");
                }
            }
            if (birthDate != null){
                try{
                    employee.setBirthDate(Date.valueOf(birthDate));
                }catch (Exception exception){
                    System.out.println("Invalid birthDate value!");
                }

            }
            if (company != null){
                try{
                    employee.setCompany(Integer.parseInt(company));
                }catch (Exception exception){
                    System.out.println("Invalid idCompany value!");
                }
            }
            if (institution != null){
                try {
                    employee.setInstitution(Integer.parseInt(institution));
                }catch (Exception exception){
                    System.out.println("Invalid idInstitution value!");
                }

            }
            transaction.begin();
            manager.merge(employee);
            return tryToReturnId(employee);
        }else{
            System.out.println("Company wasn't found");
            return -1;
        }
    }

    public int deleteEmployee(int id){

        Employee employee = getEmployeeById(id);

        if(employee != null){
            transaction.begin();
            manager.remove(employee);
            return tryToReturnId(employee);

        }else{
            System.out.println("Company wasn't found");
            return -1;
        }
    }

    private int tryToReturnId(Employee employee){
        try{
            //Commit transaction
            transaction.commit();
            return employee.getId();
        }catch(Exception e) {
            //Rollback transaction
            transaction.rollback();
            System.out.println("Database wasn't updated");
            return -1;
        }
    }
}
