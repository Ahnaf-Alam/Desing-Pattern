package pizza;

import java.util.List;

public class NYStyleCheesePizza extends Pizza {
    private String name = "NY style sauce and cheese pizza";
    private String dough = "Thin crust dough";
    private String sauce = "Marinara sauce";

    private List<String> toppings = List.of("Grated Reggiano pizza");

    public NYStyleCheesePizza() {
        setName(name);
        setDough(dough);
        setSauce(sauce);
        setToppings(toppings);
    };


}
