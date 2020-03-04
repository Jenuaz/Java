package model.object;


import model.equipment.Equipment;
import model.object.service.HeroStats;
import javax.validation.constraints.NotNull;

public class Player {

    public Player() {

    }

    @NotNull
    private Equipment art;

    @NotNull
    private HeroStats heroStats = new HeroStats();

    @NotNull
    private String newPlayer;


    protected Player(String newPlayer, HeroStats heroStats, Equipment art) {
        this.newPlayer = newPlayer;
        this.heroStats = heroStats;
        this.art = art;
    }

    public String getNewPlayer() {
        return this.newPlayer;
    }

    public HeroStats getHeroStats() {
        return this.heroStats = heroStats;
    }

    public Equipment getArt() {
        return art;
    }

    public void setArt(Equipment art) {
        this.art = art;
    }


}