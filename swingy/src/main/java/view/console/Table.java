package view.console;
import model.object.Player;

import javax.swing.text.PlainView;
import java.util.Scanner;

public class Table {

        public static int showInfo(long ch, String hero, Player player) {
            char eol = '\n';
            System.out.println("Welcome to SWINGY!\n\n" + hero + ", your statistics: ");

            if (ch == 1) {
                System.out.println("Your choice is HUMAN: " + eol);
                System.out.println("Lvl: " + player.getHeroStats().getLvl() + eol + "Attack: " + player.getHeroStats().getAttack() + eol +
                        "Protection: " + player.getHeroStats().getProtection() + eol + "Exp: " + player.getHeroStats().getExp() + eol +
                        "Hit Points: " + player.getHeroStats().getHitp() + eol + "Artif: " + player.getArt().getArtType() + eol + eol);
                chooseStartExit();
            } else if (ch == 2) {
                System.out.println("Your choice is UNDEAD: " + eol);
                System.out.println("Lvl: " + player.getHeroStats().getLvl() + eol + "Attack: " + player.getHeroStats().getAttack() + eol +
                        "Protection: " + player.getHeroStats().getProtection() + eol + "Exp: " + player.getHeroStats().getExp() + eol +
                        "Hit Points: " + player.getHeroStats().getHitp() + eol + "Artif: " + player.getArt().getArtType() + eol + eol);
                chooseStartExit();
            }
            int check = 0;
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.matches("\\s*[1-2]\\s*")) {
                    check = Integer.parseInt(str);
                    break;
                } else {
                    System.out.println("Choose from given options.");
                }
            }
            return check;
        }

        public static void chooseStartExit() {
            System.out.println("1. Start swingy.\n2. Exit swingy.");
        }

}