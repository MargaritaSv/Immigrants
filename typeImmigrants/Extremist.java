package immigrants.typeImmigrants;

import immigrants.Passport;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Extremist extends Immigrant {
    public Extremist(int startedMoney) {
        super(startedMoney);
    }

    @Override
    public String toString() {
        return "Extremist immigrant: " + super.toString();
    }
}
