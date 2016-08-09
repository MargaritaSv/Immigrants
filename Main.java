package immigrants;

import immigrants.typeImmigrants.Extremist;
import immigrants.typeImmigrants.Immigrant;
import immigrants.typeImmigrants.Normal;
import immigrants.typeImmigrants.Radical;

import java.util.Random;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class Main {
    public static final int MAX_YEARS_IMMIGRANT = 115;
    public static final int MIN_YEARS_IMMIGRANT = 1;
    public static final int NUMBER_OF_IMMIGRANTS = 100;

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
        Immigrant[] immigrants = new Immigrant[NUMBER_OF_IMMIGRANTS];

        for (int i = 0; i <= immigrants.length - 1; i++) {
            Passport passport;
            Immigrant immigrant;

            if (Math.random() > 0.45) {
                passport = getPassport(names);
                immigrant = new Normal(passport, new Random().nextInt(5600) + 1000);

            } else if (Math.random() > 0.35) {
                immigrant = new Extremist(new Random().nextInt(560000) + 1000);

            } else {
                if (Math.random() <= 0.35) {
                    immigrant = new Radical(getPassport(names), new Random().nextInt(5600) + 1000);
                } else {
                    immigrant = new Radical(getPassport(), new Random().nextInt(3000) + 1000);
                }
            }
            immigrants[i] = immigrant;
        }


        for (Immigrant imm : immigrants) {
            for (int i = 0; i < 2; i++) {
                imm.addFamily(immigrants[new Random().nextInt(immigrants.length - 1)]);
            }
        }

        for (int i = 0; i < immigrants.length; i++) {
            System.out.println(immigrants[i]);
        }

        //3

        for (Immigrant immigrant : immigrants) {
            for (int i = 0; i < 5; i++) {

            }
        }

    }

    private static Passport getPassport() {
        Passport passport;
        passport = new Passport("Doesn't exist", (short) 0, "Doesn't exist");
        return passport;
    }

    private static Passport getPassport(String[] names) {
        Passport passport;
        passport = new Passport(names[new Random().nextInt(names.length - 1)],
                (short) (new Random().nextInt(MAX_YEARS_IMMIGRANT) + MIN_YEARS_IMMIGRANT), "Some address capital  and city");
        return passport;
    }
}
