import pizza.Pizza;
import store.NYPizzaStore;
import store.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();

        Pizza pizza = pizzaStore.orderPizza("cheese");
        System.out.println("Ahnaf ordered a " + pizza.getName() + "\n");
    }
}