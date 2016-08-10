package immigrants.typeImmigrants;

import immigrants.City;
import immigrants.Weapon;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Magi on 6.8.2016 г..
 */
public abstract class Immigrant {
    int borderMoney;
    List<Immigrant> family;
    List<Weapon> weaponList;
    City cityNow;

    public Immigrant(int borderMoney, City cityNow) {
        this.borderMoney = borderMoney;
        this.family = new LinkedList<>();
        this.weaponList = new LinkedList<>();
        this.cityNow = cityNow;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setCityNow(City cityNow) {
        if (this.cityNow.equals(cityNow)) {
            throw new IllegalArgumentException("The immigrant is already in" + this.cityNow);
        }

        this.cityNow.removeImmigrantCurrentCity(this);
        cityNow.addImmigrantCurrentCity(this);

        this.cityNow = cityNow;
    }

    public void addFamily(Immigrant immigrant) {
        //TODO: remove in the end
        /*
        if (family.contains(immigrant)) {
            throw new IllegalArgumentException("The immigrant is already added to family");
        }
        */

        if (!(this instanceof Normal)) {
            this.family.add(immigrant);
        } else {
            if (this.family.size() >= 11) {
                throw new IllegalArgumentException("No more people added to your family three!");
            }
            this.family.add(immigrant);
        }
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append("Current location: ").append(this.cityNow.getName()).append(", Poland\n");
        sB.append("Border money: ").append(this.borderMoney).append("$");
        sB.append("\nFamily:").append(System.lineSeparator());
        //TODO: fix the ... vurteleshkata .. :D
        /*
        for (Immigrant member : family) {
            sB.append("      --").append(member);
        }
*/
        sB.append(this.family.size());

        sB.append("\nWeapon/s: ");
        this.weaponList.forEach(x -> sB.append(x.name().toString().toLowerCase()).append(", "));

        return sB.toString();
    }

}
