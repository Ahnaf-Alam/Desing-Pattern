package pizza;

import java.util.List;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza() {
        String name = "Chicago Style Deep Dish Cheese Pizza";
        String dough = "Extra Thick Crust Dough";
        String sauce = "Plum Tomato Sauce";
        List<String> toppings = List.of("Shredded Mozzarella Cheese");
    }

    public void cut() {
        System.out.println("Cutting pizza in square slice");
    }
}
