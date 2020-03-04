package model.equipment;

public class Helmet extends Equipment{

    private int hitPointAmount = 80;

    public Helmet(String hitPointAmount) {
        super(hitPointAmount);
    }

    public int getHitPointAmount() {
        return this.hitPointAmount;
    }
}
