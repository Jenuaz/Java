package controller;

import model.object.Player;
import model.race_enemy.RaceModel;
import system.HelperChatFunctions;
import system.RFile;
import view.console.ConsoleView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WorldMapController {

        private static int size;
        private static int[][] map;
        private int villianNbr;

        private int xCoordinate;
        private int yCoordinate;

        private static int xmap;
        private static int ymap;

        private boolean set = false;
        private int lvl;

        private static Player player;
        private RaceModel villian = new RaceModel();

        private static ArrayList<RaceModel> villianArray = new ArrayList<RaceModel>();
        private static ArrayList<RaceModel> tmpArray = new ArrayList<RaceModel>();

        public WorldMapController() {

        }

        public WorldMapController(Player player) {
            this.player = player;
        }

        public void setEnemies() {
            switch (this.villianNbr = player.getHeroStats().getLvl() * 8) {

            }
        }

        public static void setMap() {
            size = (player.getHeroStats().getLvl() - 1) * 5 + 10 - (player.getHeroStats().getLvl() % 2);
            xmap = size;
            ymap = size;
            map = new int[size][size];
        }

        public void setPlayerPosition() {
            int x = 0;
            int y = 0;
            if ((size % 2) == 1) {
                x = (int)(size / 2);
                y = (int)(size / 2);
            } else if ((size % 2) == 0) {
                x = (size / 2);
                y = (size / 2);
            }
            this.xCoordinate = x;
            this.yCoordinate = y;
        }

        public void victory() throws IOException {
            if (player.getHeroStats().getExp() > 1000 && player.getHeroStats().getExp() < 2450) {
                this.lvl = 1;
            } else if (player.getHeroStats().getExp() >= 2450 && player.getHeroStats().getExp() < 4800) {
                this.lvl = 2;
            } else if (player.getHeroStats().getExp() >= 4800 && player.getHeroStats().getExp() < 8050) {
                this.lvl = 3;
            } else if (player.getHeroStats().getExp() >= 8050 && player.getHeroStats().getExp() < 12200) {
                this.lvl = 4;
            } else if (player.getHeroStats().getExp() == 12200) {
                this.lvl = 5;
            }

            if (this.lvl > player.getHeroStats().getLvl()) {
                player.getHeroStats().setLvl(this.lvl);
                RFile.refreshFile(player);
                System.out.println("You're victorious!\n\n");
                System.out.println("1. Continue playing.\n2. Exit swingy.\n");
                Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (str.matches("\\s*[1-2]\\s*")) {
                        int ch = Integer.parseInt(str);
                        if (ch == 1) {
                            villianArray.removeAll(villianArray);
//                            CoreController.go(player);
                            System.out.println("Continua playing.");
                        } else if (ch == 2) {
                            System.out.println("Thanks for playing SWINGY!\n\n");
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Select 1 or 2!");
                    }
                }
            } else if (this.lvl == player.getHeroStats().getLvl()) {
                villianArray.removeAll(villianArray);
            }
        }

        public void upgrdExp(int type) {
            if (type == 1) {
                int exp;
                if (player.getHeroStats().getExp() < 2450) {
                    exp = 2450;
                    player.getHeroStats().setExp(exp);
                } else if (player.getHeroStats().getExp() < 4800) {
                    exp = 4800;
                    player.getHeroStats().setExp(exp);
                } else if (player.getHeroStats().getExp() > 8050) {
                    exp = 8050;
                    player.getHeroStats().setExp(exp);
                } else if (player.getHeroStats().getExp() < 12200) {
                    exp = 12200;
                    player.getHeroStats().setExp(exp);
                } else if (player.getHeroStats().getExp() < 12201) {
                    System.out.println("     GAME ENDED     \n\n");
                    System.exit(0);
                }
//            victory();
            } else if (type == 2) {
                player.getHeroStats().setExp(player.getHeroStats().getExp() + villian.getPow());
                RFile.refreshFile(player);
//            victory();
            }
        }

        public static void regEnemy(RaceModel villian) {
            if (villianArray.contains(villian)) {
                return ;
            }
            villianArray.add(villian);
        }

        public static void deleteEnemy(RaceModel villian) {
            if (villianArray.contains(villian)) {
                villianArray.remove(villian);
            }
        }

        public void createEnemies() {
            for (int i = 0; i < this.villianNbr; i++) {
                Random rand = new Random();
                int enemyPosX = rand.nextInt(size);
                int enemyPosY = rand.nextInt(size);
                while (enemyPosY == this.yCoordinate || enemyPosX == this.xCoordinate) {
                    enemyPosX = rand.nextInt(size);
                    enemyPosY = rand.nextInt(size);
                }
                villian = Heros.newVillian(player);
                if (villian != null) {
                    villian.setVillianPosition(enemyPosX, enemyPosY);
                    regEnemy(villian);
                }
            }
        }

        public RaceModel getEnemyCollision() {
            for (int i = 0; i < villianArray.size(); i++) {
                if (villianArray.get(i).getyCoordinate() == this.yCoordinate && villianArray.get(i).getxCoordinate() == this.xCoordinate) {
                    return (villianArray.get(i));
                }
            }
            return null;
        }

        public void showGameField() {

            if (set == false) {
                setMap();
                setPlayerPosition();
                setEnemies();
                if (tmpArray.isEmpty()) {
                    createEnemies();
                } else {
                    villianArray.addAll(tmpArray);
                }
                set = true;
            }

            //initialize map array to zeros
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    map[y][x] = 0;
                }
            }

            // initialize villians
            for (RaceModel enemy : villianArray) {
                map[enemy.getyCoordinate()][enemy.getxCoordinate()] = enemy.getIdType();
            }

            //initialize hero
            map[this.yCoordinate][this.xCoordinate] = 4;

            // check collision with enemy
            for (RaceModel villian : villianArray) {
            boolean collision = enemyCollision(this.xCoordinate, this.yCoordinate, villian.getyCoordinate(), villian.getxCoordinate());
                if (collision == true) {
                    System.out.println("Fight");
                    break ;
                }
            }

//            System.out.println("LEVEL: " + player.getHeroStats().getLvl() + " | " + "Attack: " + player.getHeroStats().getAttack() + " | " +
//                    "Protection: "+ player.getHeroStats().getProtection() + " | " + "Hit Points: " + player.getHeroStats().getHitp() + " | " +
//                    "Exp: " + player.getHeroStats().getExp() + "\n\n");

            ConsoleView.render(this);
        }

        public void updatePlayerPos(int xpos, int ypos) throws IOException {
            int previousX = this.xCoordinate;
            int previousY = this.yCoordinate;
            this.xCoordinate += xpos;
            if (this.xCoordinate < 0) {
                this.xCoordinate = (int)(size / 2);
                upgrdExp(1);
                victory();
                set = false;
                showGameField();
            } else if (this.xCoordinate >= this.size) {
                this.xCoordinate = (int)(size / 2);
                upgrdExp(1);
                victory();
                set = false;
                showGameField();
            } else {
                showGameField();
            }

            this.yCoordinate += ypos;
            if (this.yCoordinate < 0) {
                this.yCoordinate = (int)(size / 2);
                upgrdExp(1);
                victory();
                set = false;
                showGameField();
            } else if (this.yCoordinate >= this.size) {
                this.yCoordinate = (int)(size / 2);
                upgrdExp(1);
                victory();
                set = false;
                showGameField();
            } else {
                showGameField();
            }
        }

        public boolean enemyCollision(int heroY, int heroX, int villianY, int villianX) {
            if ((heroX == villianX) && (heroY == villianY)) {
                System.out.println("You faced a villian, what you gonna to do: \n");
                System.out.println("1. Run.\n2. Fight.\n");
                Scanner scanner = new Scanner(System.in);

                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (str.matches("\\s*[1-2]\\s*")) {
                        int ch = Integer.parseInt(str);
                        if (ch == 1) {
                            Random rand = new Random();
                            int go = rand.nextInt(2) + 1;
                            if (go == 1) {
                                System.out.println("You're a coward! You loose 5XP\n");
                                System.out.println("Your XP: " + (player.getHeroStats().getExp() - 5));
                                showGameField();
                            }
                        } else if (ch == 2) {
                            RaceModel collided = getEnemyCollision();
                            int victorious = 0;
//                        int victorious = GameControll.fight(player, collided);
                            if (victorious == 1) {
//                            victorious(collided);
                                deleteEnemy(collided);
                                return true;
                            } else {
                                HelperChatFunctions.messageEndOfGame();
                                break ;
                            }
                        } else {
                            System.out.println("Choose 1 or 2!");
                        }
                    } else {
                        System.out.println("Choose 1 or 2!");
                    }
                }
            }
            return false;
        }

        public void battle(RaceModel collided) {
            villianArray.remove(collided);
            upgrdExp(2);
        }


    public static int getXmap() {
        return xmap;
    }

    public static int getYmap() {
        return ymap;
    }

    public static Integer getMap(Integer x, Integer y) {
        return map[y][x];
    }
}
