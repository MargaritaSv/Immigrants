package immigrants;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Passport {
    String name;
    short years;
    String bornAddress;

    public Passport(String name, short years, String bornAddress) {
        if (!checkValidation(name)) {
            throw new IllegalArgumentException("The address is not correct!");
        }
        this.name = name;

        if (years > 115) {
            throw new IllegalArgumentException("The years for percent " + name + " are nit correct!");
        }
        this.years = years;

        if (!checkValidation(bornAddress)) {
            throw new IllegalArgumentException("The address is not correct!");
        }
        this.bornAddress = bornAddress;
    }

    public String getName() {
        return name;
    }

    private boolean checkValidation(String input) {
        return input != null || input.trim().length() == 0;
    }
}
