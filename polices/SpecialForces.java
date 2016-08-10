package immigrants.polices;

import immigrants.City;
import immigrants.typeImmigrants.Immigrant;

/**
 * Created by Magi on 10.8.2016 г..
 */
public class SpecialForces extends Police {

    public SpecialForces(String name, City city) {
        super(name, city);
    }

    @Override
    public void catchImmigrants(Immigrant immigrant) {
        if (Math.random() >= 0.9) {
            checkImmigrants(immigrant);
        } else {
            System.out.println("The immigrant escape!");
        }
    }

    @Override
    public void checkImmigrants(Immigrant immigrant) {
        System.out.println("From the special forces they're no escape!");
    }
}
