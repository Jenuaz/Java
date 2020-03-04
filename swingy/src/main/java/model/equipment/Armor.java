package model.equipment;

public class Armor extends Equipment {

        private int protection = 100;

        public Armor(String armorType) {
            super(armorType);
        }

        public int getProtection() {
            return this.protection;
        }
}
