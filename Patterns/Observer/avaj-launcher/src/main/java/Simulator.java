import java.io.IOException;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    static void runSimulation(WeatherTower currentWeatherTower, int limits) {
        int iter = 0;

        while (iter++ < limits)
            currentWeatherTower.changeWeather();
    }

    static void registerEach(WeatherTower tpm, List<Flyable> listOfAircrafts)
    {
        for (Flyable tmp : listOfAircrafts) {
            //We register tower to aircraft.
            tmp.registerTower(tpm);
            //Register aircraft to tower.
            tpm.register(tmp);
        }
    }

    public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        //  Create an Weather Tower.
        //  Integer numberOfCopies = 10;
        int testr = 0;
        Simulator weaterForecast = new Simulator();
        List<Flyable> listOfAircrafts = new ArrayList<Flyable>();
        Core scenario = new Core("C:\\Users\\y.lisyak\\Desktop\\test2.txt", listOfAircrafts);
        WeatherTower tpm = new WeatherTower("Tramp Tower");
        //WeatherTower tpmTwo = new WeatherTower();
        //Create Aircraft Factory which produce helicopters, baloons and JetPlanes.
        AircraftFactory test = new AircraftFactory();
        //Variable which will receive and complex of functions.
        Logs.setOutputFile("logger.log");
        //Create Aircrafts with coordinats.
        //        for (int i = 0; i < numberOfCopies; i++) {
        //            if ((i % 2) > 0)
        //                listOfAircrafts.add(test.newAircraft("Baloon", "Ball", 10, 20, 30));
        //            else
        //                listOfAircrafts.add(test.newAircraft("Helicopter", "Helicopter", 10, 20, -15));
        //        }
        //        listOfAircrafts.add(test.newAircraft("Helicopter", "H1", 20, 20, 30));
        //        listOfAircrafts.add(test.newAircraft("Baloon", "B1", 20, 20, 30));
        registerEach(tpm, listOfAircrafts);
        //Part how many time to we change the weather
        weaterForecast.runSimulation(tpm, scenario.getSimulationRuns());
    }
}
