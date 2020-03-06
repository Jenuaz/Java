import controller.CoreController;
import system.HelperChatFunctions;
import system.HelperSysFunctions;
import system.RFile;
import view.console.Display;
import view.console.Table;
import view.gui.SwingyView;

import java.io.IOException;
import java.util.Scanner;

import static system.CreateOrDownloadPlayer.CREATE_PLAYER;
import static system.CreateOrDownloadPlayer.DOWNLOAD_PLAYER;

public class Main {

    public static void main(String[] args) throws IOException {
        Integer option = 0;
        String[] heroArrayTyps = {"Undead", "Human"};
        Integer createOrDownloadPlayer = 0;

        HelperChatFunctions.messageWelcome();
        if (args.length != 1) {
                System.out.println("Usage: java -jar swingy.jar [gui/console]");
                System.exit(1);
        }

        //initialize player and world
        CoreController game = new CoreController(args[0]);
        while (!game.viewType.equals("Game Over")) {
            HelperChatFunctions.messageTypeView();
            createOrDownloadPlayer = Display.createOrDownloadHero();
            if (createOrDownloadPlayer == CREATE_PLAYER.getValue()) {
                game.getPlayer().setHero(Display.greetPlayer());
                game.getPlayer().getHeroStats().setType(heroArrayTyps[Display.printHeroList() - 1]);


                game.setPlayer(SwingyView.determinePlayer(game.getPlayer().getHeroStats().getType(), game.getPlayer().getHero()));
                System.out.println(game.getPlayer().getHeroStats().getType() + " was setted up");

                Integer start = Table.showInfo(game.getPlayer());

                if (start == 1) {
                    CoreController.go(game.getPlayer(), game.getArena());
                } else {
                    HelperChatFunctions.systemOutPutCondition("Thanks for playing!");
                    System.exit(0);
                }
            } else if (createOrDownloadPlayer == DOWNLOAD_PLAYER.getValue()) {
                System.out.println("Loaded player.");
                RFile.getBaseOfPlayers();

                Scanner scanner = new Scanner(System.in);

                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    int linesNbr = RFile.getLinesInFile();
                    if (HelperSysFunctions.isNbr(str) == true) {
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
                    game.setPlayer(SwingyView.DBPlayer(RFile.getPlayer(option)));
                    CoreController.go(game.getPlayer(), game.getArena());
                }
            }
            System.out.println("In box" + game.getPlayer().getHeroStats());

            game.executeGameInfLoop();
        }

//        try {
//            WriteToFile.create();
//
//            if (args.length != 1) {
//                System.out.println("Usage: java -jar swingy.jar [gui/console]");
//                System.exit(1);
//            }
//
//            if (args[0].equals("console")) {
////                System.out.println("Console View!");
//                Console.start();
//            } else {
//                GUI gui = new GUI();
//                gui.displayGUI();
//            }
//        } finally {
//            WriteToFile.close();
//        }
//
//    }
    }
}