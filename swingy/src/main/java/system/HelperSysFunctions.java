package system;

import java.util.Scanner;

public class HelperSysFunctions {
    public static Integer scannerMatchIntNextLine(Scanner scanner, Integer rangeMin, Integer rangeMax){
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.matches("\\s*[" + rangeMin + "-" + rangeMax + "]\\s*")) {
                return  Integer.parseInt(str);
            } else {
                System.out.println("Enter 1 or 2!");
            }
        }
        return (0);
    }
}
