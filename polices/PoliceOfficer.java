package immigrants.polices;

import immigrants.City;
import immigrants.Weapon;
import immigrants.typeImmigrants.Extremist;
import immigrants.typeImmigrants.Immigrant;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class PoliceOfficer extends Police {

    public PoliceOfficer(String name, City city) {
        super(name, city);
    }

    @Override
    public void catchImmigrants(Immigrant immigrant) {
        if (Math.random() >= 0.5) {
            checkImmigrants(immigrant);
        } else {
            System.out.println("The immigrant escape!");
        }
    }

    @Override
    public void checkImmigrants(Immigrant immigrant) {
        if (immigrant instanceof Extremist) {
            if (immigrant.getWeaponList().contains(Weapon.BOMB)) {
                System.out.println("The immigrant is very dangerous for the police officers " + this.getName() + "!");
            }
        }

        System.out.println("The immigrant is checked from police officer " + this.getName() + "!");
    }
}
