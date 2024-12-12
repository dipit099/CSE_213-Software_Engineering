package composite;
public class Main {
    public static void main(String[] args) {
        // Individual employees
        Employee emp1 = new Employee("Alice", "Developer", 80000);
        Employee emp2 = new Employee("Bob", "Developer", 75000);
        Employee emp3 = new Employee("Charlie", "Manager", 100000);
        Employee emp4 = new Employee("Diana", "Designer", 70000);

        // IT Department
        Department itDepartment = new Department("IT Department");
        itDepartment.addComponent(emp1);
        itDepartment.addComponent(emp2);

        // Design Department
        Department designDepartment = new Department("Design Department");
        designDepartment.addComponent(emp4);

        // HR Department
        Department hrDepartment = new Department("HR Department");
        hrDepartment.addComponent(emp3);

        // Head Office
        Department headOffice = new Department("Head Office");
        headOffice.addComponent(itDepartment);
        headOffice.addComponent(designDepartment);
        headOffice.addComponent(hrDepartment);

        // Display the organization structure
        System.out.println("Organization Structure:");
        headOffice.showDetails();

        // Calculate and display the total cost
        System.out.println("\nTotal Cost of Organization: $" + headOffice.getSalary());
    }
}
