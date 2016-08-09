package immigrants.typeImmigrants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Magi on 6.8.2016 г..
 */
public abstract class Immigrant {
    int borderMoney;
    List<Immigrant> family;
    //TODO:   //List<Weapon> weapon = new ArrayList();


    public Immigrant(int startedMoney) {
        this.borderMoney = startedMoney;
        family = new LinkedList<>();
    }

    public void addFamily(Immigrant immigrant) {
        //TODO: remove in the end
        /*
        if (family.contains(immigrant)) {
            throw new IllegalArgumentException("The immigrant is already added to family");
        }
        */

        if (!(this instanceof Normal)) {
            family.add(immigrant);
        } else {
            if (family.size() >= 11) {
                throw new IllegalArgumentException("No more people added to your family three!");
            }
            family.add(immigrant);
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
        sB.append(family.size());
        return sB.toString();
    }
}
