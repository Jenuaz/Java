package view.console;
import system.HelperChatFunctions;
import system.HelperSysFunctions;

import java.util.Scanner;


public class Display  extends Table {

        public static String greetPlayer() {
            System.out.println("Enter your hero name to continue: \n");
            String hero = null;
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                hero = scanner.nextLine();
                hero = hero.trim();
                if (hero.length() > 0) {
                    String[] ch = hero.split("\\s");

                    if (ch != null) {
                        hero = String.format("_ %s", ch);
                        break;
                    }
                } else {
                    System.out.println("Enter name!");
                }
            }
            return hero;
        }

        public static int setUpHero() {
            HelperChatFunctions.messageCreateOrSelectHero();
            Scanner scanner = new Scanner(System.in);
            return HelperSysFunctions.scannerMatchIntNextLine(scanner, 1, 2);
        }

        public static int printHeroList() {
            int check = 0;
            Scanner scanner = new Scanner(System.in);

            HelperChatFunctions.messageRaceOption();
            return HelperSysFunctions.scannerMatchIntNextLine(scanner, 1, 2);
        }

        public static void showAvailableDirections() {
            System.out.println("\n     Directions:     \n");
            System.out.println("1. North.\n2. South.\n3. West.\n4. East.\n5. Exit swingy.\n");
        }

}
