
public class Drivers extends Customers {
    private String vehicleNo;
    private String currentLoc;
    private long customerContactNo;

    Drivers(String name, String vehicleNo, String city, long contactNo, String currentLoc) {
        super(name,city,contactNo);
        this.currentLoc = currentLoc;
        this.vehicleNo = vehicleNo;
    }

    public void setCustomerConntactNo(long customerContactNo) {
        this.customerContactNo = customerContactNo;
    }

    public long getCustomerContactNo() {
        return customerContactNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setCurrentLoc(String currentLoc) {
        this.currentLoc = currentLoc;
    }

    public String getCurrentLoc() {
        return this.currentLoc;
    }

    public String toString() {
        return super.getName() + " " + vehicleNo + " " + super.getCity() + " " + super.getContactNo() +  " " + getCurrentLoc() + " " + super.getStatus();
    }
}