package org.ycpait.employeemanagement;

import java.util.Scanner;
import org.ycpait.employeemanagement.dao.EmployeeDao;
import org.ycpait.employeemanagement.dao.EmployeeDaoImpl;
import org.ycpait.employeemanagement.entity.Employee;
import org.ycpait.employeemanagement.entity.Manager;

public class MainApp {

    public static void main(String[] args) {

        EmployeeDao dao = new EmployeeDaoImpl();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee");
            System.out.println("5. Update Salary");
            System.out.println("6. Show Bonus");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        System.out.print("1.Employee  2.Manager: ");
                        int type = sc.nextInt();

                        if (type == 2)
                            dao.addEmployee(new Manager(name, salary));
                        else
                            dao.addEmployee(new Employee(name, salary));
                        break;

                    case 2:
                        dao.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        int sid = sc.nextInt();
                        Employee e = dao.searchEmployee(sid);
                        System.out.println("Found: " + e.getName() + " | Salary: " + e.getSalary());
                        break;

                    case 4:
                        System.out.print("Enter ID: ");
                        dao.deleteEmployee(sc.nextInt());
                        break;

                    case 5:
                        System.out.print("Enter ID: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter New Salary: ");
                        dao.updateSalary(uid, sc.nextDouble());
                        break;

                    case 6:
                        System.out.print("Enter ID: ");
                        dao.showBonus(sc.nextInt());
                        break;

                    case 0:
                        System.out.println("🚪 Exiting Application");
                        break;

                    default:
                        System.out.println("❌ Invalid Choice");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}
