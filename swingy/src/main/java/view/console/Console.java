package view.console;

import controller.CoreController;
import model.object.Player;
import system.RFile;
import view.gui.SwingyView;

import java.util.Scanner;

public class Console {
    public static void start() {
        String hero;
        Player player;
        int type;
        int option = 0;
        int start;
        int createPlayer;

        try {
            createPlayer = Display.setUpHero();
            if (createPlayer == 1) {
                hero = Display.greetPlayer();
                type = Display.printHeroList();
                player = SwingyView.determinePlayer(hero, type);
                start = Table.showInfo(type, hero, player);

                if (start == 1) {
                    CoreController.go(player);
                } else {
                    System.out.println("\nThanks for visiting my game!\n");
                    System.exit(0);
                }
            } else if (createPlayer == 2) {
                RFile.getBaseOfPlayers();

                Scanner scanner = new Scanner(System.in);

                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    int linesNbr = RFile.getLinesInFile();
                    if (isNbr(str) == true) {
                        try {
                            int ind = Integer.parseInt(str);
                            if (ind > 0 && ind <= linesNbr) {
                                option = ind;
                                break ;
                            }
                        } catch (Exception exception) {
                            System.out.println("Try one more time.");
                        }
                    } else {
                        System.out.println("Try one more time.");
                    }
                    player = SwingyView.DBPlayer(RFile.getPlayer(option));
                    CoreController.go(player);
                }
            }
        } catch (Exception exception) {
            exception.getMessage();
        }
    }

    public static boolean isNbr(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) != true) {
                return false;
            }
        }
        return true;
    }
}
