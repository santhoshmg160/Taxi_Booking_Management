import java.util.ArrayList;
import java.util.HashMap;

public class DriverRides {
    static HashMap<Integer, ArrayList<DriverRides>> driverRides = new HashMap<>();
    private String name;
    private long contactNo;
    private String currentLoc;
    private String dropLoc;
    private String feedback = " ";

    DriverRides(String name, long contactNo, String currentLoc, String dropLoc) {
        this.name = name;
        this.contactNo = contactNo;
        this.currentLoc = currentLoc;
        this.dropLoc = dropLoc;
    }

    static void addFeedback(int id, String feedback) {
        ArrayList<DriverRides> rideList = driverRides.get(id);
        DriverRides driver = rideList.get(rideList.size()-1);
        driver.setFeedback(feedback);

    }

    void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    static void setDriverRides(int id, String name, long contactNo, String currentLoc, String dropLoc) {
        if (driverRides.containsKey(id)) {
            ArrayList<DriverRides> rideList = driverRides.get(id);
            int index = rideList.size();
            rideList.add(index, new DriverRides(name, contactNo, currentLoc, dropLoc));
            driverRides.put(id, rideList);
        } else {
            ArrayList<DriverRides> rides = new ArrayList<>();
            rides.add(0, new DriverRides(name, contactNo, currentLoc, dropLoc));
            driverRides.put(id, rides);
        }
    }

    static void disPlayAllRides(int id) {
        if(driverRides.containsKey(id)) {
            ArrayList<DriverRides> rideList = driverRides.get(id);
            for(DriverRides x : rideList) {
                System.out.println(x);
            }
        } else {
            System.out.println("Driver id: " + id + " is not found");
        }
    }

    public String toString() {
        return name + " " + contactNo + " " +  currentLoc + " " + dropLoc + " " + feedback;
    }
}
