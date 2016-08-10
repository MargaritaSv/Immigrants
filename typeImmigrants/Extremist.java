package immigrants.typeImmigrants;

import immigrants.City;
import immigrants.Gunable;
import immigrants.Weapon;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Extremist extends Immigrant implements Gunable {
    public Extremist(int startedMoney, City cityNow) {
        super(startedMoney, cityNow);
    }

    @Override
    public void buyGun(Weapon weapon) {
        super.weaponList.add(weapon);
        super.borderMoney -= weapon.getCost();

        if (super.borderMoney <= 0) {
            System.out.println("write something /... no money ");
        }
    }

    @Override
    public String toString() {
        return "\nExtremist immigrant: \n" + super.toString();
    }
}