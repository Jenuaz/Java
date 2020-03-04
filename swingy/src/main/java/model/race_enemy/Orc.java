package model.race_enemy;

import model.equipment.Equipment;

public class Orc extends RaceModel{

    public Orc(int lvl, int attack, int protection, int hitp, int exp, Equipment art) {
        super(lvl, attack, protection, hitp, exp, art);
        int idType = 1;
        super.setIdType(idType);
    }

}
