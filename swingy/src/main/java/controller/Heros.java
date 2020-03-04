package controller;

import model.equipment.Armor;
import model.equipment.Equipment;
import model.equipment.Helmet;
import model.equipment.Weapon;
import model.object.Player;
import model.object.RaceOfPlayerElf;
import model.object.RaceOfPlayerHuman;
import model.object.service.HeroStats;
import model.race_enemy.Elf;
import model.race_enemy.Orc;
import model.race_enemy.RaceModel;

import java.util.Random;

public class Heros {
    public static Player newHero(String hero, String player, HeroStats heroStatistics, Equipment art) {
        if (hero.equals("Human")) {
            return new RaceOfPlayerHuman(player, heroStatistics, art);
        } else if (hero.equals("Elf")) {
            return new RaceOfPlayerElf(player, heroStatistics, art);
        } else {
            return null;
        }
    }

    public static RaceModel newVillian(Player player) {
        Random rand = new Random();
        int enemy = rand.nextInt(2) + 1;
        String artif = Equipment.randomArt();
        int lvl = 0;
        int attack = 0;
        int protection = 0;
        int exp = 0;
        int hitp = 0;

        if (enemy == 1) {
            if (artif.equals("HELM")) {
                Helmet h = new Helmet("Helm");
                lvl = player.getHeroStats().getLvl();
                attack = h.getHitPointAmount() + 100;
                protection = 100;
                hitp = 100;
                exp = 0;
                return (new Orc(lvl, attack, protection, hitp, exp, h));
            } else if (artif.equals("WEAPON")) {
                Weapon w = new Weapon("Weapon");
                lvl = player.getHeroStats().getLvl();
                attack = 100 + w.getAttackType();
                protection = 100;
                hitp = 100;
                exp = 0;
                return (new Orc(lvl, attack, protection, hitp, exp, w));
            } else if (artif.equals("ARMOR")) {
                Armor armor = new Armor("Armor");
                lvl = player.getHeroStats().getLvl();
                attack = 100;
                protection = armor.getProtection();
                hitp = 100;
                exp = 0;
                return (new Orc(lvl, attack, protection, hitp, exp, armor));
            }
        } else if (enemy == 2) {
            if (artif.equals("HELM")) {
                Helmet h = new Helmet("Helm");
                lvl = player.getHeroStats().getLvl();
                attack = h.getHitPointAmount() + 100;
                protection = 100;
                hitp = 100;
                exp = 0;
                return (new Elf(lvl, attack, protection, hitp, exp, h));
            } else if (artif.equals("WEAPON")) {
                Weapon w = new Weapon("Wwapon");
                lvl = player.getHeroStats().getLvl();
                attack = w.getAttackType() + 100;
                protection = 100;
                hitp = 100;
                exp = 0;
                return (new Elf(lvl, attack, protection, hitp, exp, w));
            } else if (artif.equals("ARMOR")) {
                Armor armor = new Armor("Armor");
                lvl = player.getHeroStats().getLvl();
                attack = 100;
                protection = armor.getProtection() + 100;
                hitp = 100;
                exp = 0;
                return (new Elf(lvl, attack, protection, hitp, exp, armor));
            }
        }
        return null;
    }
}
