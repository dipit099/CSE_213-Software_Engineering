package composite;
class Employee implements OrganizationComponent {
    String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public void showDetails() {
        System.out.println("Employee: [ Name: " + name + ", Position: " + position + ", Salary: $" + salary + " ]");
    }

    @Override
    public double getSalary() {
        return salary;
    }
   
}
