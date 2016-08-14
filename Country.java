package immigrants;

import immigrants.City;
import immigrants.NamesGeographic;

import java.util.TreeSet;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class Country extends NamesGeographic {
    private TreeSet<City> cities = new TreeSet<>();

    public Country(String name) {
        super(name);
    }

    public void addCities(City... city) {
        for (City c : city) {
            cities.add(c);
        }
    }

    public TreeSet<City> getCities() {
        return cities;
    }
}
