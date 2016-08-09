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
    Passport passport;
    int startedMoney;
    List<Immigrant> parents;
    //TODO:   //List<Weapon> weapon = new ArrayList();


    public Immigrant(Passport passport, int startedMoney) {
        this.passport = passport;
        this.startedMoney = startedMoney;
        parents = new LinkedList<>();
    }
}
