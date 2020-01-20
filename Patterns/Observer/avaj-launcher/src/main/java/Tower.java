import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> obs = new ArrayList<Flyable>();

    public Tower() {

    }
    //Function which register out aircraft object in followers list.
    public void register(Flyable flyable) {
        if (!obs.contains(flyable)) {
            obs.add(flyable);
            System.out.println("New object was registerd." + "\n");
            Logs.log("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " registered to weather tower.");
        } else {
            Logs.log("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " already was registered. Additional registration not required.");
        }
    }

    public void unregister(Flyable flyable) {
        if (obs.contains(flyable)) {
            Logs.log("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getId() + ")" + " unregistered from weather tower.");
            obs.remove(flyable);
        }
    }

    public List<Flyable>getListAircraftsRegistered() {
        return obs;
    }

    protected void conditionsChanged() {
        for (Flyable tmp_observers : obs) {
            tmp_observers.updateConditions();
        }
    }
}
