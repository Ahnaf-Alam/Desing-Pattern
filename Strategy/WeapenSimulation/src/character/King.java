package character;

import behavior.KnifeBehavior;

public class King extends Character{

    public King() {
        weaponBehavior = new KnifeBehavior();
        type = "King";
    }

    @Override
    public void display() {
        System.out.println("I'm the " + this.getType());
    }
}
