package immigrants.typeImmigrants;

import immigrants.Passport;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Normal extends Immigrant {

    public Normal(Passport passport, int startedMoney) {
        super(passport, startedMoney);
    }

    public void addFamily(Immigrant immigrant) {
        if (parents.contains(immigrant)) {
            throw new IllegalArgumentException("The immigrant " + immigrant.passport.getName() + " is already added to family");
        }

        if (parents.size() >= 11) {
            throw new IllegalArgumentException("No more people added to your family three!");
        }

        parents.add(immigrant);
    }
}
