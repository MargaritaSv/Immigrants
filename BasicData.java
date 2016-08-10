package immigrants;

/**
 * Created by Magi on 10.8.2016 г..
 */
public abstract class BasicData {
   private String name;
   private City city;

    public BasicData(String name, City city) {
        if (!checkValidation(name)) {
            throw new IllegalArgumentException("The address is not correct!");
        }
        this.name = name;
        
        this.city = city;
    }

    static boolean checkValidation(String input) {
        return input != null || input.trim().length() == 0;
    }

    protected String getName() {
        return name;
    }


}
