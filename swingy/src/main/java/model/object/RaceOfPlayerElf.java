package model.object;

import model.equipment.Equipment;
import model.object.service.HeroStats;

public class RaceOfPlayerElf extends Player {
    public RaceOfPlayerElf(String type, String hero, HeroStats heroStatistics, Equipment art) {
        super(hero, heroStatistics, art);
    }
}
