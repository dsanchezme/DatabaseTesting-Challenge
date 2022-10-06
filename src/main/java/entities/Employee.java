package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "idEmployee", nullable = false)
    private int id;

    @Column(name = "firstName", nullable = false, length = 45)
    private String name;

    @Column(name = "lastName", nullable = false, length = 45)
    private String lastname;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "phoneNumber", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "birthDate", nullable = false)
    private Date birthDate;

    @Column(name = "idCompany", nullable = false)
    private int company;

    @Column(name = "idInstitution", nullable = false)
    private int institution;

    public Employee() {
    }

    public Employee(int id, String name, String lastname, String email, String phoneNumber, String address, double salary, Date birthDate, int company, int institution) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.birthDate = birthDate;
        this.company = company;
        this.institution = institution;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public int getInstitution() {
        return institution;
    }

    public void setInstitution(int institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "Employee id: " + id + '\n' +
                "         name: " + name + '\n' +
                "         lastname: " + lastname + '\n' +
                "         email: " + email + '\n' +
                "         phoneNumber: " + phoneNumber + '\n' +
                "         address: " + address + '\n' +
                "         salary: " + salary + '\n' +
                "         birthDate: " + birthDate + '\n' +
                "         company: " + company + '\n' +
                "         institution: " + institution + '\n';
    }
}
