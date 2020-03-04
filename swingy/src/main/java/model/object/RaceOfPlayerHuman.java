package model.object;

import model.equipment.Equipment;
import model.object.service.HeroStats;

public class RaceOfPlayerHuman extends Player{
    public RaceOfPlayerHuman(String newPlayer, HeroStats heroStatistics, Equipment art) {
        super(newPlayer, heroStatistics, art);
    }
}
