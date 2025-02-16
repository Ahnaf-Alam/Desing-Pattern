import behavior.AxeBehavior;
import character.Character;
import character.King;

public class Main {


    public static void main(String[] args) {
        Character king = new King();
        king.display();
        king.fight();

        System.out.println("change the weapon");
        king.setWeaponBehavior(new AxeBehavior());
        king.fight();
    }
}