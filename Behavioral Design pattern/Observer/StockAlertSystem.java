// observer & subject interface create kora hoyeche

import java.util.ArrayList;
import java.util.List;

// Step 1: Create the Observer interface
interface Observer {
    void update(double stockPrice);
}

// Step 2: Create the Subject interface
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class Company implements Subject {
    private List<Observer> observers = new ArrayList<>(); // ei company ke jara follow krtase
    private double stockPrice;

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }
}

// Step 4: Implement Observer classes for Employees and Customers
class Employee implements Observer {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("Employee " + name + " received an update: Stock price changed to " + stockPrice);
    }
}

class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println("[Hello Customer " + name + "] You have received an update: Stock price changed to " + stockPrice);
    }
}

// Step 5: Demonstrate the Observer Pattern
public class StockAlertSystem {
    public static void main(String[] args) {
        Company company = new Company();

        company.addObserver(new Employee("John"));
        company.addObserver(new Employee("David"));
        company.addObserver(new Customer("Alice"));
        company.addObserver(new Customer("Bob"));

        // Change stock price and notify observers
        company.setStockPrice(120.50);
        System.out.println();
        company.setStockPrice(130.75);
    }
}
