import java.util.ArrayList;
import java.util.Scanner;

public class DriverList {
    static private ArrayList<Drivers> driverList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void getDriverById(int id) {
        if(driverList.size()>id && driverList.get(id) != null) {
            System.out.println(driverList.get(id));
        } else {
            System.out.println("Driver id: " + id + " is not found");
        }     
    } 

    static Drivers driversAssign(long customerContactNo,String city, String currentLoc) {
        for(Drivers x : driverList) {
            if(x.getCurrentLoc().equals(currentLoc) && x.getCity().equals(city) && !x.getStatus().equals("booked")) {
                x.setCustomerConntactNo(customerContactNo);
                x.setStatus("booked");
                return x;
            }
        }
        return null;
    }

    static void  cancelRides(long customerContactNo,String dropLoc) {
        for(Drivers x : driverList) {
            if(x.getCustomerContactNo() == customerContactNo) {
                x.setCurrentLoc(dropLoc);
                x.setStatus("unbooked");
            }
        }
    
    }

    static int getDriverId(long customerContactNo) {
        int index =0;
        for(Drivers x : driverList) {
            if(x.getCustomerContactNo() == customerContactNo) {
                break;
            }
            index++;
        }
        return index;
    }

    static Drivers driversAssign(long customerContactNo,String city) {
        for(Drivers x : driverList) {
            if(x.getCity().equals(city) && !x.getStatus().equals("booked")) {
                x.setCustomerConntactNo(customerContactNo);
                x.setStatus("booked");
                return x;
            }
        }
        return null;
    }

    public void addDriver(String name, String vehicleNo, String city, long contactNo, String currentLoc) {
        if(driverList.size()>0) {
            int found = 0;
            int i=0;
            for(Drivers x : driverList) {
                if(x == null) {
                    driverList.set(i,new Drivers(name, vehicleNo, city, contactNo,currentLoc));
                    found = 1;
                    break;
                }
                i++;
            }
            if(found == 0) {
                driverList.add(driverList.size(),new Drivers(name, vehicleNo, city, contactNo,currentLoc));

            }
        } else {
            driverList.add(driverList.size(),new Drivers(name, vehicleNo, city, contactNo, currentLoc));
        }
    }

    String checkAlreadyExists(String vehicleNo) {
         for(Drivers x: driverList){
            if (x.getVehicleNo().equals(vehicleNo)) {
                System.out.println("The given vehicleNo already exists so pls update");
                System.out.println("Enter Vehicle Number");
                vehicleNo = sc.nextLine();
            }
        }
        return vehicleNo;
    }

    long checkAlreadyExists(long contactNo) {
        for(Drivers x: driverList){
            if (x.getContactNo() == contactNo) {
                System.out.println("The given contactNo already exists so pls update");
                System.out.println("Enter Contact Number");
                contactNo = sc.nextLong();
            }
        }
        return contactNo;
    }

    public void updateDriverDetailsById(int id) {
        if(driverList.size() > id && driverList.get(id) != null) {

            Drivers driver = driverList.get(id);
            System.out.println("Do You want to chnage your name type y/n");
            char type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.err.println("Enter Your Name");
                String name = sc.nextLine();
                driver.setName(name);
            }

            System.out.println("Do You want to chnage your vehicleNumber type y/n");
            type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.out.println("Enter Your VehicleNumber");
                String vehicleNo = sc.nextLine();
                vehicleNo = checkAlreadyExists(vehicleNo);
                driver.setVehicleNo(vehicleNo);
            }

            System.out.println("Do You want to chnage your city type y/n");
            type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.out.println("Enter Your city");
                String city = sc.nextLine();
                driver.setCity(city);
            }

            System.out.println("Do You want to chnage your contactNumber type y/n");
            type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.out.println("Enter Your ContactNumber");
                long contactNo = sc.nextLong();
                sc.nextLine();
                contactNo = checkAlreadyExists(contactNo);
                driver.setContactNo(contactNo);
            }

        } else {
            System.out.println("Driver id: " + id + " is not found");
        }
    }

    void displayAllDrivers() {
        if(driverList.size()>0) {
            for(Drivers x : driverList) {
                System.out.println(x);
            }
        } else {
            System.err.println("drivers not found");
        }
    }

    public void removeDrivers(int id) {
        if (driverList.get(id) != null && driverList.size() > id) { 
            driverList.set(id,null);
        } else {
            System.out.println("Driver id: " + id + " is not found");
        }
    }
}
