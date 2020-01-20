
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;


public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longtitude, int latitude, int height) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String typesForCompare[] = new String[]{"Baloon", "JetPlane", "Helicopter"};
        List<String> list = Arrays.asList(typesForCompare);

        if (list.contains(type))
        {
            try{
                Class <?> refClass = Class.forName(type);
                Constructor <?> refConstructor = refClass.getConstructor(String.class, Coordinates.class);
                Object aircraftInkType = refConstructor.newInstance(name, new Coordinates(longtitude, latitude, height));
                System.out.println("New aircraft was created: " + aircraftInkType.getClass());
                return (Flyable)aircraftInkType;
            } catch (NoSuchMethodException e){
                System.out.println("Something wrong: " + e.getMessage() + " " + e.getCause());
            }
        }
        return null;
    }
}
