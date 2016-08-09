package immigrants.typeImmigrants;

import immigrants.Passport;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Radical extends Immigrant {

    Passport passport;

    public Radical(Passport passport, int startedMoney) {
        super(startedMoney);
        this.passport = passport;
    }

    @Override
    public String toString() {
        return this.passport + " \n" + super.toString();
    }
}
