package immigrants.typeImmigrants;

import immigrants.Passport;
import immigrants.Weapon;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Normal extends Immigrant {
    Passport passport;

    public Normal(Passport passport, int startedMoney) {
        super(startedMoney);
        this.passport = passport;
    }


    @Override
    public String toString() {
        return this.passport + "\nImmigrant: normal" + " \n" + super.toString();
    }
}
