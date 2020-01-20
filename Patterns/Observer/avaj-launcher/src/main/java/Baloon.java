
import java.lang.String;

public class Baloon extends Aircraft implements Flyable{
    private final String type = "Baloon";

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    private WeatherTower weatherTower = new WeatherTower();

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public Boolean flyOrLand()
    {
        return flyOrLand;
    }

    @Override
    public Coordinates changeCoordinates(String option, Coordinates coordinatesError) {
        switch (option) {
            case "Add":
            {
                this.coordinates.correlateLongitude(coordinatesError.getLongitude());
                this.coordinates.correlateLatitude(coordinatesError.getLatitude());
                this.coordinates.correlateHeight(coordinatesError.getHeight());
                break ;
            }
            case "Set":
            {
                this.coordinates.setLongitude(coordinatesError.getLongitude());
                this.coordinates.setLatitude(coordinatesError.getLatitude());
                this.coordinates.setHeight(coordinatesError.getHeight());
                break ;
            }
            default:
            {
                break ;
            }
        }
        return this.coordinates;
    }

    @Override
    public void updateConditions() {
        Coordinates newCoordinates = this.coordinates;
        String weatherIndicator = weatherTower.getWeather(new Coordinates(
                this.coordinates.getLongitude() + 0,
                this.coordinates.getLatitude() + 0,
                this.coordinates.getHeight() + 0));
        System.out.println("Value before");
        System.out.println("Weather is : " + weatherIndicator);
        System.out.println("Longitude: " +  this.coordinates.getLongitude());
        System.out.println("Latitude: " + this.coordinates.getLatitude());
        System.out.println("Height: " + this.coordinates.getHeight() + "\n");
        System.out.println("Value after " + weatherIndicator + " something here.");
        switch (weatherIndicator)
        {
            case "SUN": {
                newCoordinates = new Coordinates(
                        this.coordinates.getLongitude() + 2,
                        this.coordinates.getLatitude() + 0,
                        (this.coordinates.getHeight() < MAX_HEIGH - 4) ?
                                this.coordinates.getHeight() + 4 : 100
                );
                System.out.println("Longitude: " + newCoordinates.getLongitude());
                System.out.println("Latitude: " + newCoordinates.getLatitude());
                System.out.println("Height: " + newCoordinates.getHeight());
                Logs.log(this.getType() + "#" + this.getName() + "(" + this.getId() + "): " +  this.getQuateAccordingToWeather("SUN"));
                break ;
            }
            case "RAIN": {
                newCoordinates = new Coordinates(
                        this.coordinates.getLongitude() + 0,
                        this.coordinates.getLatitude() + 0,
                        (this.coordinates.getHeight() - 5) > MIN_HEIGH ?
                                this.coordinates.getHeight() - MIN_HEIGH : 0
                );
                System.out.println("Longitude: " + newCoordinates.getLongitude());
                System.out.println("Latitude: " + newCoordinates.getLatitude());
                System.out.println("Height: " + newCoordinates.getHeight());
                Logs.log(this.getType() + "#" + this.getName() + "(" + this.getId() + "): " +  this.getQuateAccordingToWeather("RAIN"));
                break ;
            }
            case "FOG": {
                newCoordinates = new Coordinates(
                        this.coordinates.getLongitude() + 0,
                        this.coordinates.getLatitude() + 0,
                        (this.coordinates.getHeight() - 3) > MIN_HEIGH ?
                                this.coordinates.getHeight() - 3 : 0
                );
                System.out.println("Longitude: " + newCoordinates.getLongitude());
                System.out.println("Latitude: " + newCoordinates.getLatitude());
                System.out.println("Height: " + newCoordinates.getHeight());
                Logs.log(this.getType() + "#" + this.getName() + "(" + this.getId() + "): " +  this.getQuateAccordingToWeather("FOG"));
                break ;
            }
            case "SNOW": {
                newCoordinates = new Coordinates(
                        this.coordinates.getLongitude() + 0,
                        this.coordinates.getLatitude() + 0,
                        (this.coordinates.getHeight() - 15) > MIN_HEIGH ?
                                this.coordinates.getHeight() - 15 : 0
                );
                System.out.println("Longitude: " + newCoordinates.getLongitude());
                System.out.println("Latitude: " + newCoordinates.getLatitude());
                System.out.println("Height: " + newCoordinates.getHeight());
                Logs.log(this.getType() + "#" + this.getName() + "(" + this.getId() + "): " +  this.getQuateAccordingToWeather("SNOW"));
                break ;
            }
            default: {
               newCoordinates = new Coordinates(
                        this.coordinates.getLongitude() + 0,
                        this.coordinates.getLatitude() + 0,
                        this.coordinates.getHeight() + 0);
               System.out.println("No weather.");
            }
        }
        if (newCoordinates.getHeight() == 0 || newCoordinates.getHeight() < 0) {
            Logs.log(this.getType() + "#" + this.getName() + "(" + this.getId() + ")" + " landing.");
            this.flyOrLand = false;
        }
        this.relocateObjectAccordingToChanges(newCoordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
