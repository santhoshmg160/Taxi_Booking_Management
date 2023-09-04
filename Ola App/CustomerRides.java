import java.util.ArrayList;
import java.util.HashMap;

public class CustomerRides {
    static HashMap<Integer, ArrayList<CustomerRides>> customerRides = new HashMap<>();
    private String name;
    private String vehicleNo;
    private String currentLoc;
    private String dropLoc;

    CustomerRides(String name, String vehicleNo, String currentLoc, String dropLoc) {
        this.name = name;
        this.vehicleNo = vehicleNo;
        this.currentLoc = currentLoc;
        this.dropLoc = dropLoc;
    }

    CustomerRides() {

    }

    void setCustomerRides(int id, String name, String vehicleNo, String currentLoc, String dropLoc) {
        if (customerRides.containsKey(id)) {
            ArrayList<CustomerRides> rideList = customerRides.get(id);
            int index = rideList.size();
            rideList.add(index, new CustomerRides(name, vehicleNo, currentLoc, dropLoc));
            customerRides.put(id, rideList);
        } else {
            ArrayList<CustomerRides> rides = new ArrayList<>();
            rides.add(0, new CustomerRides(name, vehicleNo, currentLoc, dropLoc));
            customerRides.put(id, rides);
        }
    }

    static void disPlayAllRides(int id) {
        if(customerRides.containsKey(id)) {
            ArrayList<CustomerRides> rideList = customerRides.get(id);
            for(CustomerRides x : rideList) {
                System.out.println(x);
            }
        } else {
            System.out.println("Customer id: " + id + " is not found");
        }
    }

    public String toString() {
        return name + " " + vehicleNo + " " +  currentLoc + " " + dropLoc;
    }
}
