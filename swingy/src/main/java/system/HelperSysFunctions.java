package system;

import java.util.Scanner;

public class HelperSysFunctions {
    public static Integer scannerMatchIntNextLine(Scanner scanner, Integer rangeMin, Integer rangeMax){
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.matches("\\s*[" + rangeMin + "-" + rangeMax + "]\\s*")) {
                Integer result = Integer.parseInt(str);
                System.out.println("You entered: " + result);
                return  result;
            } else {
                System.out.println("Enter 1 or 2!");
            }
        }
        return (0);
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
