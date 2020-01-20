import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class Core {
    private Scenario tmpOpt;
    private Integer simulationRuns;

    public Core(String path, List<Flyable> listOfAircrafts) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //Part where do we read the file.
        List<Scenario> listOfScens = new ArrayList<Scenario>();
        if (parseTheFile(path, listOfScens)){
            createAnObjects(listOfScens, listOfAircrafts);
        }
    }

    public Boolean parseTheFile(String path, List<Scenario> listOfScens) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        if (st != null) {
            if ((this.simulationRuns = parseInt(st)) > 0) {
                while ((st = br.readLine()) != null) {
                    tmpOpt = new Scenario(st);
                    if (tmpOpt.getValid() == true)
                        listOfScens.add(tmpOpt);
                    else {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private Boolean createAnObjects(List<Scenario> listOfScens, List<Flyable> listOfAircrafts) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        AircraftFactory tmpAircraft = new AircraftFactory();
        for (Scenario tmpScenario:
             listOfScens) {
            listOfAircrafts.add(tmpAircraft.newAircraft(
                    tmpScenario.getType(),
                    tmpScenario.getName(),
                    tmpScenario.getCoords().getHeight(),
                    tmpScenario.getCoords().getLatitude(),
                    tmpScenario.getCoords().getLongitude()));
        }
        return true;
    }

    public Integer getSimulationRuns()
    {
        return this.simulationRuns;
    }
}


