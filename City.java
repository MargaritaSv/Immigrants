package immigrants;

import immigrants.polices.PoliceOfficer;
import immigrants.typeImmigrants.Immigrant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class City extends NamesGeographic implements Comparable<City> {
    private List<PoliceOfficer> policeOfficers;
    private int residents; //all people
    private List<Immigrant> immigrants;

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

    public void removeImmigrantCurrentCity(Immigrant immigrant) {
        this.residents--;
        immigrants.remove(immigrant);
    }

    public void addImmigrantCurrentCity(Immigrant immigrant) {
        this.residents++;
        immigrants.add(immigrant);
    }

    @Override
    public int compareTo(City city) {
        if (this.name != city.name) {
            return 0;
        } else {
            return -1;
        }
    }

    public void victims(int victims) {
        System.out.println(this.getName() + " --> " + this.residents);

        this.residents -= victims;
        if (this.residents < 0) {
            this.residents = 0;
        }
        System.out.println(this.getName() + " --> " + this.residents);
    }
}
