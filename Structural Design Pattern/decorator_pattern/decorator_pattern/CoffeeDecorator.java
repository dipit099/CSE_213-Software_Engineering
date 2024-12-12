package decorator_pattern;

public abstract class CoffeeDecorator implements Component {
    protected Component decoratedCoffee;

    public CoffeeDecorator(Component coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}
