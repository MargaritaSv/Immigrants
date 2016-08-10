package immigrants.typeImmigrants;

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


    public Immigrant(int startedMoney) {
        this.borderMoney = startedMoney;
        this.family = new LinkedList<>();
        this.weaponList = new LinkedList<>();
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

        sB.append("Border money: ").append(this.borderMoney);
        sB.append("\nFamily:").append(System.lineSeparator());
        //TODO: fix the ... vurteleshkata .. :D
        /*
        for (Immigrant member : family) {
            sB.append("      --").append(member);
        }
*/
        sB.append(this.family.size());

        sB.append("\nWeapon/s: ");
       this. weaponList.forEach(x -> sB.append(x.name().toString().toLowerCase()).append(", "));

        return sB.toString();
    }
}
