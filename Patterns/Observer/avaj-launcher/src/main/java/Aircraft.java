import org.omg.CORBA.SystemException;

import java.util.Random;

public class Aircraft {
    private final String type = "Baloon";
    private final String verbSun[] = {"burning","melts", "flaming", "glowing"};
    private final String verbRain[] = {"shower off", "bucket", "bolting"};
    private final String verbSnow[] = {"frozing", "blowing"};
    private final String verbFog[] = {"blinding", "whiting", "like a lung full of water drawn"};
    public static final Integer MIN_HEIGH = 0;
    public static final Integer MAX_HEIGH = 100;
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private  static long idCounter = 0;
    protected Boolean flyOrLand = false;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = this.nextId();
        this.name = name;
        if (coordinates.getHeight() > 0)
            flyOrLand = true;
        this.coordinates = coordinates;
        System.out.println("Id " + this.id + " Unique Id was created.");
    }

    public long getId()
    {
        return this.id;
    }

    public String getType() {
        return type;
    }

    public Coordinates getCoordinates() {
        System.out.println(coordinates.getHeight() + "\n");
        System.out.println(coordinates.getLatitude() + "\n");
        System.out.println(coordinates.getLongitude() + "\n");
        return coordinates;
    }

    public void relocateObjectAccordingToChanges(Coordinates newCoordinates) {
        System.out.println(type + " " + name + " was relocated!");
        if (newCoordinates.getHeight() <= 0 || newCoordinates.getLatitude() < 0 || newCoordinates.getLongitude() < 0)
        {
            System.err.println("Coordinates can't be negative number. Check this: ");
            System.err.println("Latitude " + newCoordinates.getLatitude());
            System.err.println("Longtitude " + newCoordinates.getLongitude());
            System.err.println("Height can't be 0 or less: " + newCoordinates.getHeight());
            return;
        }
        this.coordinates = newCoordinates;
    }

    protected String getQuateAccordingToWeather(String weather) {
        switch(weather)
        {
                case "SUN": {
                    System.out.println("Sun is " + this.verbSun[new Random().nextInt(this.verbSun.length)] + " my " + this.getType() + ".");
                    return ("Sun is " + this.verbSun[new Random().nextInt(this.verbSnow.length)] + " my " + this.getType()+ ".");
                }
                case "RAIN": {
                    System.out.println("Rain is  " + this.verbRain[new Random().nextInt(this.verbRain.length)] + " my " + this.getType()+ ".");
                    return ("Rain is  " + this.verbRain[new Random().nextInt(this.verbSnow.length)] + " my " + this.getType()+ ".");
                }
                case "FOG": {
                    System.out.println("Fog is  " + this.verbFog[new Random().nextInt(this.verbFog.length)] + " my " + this.getType()+ ".");
                    return ("Fog is " + this.verbFog[new Random().nextInt(this.verbSnow.length)] + " my " + this.getType()+ ".");
                }
                case "SNOW": {
                    System.out.println("Snow is " + this.verbSnow[new Random().nextInt(this.verbSnow.length)] + " my " + this.getType()+ ".");
                    return ("Snow is " + this.verbSnow[new Random().nextInt(this.verbSnow.length)] + " my " + this.getType()+ ".");
                }
                default: {
                    System.out.println(this.getType());
                    System.out.println("No weather.");
                    return ("Weather " + this.verbSnow[new Random().nextInt(this.verbSnow.length)] + " my " + this.getType()+ ".");
                }
        }
    }

    private long nextId() {
        return ++(Aircraft.idCounter);
    }
}
