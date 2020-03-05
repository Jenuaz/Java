package model.equipment;

public class Helmet extends Equipment{

    private int hitPoints = 80;

    public Helmet(String hitPoints) {
        super(hitPoints);
    }

    public int getHitPoints() {
        return this.hitPoints;
    }
}
