package view.console;
import model.object.Player;
import system.HelperSysFunctions;

import java.util.Scanner;

public class Table {

        public static int showInfo(Player player) {
            System.out.println("Welcome to SWINGY!\n\n" + player.getHero() + ", your statistics: ");

            if (player.getHeroStats().getType().equals("Human")) {
                System.out.println("Your choice is HUMAN: " + "\n");
                System.out.println("Lvl: " + player.getHeroStats().getLvl() + "\n" + "Attack: " + player.getHeroStats().getAttack() + "\n" +
                        "Protection: " + player.getHeroStats().getProtection() + "\n" + "Exp: " + player.getHeroStats().getExp() + "\n" +
                        "Hit Points: " + player.getHeroStats().getHitp() + "\n" + "Artif: " + player.getArt().getArtType() + "\n" + "\n");
                chooseStartExit();
            } else if (player.getHeroStats().getType().equals("Undead")) {
                System.out.println("Your choice is UNDEAD: " + "\n");
                System.out.println("Lvl: " + player.getHeroStats().getLvl() + "\n" + "Attack: " + player.getHeroStats().getAttack() + "\n" +
                        "Protection: " + player.getHeroStats().getProtection() + "\n" + "Exp: " + player.getHeroStats().getExp() + "\n" +
                        "Hit Points: " + player.getHeroStats().getHitp() + "\n" + "Artif: " + player.getArt().getArtType() + "\n" + "\n");
                chooseStartExit();
            }
            Scanner scanner = new Scanner(System.in);
            return HelperSysFunctions.scannerMatchIntNextLine(scanner, 1, 2);
        }

        public static void chooseStartExit() {
            System.out.println("1. Start swingy.\n2. Exit swingy.");
        }

}