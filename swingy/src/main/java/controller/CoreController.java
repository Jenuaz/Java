package controller;

import model.object.Player;
import model.race_enemy.RaceModel;
import system.WorldMap;
import system.RFile;
import view.console.Display;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
public class CoreController {

        public CoreController() {

        }

        public static boolean luck() {
            Random rand = new Random();
            int l = rand.nextInt(2) + 1;
            if (l == 1) {
                return true;
            }
            return false;
        }

        public static void go(Player player) throws IOException {
            WorldMap map = new WorldMap(player);
            map.showGameField();
            Display.showAvailableDirections();
            Console console;
            console = System.console();

            while (true) {
               // String str = console.readLine();
                int tmp = 0;
                BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Hello. Please write your name: ");
                String name = str.readLine();
                System.out.println("Your name is: "+name);
                tmp = Integer.parseInt(name);
                if (tmp > 0 && tmp <= 5) { //str.matches("\\s*[1-5]\\s*")
                    int dir = tmp;
                    if (dir == 1) {
                        map.updatePlayerPos(1, 0);
                        map.showGameField();
                        Display.showAvailableDirections();
                    } else if (dir == 2) {
                        map.updatePlayerPos(0, 1);
                        map.showGameField();
                        Display.showAvailableDirections();
                    } else if (dir == 3) {
                        map.updatePlayerPos(0, -1);
                        map.showGameField();
                        Display.showAvailableDirections();
                    } else if (dir == 4) {
                        map.updatePlayerPos(-1, 0);
                        map.showGameField();
                        Display.showAvailableDirections();
                    } else if (dir == 5) {
                        System.exit(0);
                    }
                } else {
                    System.out.println("Invalid option.");
                }
            }
        }

        public static int fight(Player player, RaceModel villian) {
            Random rand = new Random();
            int fi = 0;
            int success = 0;
            int shot = 0;

            if (luck() == true || player.getHeroStats().getPow() > villian.getPow()) {
                fi = 1;
            }
            if (player.getHeroStats().getHitp() > 0) {
                while (player.getHeroStats().getHitp() > 0 && villian.getHitp() > 0) {
                    System.out.println("Your hero hit points: " + player.getHeroStats().getHitp());
                    System.out.println("Villian hit points: " + villian.getHitp());

                    if (fi == 0) {
                        shot = rand.nextInt(30) + 1;
                        if (villian.getHitp() > 0) {
                            player.getHeroStats().setHitp(-shot);
                            RFile.refreshFile(player);
                            System.out.println("You've been attacked. You've lost" + shot + " hit points.");
                            if (player.getHeroStats().getHitp() <= 0) {
                                success = 0;
                                break ;
                            }
                            fi = 1;
                        }
                    } else if (fi == 1) {
                        shot = rand.nextInt(50) + 1;
                        if (player.getHeroStats().getHitp() > 0) {
                            villian.setHitp(-shot);
                            System.out.println("You damaged your enemy with " + shot + "points.");
                            if (villian.getHitp() <= 0) {
                                success = 1;
                                break;
                            }
                            fi = 0;
                        }
                    }
                }
            } else {
                System.out.println("You are too weak to fight!\n");
                System.out.println("Your HP is: " + player.getHeroStats().getHitp());
            }
            return success;
        }



    }
