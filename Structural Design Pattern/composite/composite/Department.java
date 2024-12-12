package composite;

import java.util.ArrayList;
import java.util.List;

class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components;  
    /*dept r moddhe dept abr employee o thakte pare..ejnne dept and employee r ekta common interface create kra hoise */

    public Department(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(OrganizationComponent component) {
        components.add(component);
        if (component instanceof Employee) {
            System.out.println("Employee " + ((Employee) component).name + " is added to " + name + " department.");
        } else if (component instanceof Department) {
            System.out.println("Department " + ((Department) component).name + " is added to " + name + " department.");
        }
    }

    public void removeComponent(OrganizationComponent component) {
        components.remove(component);
        System.out.println(component.getClass().getSimpleName() + " removed from " + this.getClass().getSimpleName());
    }

    @Override
    public void showDetails() {
        System.out.println("Department: " + name);
        for (OrganizationComponent component : components) {
            component.showDetails();
        }
    }

    @Override
    public double getSalary() {
        double totalCost = 0;
        for (OrganizationComponent component : components) {
            totalCost += component.getSalary();
        }
        return totalCost;
    }
}
