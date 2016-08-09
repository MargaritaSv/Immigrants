package immigrants;

import java.util.Random;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class Main {
    public static final int MAX_YEARS_IMMIGRANT = 115;
    public static final int MIN_YEARS_IMMIGRANT = 1;

    public static void main(String[] args) {
        //1
        Country poland = new Country("Poland");

        City santok = new City("Santok", (int) (Math.random() * 6000.0));
        City krosno = new City("Krosno", (int) (Math.random() * 6000.0));
        City lubusz = new City("Lubusz", (int) (Math.random() * 6000.0));
        City rogozno = new City("Rogozno", (int) (Math.random() * 6000.0));
        City poznan = new City("Poznan", (int) (Math.random() * 6000.0));

        poland.addCities(santok, krosno, lubusz, rogozno, poznan);

        //2
        final String[] names = {"Zhlab", "DzinDjan", "Djafira", "Stanka", "Gergina", "Stefka", "Radka", "Pesho", "Gosho", "Andrelius", "Kasandra", "Armira", "Penelope"};


        for (int i = 0; i <= 100; i++) {
            Passport passport;
            if (Math.random() > 0.45) {
                //normal
                passport = new Passport(names[new Random().nextInt(names.length - 1)],
                        (short) ((short) Math.random() * (MAX_YEARS_IMMIGRANT - MIN_YEARS_IMMIGRANT) + MIN_YEARS_IMMIGRANT), "Some address capital  and city");
            } else if (Math.random() > 0.35) {
                //ekstremist
                passport = new Passport("Doesn't exist", (short) 0, "Doesn't exist");
            } else {
                passport = new Passport(names[new Random().nextInt(names.length - 1)],
                        (short) ((short) Math.random() * (MAX_YEARS_IMMIGRANT - MIN_YEARS_IMMIGRANT) + MIN_YEARS_IMMIGRANT), "Some address capital  and city");
                //radivalist
            }

        }

    }
}
