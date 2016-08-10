package immigrants.typeImmigrants;

import immigrants.City;
import immigrants.Passport;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Normal extends Immigrant {
    private Passport passport;

    public Normal(Passport passport, City cityNow, int startedMoney) {
        super(startedMoney, cityNow);
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    @Override
    public String toString() {
        return this.passport + "\nImmigrant: normal" + " \n" + super.toString();
    }
}
