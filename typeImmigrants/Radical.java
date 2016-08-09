package immigrants.typeImmigrants;

import immigrants.Gunable;
import immigrants.Passport;
import immigrants.Weapon;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Radical extends Immigrant implements Gunable {
    Passport passport;

    public Radical(Passport passport, int borderMoney) {
        super(borderMoney);
        this.passport = passport;
    }


    @Override
    public void buyGun(Weapon weapon) {
        if (super.weaponList.size() >= 5) {
            throw new IllegalArgumentException("You ca not have more than 5 weapons.");
        }
        super.weaponList.add(weapon);
        super.borderMoney -= weapon.getCost();

        if (super.borderMoney <= 0) {
            System.out.println("write something /... no money ");
        }
    }


    @Override
    public String toString() {
        return this.passport + " \n" + super.toString();
    }

}
