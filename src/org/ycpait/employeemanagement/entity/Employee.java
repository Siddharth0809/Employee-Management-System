package org.ycpait.employeemanagement.entity;

public class Employee {
    protected int id;
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10; // 10% bonus for Employee
    }

    @Override
    public String toString() {
        return id + " | " + name + " | Salary: " + salary;
    }
}
