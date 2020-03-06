package system;

public class HelperChatFunctions {
    public static void messageWelcome(){
        System.out.println("\nWelcome to Swingy game!\n\n");
    }

    public static void messageTypeView(){
        System.out.println("Console view activated.");
    }

    public static void messageEndOfGame() {
        System.out.println("\nYou loose!\n\n");
        System.exit(0);
    }
    public static void messageCreateOrSelectHero() {
        System.out.println("     SWINGY     \n\n");
        System.out.println("1. Create your hero.\n" +
                "2. Select your hero.\n");
    }
    public static void messageRaceOption(){
        System.out.println("Your race is: \n");
        System.out.println("1. Human.\n2. Undead.\n");
    }

    public static void systemOutPutCondition(String condition){
        System.out.println(condition);
    }
}
