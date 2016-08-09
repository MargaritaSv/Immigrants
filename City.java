package immigrants;

import immigrants.typeImmigrants.Immigrant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class City extends NamesGeographic implements Comparable<City> {
    List<PoliceOfficer> policeOfficers;
    int residents;
    List<Immigrant> immigrants;

    public City(String name, int residents) {
        super(name);

        if (residents <= 0) {
            throw new IllegalArgumentException("The city " + super.name + " must have at least one people");
        } else {
            this.residents = residents;
        }

        policeOfficers = new ArrayList<>();
        immigrants = new LinkedList<>();
    }

    @Override
    public int compareTo(City city) {
        if (this.name != city.name) {
            return 0;
        } else {
            return -1;
        }
    }

}
