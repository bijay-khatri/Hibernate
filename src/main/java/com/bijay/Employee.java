package com.bijay;

import javax.persistence.*;

/**
 * Created by Bijay on 6/24/2016.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column(name="Emp_No")
    private long employeeNumber;

    @Column(name="FullName")
    private String name;

    @ManyToOne
    private Department department;

    public Employee(String name, long number) {
        this.name = name;
        this.employeeNumber = number;
    }

    public Employee() {

    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public long getEmployeeNumber() {

        return employeeNumber;
    }

    public void setEmployeeNumber(long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
