package immigrants.typeImmigrants;

import immigrants.City;
import immigrants.exceprions.ImmigrantsException;
import immigrants.interfaces.Gunable;
import immigrants.Passport;
import immigrants.Weapon;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Radical extends Immigrant implements Gunable {
    private Passport passport;

    public Radical(Passport passport, City cityNow, int borderMoney) {
        super(borderMoney, cityNow);
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public void buyGun(Weapon weapon) throws ImmigrantsException {
        if (super.weaponList.size() >= 5) {
            throw new ImmigrantsException("You ca not have more than 5 weapons.");
        }

        super.weaponList.add(weapon);
        super.borderMoney -= weapon.getCost();

        if (super.borderMoney <= 0) {
            super.borderMoney = 0;
            //   System.out.println("write something /... no money ");
        }
    }

    @Override
    public String toString() {
        return this.passport + "\nImmigrant: radical" + " \n" + super.toString();
    }

}
