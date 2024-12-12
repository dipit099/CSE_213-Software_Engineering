package decorator_pattern;

public class WhipDecorator extends CoffeeDecorator {
    public WhipDecorator(Component coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whip";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.3;
    }
}
