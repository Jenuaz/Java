import java.sql.Struct;

public interface Flyable {
    int k = 4;

    void    updateConditions();
    void    registerTower(WeatherTower weatherTower);
    String  getType();
    String  getName();
    public  long getId();
    public  Boolean flyOrLand();
    public  Coordinates changeCoordinates(String option, Coordinates coordinatesError);
}
