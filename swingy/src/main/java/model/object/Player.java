package model.object;


import model.equipment.Equipment;
import model.object.service.HeroStats;
import javax.validation.constraints.NotNull;

public class Player {

    @NotNull
    private String hero;

    @NotNull
    private Equipment art;

    @NotNull
    private HeroStats heroStats = new HeroStats();


    public Player() {

    }


    protected Player(String hero, HeroStats heroStats, Equipment art) {
        this.hero = hero;
        this.heroStats = heroStats;
        this.art = art;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getHero() {
        return this.hero;
    }

    public HeroStats getHeroStats() {
        return this.heroStats;
    }

    public Equipment getArt() {
        return art;
    }

    public void setArt(Equipment art) {
        this.art = art;
    }

    public void setHeroStats(HeroStats heroStats) {
        this.heroStats = heroStats;
    }


}