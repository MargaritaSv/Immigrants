package immigrants;

import java.util.Random;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class Main {
    public static void main(String[] args) {
        //1
        Country poland = new Country("Poland");

        City santok = new City("Santok", (int) (Math.random() * 6000.0));
        City krosno = new City("Krosno", (int) (Math.random() * 6000.0));
        City lubusz = new City("Lubusz", (int) (Math.random() * 6000.0));
        City rogozno = new City("Rogozno", (int) (Math.random() * 6000.0));
        City poznan = new City("Rogozno", (int) (Math.random() * 6000.0));

        poland.addCities(santok, krosno, lubusz, rogozno, poznan);
    }
}
