package model.race_enemy;

import model.equipment.Equipment;

public class Pixy extends RaceModel{

    public Pixy(int lvl, int attack, int protection, int hitp, int exp, Equipment art) {
        super(lvl, attack, protection, hitp, exp, art);
        int idType = 3;
        super.setIdType(idType);
    }
}
