package view.console;
import system.HelperChatFunctions;
import system.HelperSysFunctions;

import java.util.Scanner;


public class Display  extends Table {

        public static String greetPlayer() {
            System.out.println("Enter your hero name to continue: \n");
            String hero = " No Name ";
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                hero = scanner.nextLine();
                if (!hero.isEmpty())
                    break ;
            }
            System.out.println("Your name is :" + hero);
            return hero;
        }

        public static int createOrDownloadHero() {
            HelperChatFunctions.messageCreateOrSelectHero();
            Scanner scanner = new Scanner(System.in);
            return HelperSysFunctions.scannerMatchIntNextLine(scanner, 1, 2);
        }

        public static int printHeroList() {
            Scanner scanner = new Scanner(System.in);

            HelperChatFunctions.messageRaceOption();
            return HelperSysFunctions.scannerMatchIntNextLine(scanner, 1, 2);
        }

        public static void showAvailableDirections() {
            System.out.println("\n     Directions:     \n");
            System.out.println("1. North.\n2. South.\n3. West.\n4. East.\n5. Exit swingy.\n");
        }

}
