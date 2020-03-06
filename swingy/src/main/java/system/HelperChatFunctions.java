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
        System.out.println("     SWINGY     ");
        System.out.println("1. Create your hero.");
        System.out.println("2. Select your hero.");
    }
    public static void messageRaceOption(){
        System.out.println("Your race is: ");
        System.out.println("1. Human.");
        System.out.println("2. Undead.");
    }

    public static void systemOutPutCondition(String condition){
        System.out.println(condition);
    }
}
