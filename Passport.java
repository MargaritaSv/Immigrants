package immigrants;

import immigrants.exceprions.PassportException;

/**
 * Created by Magi on 9.8.2016 г..
 */
public class Passport {
    private String name;
    private short years;
    private String bornAddress;

    public Passport(String name, short years, String bornAddress) throws PassportException {
        if (!checkValidation(name)) {
            throw new PassportException("The address is not correct!");
        }
        this.name = name;

        if (years > 115) {
            throw new PassportException("The years for percent " + name + " are nit correct!");
        }
        this.years = years;

        if (!checkValidation(bornAddress)) {
            throw new PassportException("The address is not correct!");
        }
        this.bornAddress = bornAddress;
    }

    public String getName() {
        return name;
    }

    private boolean checkValidation(String input) {
        return input != null || input.trim().length() == 0;
    }

    @Override
    public String toString() {
        return "\nName: " + this.getName() + " years: " + (this.years == 0 ? "missing" : this.years) + "\nBorn: " + this.bornAddress;
    }
}
