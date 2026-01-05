package org.ycpait.employeemanagement.dao;

import org.ycpait.employeemanagement.entity.Employee;

public interface EmployeeDao {
    void addEmployee(Employee emp);
    void displayEmployees();
    Employee searchEmployee(int id);
    void deleteEmployee(int id);
    void updateSalary(int id, double newSalary);
    void showBonus(int id);
}
