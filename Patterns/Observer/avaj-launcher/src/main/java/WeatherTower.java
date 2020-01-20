import java.util.List;

public class WeatherTower extends Tower {
    private String name;

    public WeatherTower() {
        this.name = "Weather Tower.";
    }

    public WeatherTower(String name)
    {
        this.name = name;
    }

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        List<Flyable> list = this.getListAircraftsRegistered();
        this.conditionsChanged();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).flyOrLand() == false) {
                this.unregister((Flyable) list.get(i));
                System.out.println("Object was removed from " + this.getName());
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
