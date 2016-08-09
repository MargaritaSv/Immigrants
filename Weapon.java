package immigrants;

/**
 * Created by Magi on 9.8.2016 г..
 */
public enum Weapon {
    GUN(50), AUTOMATE(1500), BOMB(300);

    private int cost;

    Weapon(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
