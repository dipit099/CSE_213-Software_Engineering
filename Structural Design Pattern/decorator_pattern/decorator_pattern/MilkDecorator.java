package decorator_pattern;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Component coffee) {
        super(coffee); // why super(coffee) ??
        // so that only the parent class constructor is called and not the child class
        // constructor.// and hence one object is created.
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}
