package org.ycpait.employeemanagement.entity;

public class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // 20% bonus for Manager
    }
}
