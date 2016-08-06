package immigrants;

import java.util.TreeSet;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class Country extends NamesGeographic {
    TreeSet<String> cities;

    public Country(String name) {
        super(name);
    }
}
