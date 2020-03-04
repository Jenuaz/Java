package model.equipment;
import java.util.Random;

public class Equipment {

        private String artType;
        private static final String[] arts = {"WEAPON", "ARMOR", "HELMET"};

        Equipment(String artType) {
            this.artType = artType;
        }

        public static String randomArt() {
            Random rand = new Random();
            return (arts[rand.nextInt(3)]);
        }


        public static String[] getArts() {
            return arts;
        }

        public String getArtType() {
            return this.artType;
        }

}
