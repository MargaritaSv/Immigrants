package immigrants;

/**
 * Created by Magi on 6.8.2016 г..
 */
public abstract class NamesGeographic {
    String name;

    public NamesGeographic(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("The name missing");
        }
        this.name = name;
    }
}
