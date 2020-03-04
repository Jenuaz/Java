package model.race_enemy;

import model.equipment.Equipment;

public class Elf extends RaceModel {
    public Elf(int lvl, int attack, int protection, int hitp, int exp, Equipment art) {
        super(lvl, attack, protection, hitp, exp, art);
        int idType = 2;
        super.setIdType(idType);
    }
}
