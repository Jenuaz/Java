public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    private int mostValuedWeather(int... value) {
        int max = 0;
        int iterator = 0;
        int index = 0;

        for(int tmp: value) {
            if (tmp > max) {
                max = tmp;
                index = iterator;
            } else if (tmp == max){
                return (3);
            }
            iterator++;
        }
        return index;
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[mostValuedWeather(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight())];
    }
}
