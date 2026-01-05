package org.ycpait.employeemanagement.dao;

import java.util.ArrayList;
import org.ycpait.employeemanagement.entity.Employee;
import org.ycpait.employeemanagement.exception.EmployeeNotFoundException;

public class EmployeeDaoImpl implements EmployeeDao {

    private ArrayList<Employee> employees = new ArrayList<>();
    private static int idCounter = 1001; // Auto ID start

    @Override
    public void addEmployee(Employee emp) {
        emp.setId(idCounter++);
        employees.add(emp);
        System.out.println("✅ Employee Added with ID: " + emp.getId());
    }

    @Override
    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("⚠ No Employees Found");
            return;
        }
        System.out.println("\nID | Name | Salary");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    @Override
    public Employee searchEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("❌ Employee ID " + id + " Not Found"));
    }

    @Override
    public void deleteEmployee(int id) {
        Employee emp = searchEmployee(id);
        employees.remove(emp);
        System.out.println("🗑 Employee Deleted Successfully");
    }

    @Override
    public void updateSalary(int id, double newSalary) {
        Employee emp = searchEmployee(id);
        emp.setSalary(newSalary);
        System.out.println("💰 Salary Updated Successfully");
    }

    @Override
    public void showBonus(int id) {
        Employee emp = searchEmployee(id);
        System.out.println("🎁 Bonus for " + emp.getName() + ": " + emp.calculateBonus());
    }
}
