package decorator_pattern;

public class Main {
    public static void main(String[] args) {
        Component coffee = new Coffee();
        coffee = new WhipDecorator((new MilkDecorator(new SugarDecorator(new Coffee()))));
        System.out.println(coffee.getDescription() + " - $" + coffee.getCost());       

        

        Component coffee_with_milk = new MilkDecorator(new Coffee());
        Component coffee_with_sugar = new SugarDecorator(coffee_with_milk);
        Component finalCoffee  = new WhipDecorator(coffee_with_sugar);
        System.out.println(finalCoffee .getDescription() + " - $" + finalCoffee .getCost());
       

        
    }
}
