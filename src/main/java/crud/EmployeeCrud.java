package crud;

import entities.Employee;
import queries.EmployeeQuery;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public class EmployeeCrud {

    EmployeeQuery employeeQuery = new EmployeeQuery();

    public void getAllEmployees(){
        List<Employee> employeeList = employeeQuery.getAllEmployees();

        if(employeeList.size() != 0){
            for (Employee employee: employeeList) {
                System.out.println(employee);
            }
        }else{
            System.out.println("No employees were found");
        }
    }

    public void getEmployeeById(int id){
        Employee employee = employeeQuery.getEmployeeById(id);

        if(employee != null){
            System.out.println(employee);
        }else {
            System.out.println("The employee with id '" + id + "' wasn't found");
        }
    }

    public void getEmployeeByLastname(String lastname){
        List<Employee> employeeList = employeeQuery.getEmployeeByLastname(lastname);

        if(employeeList.size() != 0){
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
        }else {
            System.out.println("No employees with lastname '" + lastname + "' were found");
        }
    }

    public void insertEmployee(int id, String name, String lastname, String email, String phoneNumber, String address, double salary, Date birthDate, int company, int institution){

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setLastname(lastname);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setSalary(salary);
        employee.setBirthDate(birthDate);
        employee.setCompany(company);
        employee.setInstitution(institution);

        int companyId = employeeQuery.insertEmployee(employee);

        if(companyId != -1){
            System.out.println("A new employee with id " + id + " was created");
        }else {
            System.out.println("No employee was created");
        }
    }

    public void updateEmployee(int id, HashMap<String, String> values){

        int employeeId = employeeQuery.updateEmployee(id,values);

        if(employeeId != -1){
            System.out.println("The employee with id " + id + " was updated");
        }else {
            System.out.println("No employee was updated");
        }
    }

    public void deleteEmployee(int id){

        int employeeId = employeeQuery.deleteEmployee(id);

        if(employeeId != -1){
            System.out.println("The employee with id " + id + " was deleted");
        }else {
            System.out.println("No employee was deleted");
        }

    }

}
