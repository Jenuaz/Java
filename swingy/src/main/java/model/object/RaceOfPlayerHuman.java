package model.object;

import model.equipment.Equipment;
import model.object.service.HeroStats;

public class RaceOfPlayerHuman extends Player{
    public RaceOfPlayerHuman(String type, String hero, HeroStats heroStatistics, Equipment art) {
        super(hero, heroStatistics, art);
    }
}
