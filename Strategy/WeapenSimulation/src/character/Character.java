package character;

import behavior.WeaponBehavior;

public abstract class Character {
    String type;
    WeaponBehavior weaponBehavior;

    public abstract void display();

    public void fight() {
        weaponBehavior.useWeapon();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WeaponBehavior getWeaponBehavior() {
        return weaponBehavior;
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
