import crud.EmployeeCrud;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.HashMap;

public class EmployeeTests {

    EmployeeCrud employeeCrud = new EmployeeCrud();

    @Test
    public void getAllEmployees(){
        employeeCrud.getAllEmployees();
    }

    @Test
    public void getEmployeeByLastname(){
        String lastname = "Perez";
        employeeCrud.getEmployeeByLastname(lastname);
    }

    @Test
    public void insertEmployee(){
        int idEmployee = 1;
        String firstName = "Camila";
        String lastname = "Quintero";
        String email = "camila@gmail.com";
        String phoneNumber = "12345678";
        String address = "Cl. 96 #10-38";
        double salary = 3900;
        Date birthDate = Date.valueOf("1995-09-02");
        int idCompany = 2;
        int idInstitution = 1;

        employeeCrud.insertEmployee(idEmployee,firstName,lastname,email,phoneNumber, address, salary, birthDate, idCompany, idInstitution);
        employeeCrud.getEmployeeById(idEmployee);
    }

    @Test
    public void updateEmployee(){
        int idEmployee = 1;

        HashMap<String, String> newEmployeeValues = new HashMap<>();

        newEmployeeValues.put("phoneNumber", "87654321");
        newEmployeeValues.put("idCompany", "3");
        newEmployeeValues.put("salary", "4300");

        employeeCrud.getEmployeeById(idEmployee);
        employeeCrud.updateEmployee(idEmployee, newEmployeeValues);
        employeeCrud.getEmployeeById(idEmployee);
    }

    @Test
    public void deleteEmployee(){
        int idEmployee = 1;
        employeeCrud.getEmployeeById(idEmployee);
        employeeCrud.deleteEmployee(idEmployee);
        employeeCrud.getEmployeeById(idEmployee);
    }

}
