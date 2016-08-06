package immigrants;

import java.util.List;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class City extends NamesGeographic{
    List<PoliceOfficer> policeOfficers;
    int residents;
    List<Immigrant> immigrants;

    public City(String name) {
        super(name);
    }
}
