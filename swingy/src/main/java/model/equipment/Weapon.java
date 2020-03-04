package model.equipment;

public class Weapon extends Equipment{
    private int attackType = 80;

    public Weapon(String attackType) {
        super(attackType);
    }

    public int getAttackType() {
        return this.attackType;
    }
}
