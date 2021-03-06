package immigrants;

import immigrants.exceprions.ImmigrantsException;
import immigrants.exceprions.PassportException;
import immigrants.polices.*;
import immigrants.typeImmigrants.Extremist;
import immigrants.typeImmigrants.Immigrant;
import immigrants.typeImmigrants.Normal;
import immigrants.typeImmigrants.Radical;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Magi on 6.8.2016 г..
 */
public class Main {
    public static final int MAX_YEARS_IMMIGRANT = 115;
    public static final int MIN_YEARS_IMMIGRANT = 1;
    public static final int NUMBER_OF_IMMIGRANTS = 100;
    public static final int NUMBER_OF_WEAPONS = 200;

    public static final String[] citiesSudan = {"New Halfa", "Dueim", "Atbarah", "Sindscha", "Kaduqli", "Rabak", "Kassala", "Ubayyid", "Wad Madani", "Sennar", "Nahud", "Damir", "Maagil"};

    public static void main(String[] args) {
        try {
            //1
            Country poland = new Country("Poland");

            City santok = new City("Santok", (int) (Math.random() * (60000.0 - 8) + 8));
            City krosno = new City("Krosno", (int) (Math.random() * (4000.0 - 8) + 8));
            City lubusz = new City("Lubusz", (int) (Math.random() * (500.0 - 8) + 8));
            City rogozno = new City("Rogozno", (int) (Math.random() * (6000.0 - 8) + 8));
            City poznan = new City("Poznan", (int) (Math.random() * (6000.0 - 8) + 8));

            poland.addCities(santok, krosno, lubusz, rogozno, poznan);

            //2 and 4
            City[] citiesPoland = new City[]{krosno, santok, lubusz, rogozno, poznan};

            LinkedList<Immigrant> immigrants = createImmigrants(citiesPoland);

            for (int i = 0; i < immigrants.size() / 4; i++) {
                for (int j = 0; j < 2; j++) {
                    immigrants.get(i).addFamily(immigrants.get(new Random().nextInt(immigrants.size() - 1)));
                }
            }

            //3
            // create random number of different weapon
            List<Weapon> weapons = new LinkedList<>();
            createWeapons(weapons);

            immigrantsBuyAGun(immigrants, weapons);

            //4

            //4.1 create police
            final String[] policeName = new String[]{"Wojtek", "Bartek", "Kamil", "Marchin", "Mateusz", "Lukasz", "Igor", "Lewy", "Max", "John", "Tymon", "Rafa", "Kajtek", "Rem"};
            Police[] polices = new Police[100];
            Police police;
            for (int i = 0; i < polices.length; i++) {
                if (i % 2 == 0) {
                    police = new PoliceOfficer(policeName[new Random().nextInt(policeName.length - 1)], citiesPoland[new Random().nextInt(citiesPoland.length - 1)]);
                } else {
                    police = new SpecialForces(policeName[new Random().nextInt(policeName.length - 1)], citiesPoland[new Random().nextInt(citiesPoland.length - 1)]);
                }
                polices[i] = police;
            }

            //4.2 thirty percent from all emigrants go there... and there ... and everywhere
            int emigrantAnotherCity = (int) (immigrants.size() * 0.3);
            for (int i = 0; i < emigrantAnotherCity; i++) {
                //rnd emigrant
                int rnd = new Random().nextInt(immigrants.size() - 1);
                Immigrant goSomeWhere = immigrants.get(rnd);
                goSomeWhere.setCityNow(citiesPoland[new Random().nextInt(citiesPoland.length - 1)]);

                //catch from police
                police = polices[new Random().nextInt(polices.length - 1)];
                police.catchImmigrants(goSomeWhere);
            }

            //5
            for (int i = 0; i < immigrants.size(); i++) {
                System.out.println(immigrants.get(i));
            }

            //6
            System.out.println("\n Cities with bad immigrants:\n");
            attackedCities(immigrants);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void attackedCities(LinkedList<Immigrant> immigrants) {
        for (int i = 0; i < 20; i++) {
            Immigrant kamikadze = immigrants.get(new Random().nextInt(immigrants.size() - 1));

            if (kamikadze.getWeaponList().contains(Weapon.BOMB)) {
                immigrants.remove(kamikadze);
                System.out.println("BOOM! Kamikadze die ");
                kamikadze.getCityNow().victims(Weapon.BOMB.getCost());
                continue;
            }

            if (kamikadze.getWeaponList().contains(Weapon.AUTOMATE) || kamikadze.getWeaponList().contains(Weapon.GUN)) {
                System.out.println("SPARTAAAAAA!");
                if (kamikadze.getWeaponList().contains(Weapon.AUTOMATE)) {
                    kamikadze.getCityNow().victims(Weapon.BOMB.getCost());
                }

                if (kamikadze.getWeaponList().contains(Weapon.GUN)) {
                    kamikadze.getCityNow().victims(Weapon.GUN.getCost());
                }
            }
        }
    }

    private static void immigrantsBuyAGun(LinkedList<Immigrant> immigrants, List<Weapon> weapons) throws ImmigrantsException {
        for (int exactBuyer = 0; exactBuyer < immigrants.size() && weapons.size() != 0; exactBuyer++) {
            for (int i = 0; i < 5; i++) {
                if (immigrants.get(exactBuyer) instanceof Extremist) {
                    ((Extremist) immigrants.get(exactBuyer)).buyGun(weapons.get(0));
                    weapons.remove(0);
                    //TODO: fix later
                    if (immigrants.get(exactBuyer).getBorderMoney() == 0) {
                        immigrants.remove(exactBuyer);
                    }

                } else if (immigrants.get(exactBuyer) instanceof Radical) {
                    int index = 0;
                    while (weapons.get(index).equals(Weapon.BOMB)) {
                        index++;
                        if (weapons.size() >= index) {
                            break;
                        }
                    }
                    ((Radical) immigrants.get(exactBuyer)).buyGun(weapons.get(index));
                    weapons.remove(index);

                } else {
                    break; // it's normal immigrant
                }

                if (weapons.size() == 0) {
                    break;
                }
            }
        }
    }

    private static void createWeapons(List<Weapon> weapons) {
        for (int i = 0; i < NUMBER_OF_WEAPONS; i++) {
            int rnd = new Random().nextInt(3) + 1;
            Weapon weapon = rnd == 1 ? Weapon.GUN : ((rnd == 2) ? Weapon.AUTOMATE : Weapon.BOMB);
            weapons.add(weapon);
        }
    }

    private static LinkedList<Immigrant> createImmigrants(City[] cities) throws PassportException {
        final String[] names = {"Zhlab", "DzinDjan", "Djafira", "Stanka", "Gergina", "Stefka", "Radka", "Pesho", "Gosho", "Andrelius", "Kasandra", "Armira", "Penelope"};
        LinkedList<Immigrant> immigrants = new LinkedList<>();

        for (int i = 0; i < NUMBER_OF_IMMIGRANTS; i++) {
            Passport passport;
            Immigrant immigrant;

            if (Math.random() > 0.45) {
                passport = getPassport(names);
                immigrant = new Normal(passport, cities[new Random().nextInt(cities.length - 1)], new Random().nextInt(5600) + 1000);

            } else if (Math.random() > 0.35) {
                immigrant = new Extremist(new Random().nextInt(560000) + 1000, cities[new Random().nextInt(cities.length - 1)]);

            } else {
                if (Math.random() <= 0.35) {
                    immigrant = new Radical(getPassport(names), cities[new Random().nextInt(cities.length - 1)], new Random().nextInt(5600) + 1000);
                } else {
                    immigrant = new Radical(getPassport(), cities[new Random().nextInt(cities.length - 1)], new Random().nextInt(3000) + 1000);
                }
            }
            immigrants.add(immigrant);
        }
        return immigrants;
    }

    private static Passport getPassport() throws PassportException {
        Passport passport;
        passport = new Passport("missing", (short) 0, "missing");
        return passport;
    }

    private static Passport getPassport(String[] names) throws PassportException {
        Passport passport;
        passport = new Passport(names[new Random().nextInt(names.length - 1)],
                (short) (new Random().nextInt(MAX_YEARS_IMMIGRANT) + MIN_YEARS_IMMIGRANT), citiesSudan[new Random().nextInt(citiesSudan.length - 1)] + ", Sudan ");
        return passport;
    }
}
