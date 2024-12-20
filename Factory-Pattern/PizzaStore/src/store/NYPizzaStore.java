package store;

import pizza.Pizza;
import pizza.NYStyleCheesePizza;

public class NYPizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equalsIgnoreCase("cheese")) {
            pizza = new NYStyleCheesePizza();
        }

        return pizza;
    }
}
