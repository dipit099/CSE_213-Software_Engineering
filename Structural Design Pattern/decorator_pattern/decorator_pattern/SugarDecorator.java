package decorator_pattern;

public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Component coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.2;
    }
}
