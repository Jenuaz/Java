package view.console;

import controller.CoreController;
import model.object.Player;
import controller.WorldMapController;

public class ConsoleView {
    private Player player;
    private WorldMapController arena;
    //Console accept all main parameters to provide manipulations
    public ConsoleView(Player player, WorldMapController arena)
    {
        this.player = player;
        this.arena = arena;
    }

    public static void consoleVisualize(Player player, WorldMapController map, CoreController game){
        render(map);
    }

    public boolean handleEvent(){
            return true;
    }

    public void update() {
        System.out.println("test");
    }

    public static Integer render(WorldMapController arena) {
        for (int y = 0; y < arena.getYmap(); y++) {
            for (int x = 0; x <  arena.getXmap(); x++) {
                switch (arena.getMap(y, x)) {
                    case 0:
                        System.out.print("|   |");
                        break ;
                    case 1:
                        System.out.print("| m |");
                        break ;
                    case 2:
                        System.out.print("| s |");
                        break ;
                    default:
                        System.out.print("| H |");
                        break ;
                }
            }
            System.out.println(" ");
        }
        return (1);
    }
}
