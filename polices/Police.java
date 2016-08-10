package immigrants.polices;

import immigrants.BasicData;
import immigrants.City;
import immigrants.interfaces.Policeable;

/**
 * Created by Magi on 10.8.2016 г..
 */
public abstract class Police extends BasicData implements Policeable {

    public Police(String name, City city) {
        super(name, city);
    }
}
