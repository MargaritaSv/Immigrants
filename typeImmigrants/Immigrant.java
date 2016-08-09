package immigrants.typeImmigrants;

import immigrants.Passport;
import immigrants.Weapon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Magi on 6.8.2016 г..
 */
public abstract class Immigrant {
    //Passport passport;
    int startedMoney;
    List<Immigrant> parents;
    //TODO:   //List<Weapon> weapon = new ArrayList();


    public Immigrant(int startedMoney) {
        this.startedMoney = startedMoney;
        parents = new LinkedList<>();
    }

    public void addFamily(Immigrant immigrant) {
        if (parents.contains(immigrant)) {
            throw new IllegalArgumentException("The immigrant is already added to family");
        }
        if (!(this instanceof Normal)) {
            parents.add(immigrant);
        } else {
            if (parents.size() >= 11) {
                throw new IllegalArgumentException("No more people added to your family three!");
            }
            parents.add(immigrant);
        }
    }

    @Override
    public String toString() {
        return "Started money " + startedMoney + " " + this.parents;
    }
}
