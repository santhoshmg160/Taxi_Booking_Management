import java.util.*;

public class CustomerList {

    private ArrayList<Customers> customerList = new ArrayList<>();
    CustomerRides customerRides = new CustomerRides();
    static Scanner sc = new Scanner(System.in);

    void addCustomer(String name, String city, long contactNo) {
        if(customerList.size() > 0) {
            int i=0;
            int found=0;

            for(Customers x : customerList) {
                if (x == null) {
                    customerList.set(i,new Customers(name, city, contactNo));
                    found=1;
                    break;
                }
                i++;
            }
            if (found == 0) {
                customerList.add(customerList.size(),new Customers(name, city, contactNo));
            }
        } else {
            customerList.add(customerList.size(),new Customers(name, city, contactNo));
        }
    }

    void addLocations(int id, String currentLoc, String dropLoc) {
        customerList.get(id).setLocation(currentLoc,dropLoc);
        Customers customer = customerList.get(id);
        String city = customer.getCity();
        long contactNo = customer.getContactNo();
        Drivers driverDetails = DriverList.driversAssign(contactNo,city,currentLoc);
        if(driverDetails == null) {
            System.out.println("Sry in your location there is no drivers can you pay  addidtional cost then the driver come press y/n");
            char type = sc.next().charAt(0);
            if(type == 'y') {
                driverDetails = DriverList.driversAssign(contactNo,city);
                if(driverDetails  == null) {
                    System.out.println("Sry there is no driver in your city");
                } else {
                    bookRide(id,driverDetails.getName(),driverDetails.getVehicleNo(),currentLoc, dropLoc,customer.getName(),contactNo,customer);
                }
            } 
        } else {
            bookRide(id,driverDetails.getName(),driverDetails.getVehicleNo(),currentLoc, dropLoc,customer.getName(),contactNo,customer);
        }
    }

    void addLocations(String currentLoc, String dropLoc) {
        customerList.get(customerList.size()-1).setLocation(currentLoc,dropLoc);
        Customers customer = customerList.get(customerList.size()-1);
        String city = customer.getCity();
        long contactNo = customer.getContactNo();
        Drivers driverDetails = DriverList.driversAssign(contactNo,city,currentLoc);
        if(driverDetails == null) {
            System.out.println("Sry in your location there is no drivers can you pay  addidtional cost then the driver come press y/n");
            char type = sc.next().charAt(0);
            if(type == 'y') {
                driverDetails = DriverList.driversAssign(contactNo,city);
                if(driverDetails  == null) {
                    System.out.println("Sry there is no driver in your city");
                } else {
                    bookRide(customerList.size()-1,driverDetails.getName(),driverDetails.getVehicleNo(),currentLoc, dropLoc,customer.getName(),contactNo,customer);
                    // System.out.println("your driver name is "  + driverDetails.getName() + " he will pick up in your currentLocation");
                    // System.out.println("your travel fees is 50rs");
                    // System.out.println("do you want to cancel your ride press  y/n");
                    // type = sc.next().charAt(0);
                    // if(type == 'y') {
                    //     customer.removeLocation();
                    //     DriverList.cancelRides(contactNo);
                    // } else {
                    //     // customerRides.setCustomerRides(customerList.size()-1, driverDetails.getName(),driverDetails.getVehicleNo(),currentLoc, dropLoc);
                    //     // customer.setStatus("booked");
                    //     // int id = DriverList.getDriverId(contactNo, dropLoc);
                    //     // DriverRides.setDriverRides(id,customer.getName(),contactNo,currentLoc, dropLoc);
                    //     // customer.setLocation(dropLoc," ");
                    //     bookRide(customerList.size()-1,driverDetails.getName(),driverDetails.getVehicleNo(),currentLoc, dropLoc,customer.getName(),contactNo,customer);
                    // }
                }
            } 
        } else {
            bookRide(customerList.size()-1,driverDetails.getName(),driverDetails.getVehicleNo(),currentLoc, dropLoc,customer.getName(),contactNo,customer);
        }
    }

    void bookRide(int id, String driverName, String vehicleNo, String currentLoc,String dropLoc, String customerName,long contactNo,Customers customer) {
        System.out.println("your driver name is "  + driverName + " he will pick up in your currentLocation");
        System.out.println("your travel fees is 50rs");
        System.out.println("do you want to cancel your ride press  y/n");
        char type = sc.next().charAt(0);
        if(type == 'y') {
            System.out.println("Your ride is cancelled");
            customer.removeLocation();
            DriverList.cancelRides(contactNo,dropLoc);
        } else {
            customerRides.setCustomerRides(id, driverName,vehicleNo,currentLoc, dropLoc);
            customer.setStatus("booked");
            int id1 = DriverList.getDriverId(contactNo);
            DriverRides.setDriverRides(id1,customerName,contactNo,currentLoc, dropLoc);
        }
    }


    long checkAlreadyExists(long contactNo) {
        for(Customers x: customerList){
            if (x.getContactNo() == contactNo) {
                System.out.println("The given contactNo already exists so pls update");
                System.out.println("Enter Contact Number");
                contactNo = sc.nextLong();
            }
        }
        return contactNo;
    }

    String checkCurrentLoc(int id) {
        Customers customer = customerList.get(id);
        if  (customer.getCurrentLoc().length()>1) {
            return customer.getCurrentLoc();
        }
        return "no";

    }

    int getCustomerId(int id) {
        if(customerList.size()>id){
            return id;
        } 
        return -1;
    }

    void displayAllCustomers() {
        if(customerList.size()>0) {
            for(Customers x : customerList) {
                System.out.println(x);
            }
        } else {
            System.err.println("Customers not found");
        }
    }

    void getCustomerById(int id) {
        if(customerList.size() > id && customerList.get(id) != null) {
            System.out.println(customerList.get(id));
        } else {
            System.out.println("Customer id: " + id + " is not found");
        }
    }

    void updateCustomerById(int id) {
        if(customerList.size() > id && customerList.get(id) != null) {

            Customers customer = customerList.get(id);
            System.out.println("Do You want to chnage your name type y/n");
            char type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.err.println("Enter Your Name");
                String name = sc.nextLine();
                customer.setName(name);
            }

            System.out.println("Do You want to chnage your city type y/n");
            type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.out.println("Enter Your city");
                String city = sc.nextLine();
                customer.setCity(city);
            }

            System.out.println("Do You want to chnage your contactNumber type y/n");
            type = sc.next().charAt(0);
            sc.nextLine();

            if (type == 'y') {
                System.out.println("Enter Your ContactNumber");
                long contactNo = sc.nextLong();
                contactNo = checkAlreadyExists(contactNo);
                sc.nextLine();
                customer.setContactNo(contactNo);
            }

        } else {
            System.out.println("Customer id: " + id + " is not found");
        }
    }

    static void details(Customers x) {
        System.out.println("Hello " + x.getName() + ", do you  finished your travel press y/n");
        char type = sc.next().charAt(0);
        sc.nextLine();
        if(type == 'y') {
            System.out.println("pay your fees:");
            int fees = sc.nextInt();
            sc.nextLine();
            if(fees == 50) {
                x.setStatus("unbooked");
                int id = DriverList.getDriverId(x.getContactNo());
                DriverList.cancelRides(x.getContactNo(),x.getDropLoc());
                x.setLocation(x.getDropLoc()," ");
                System.out.println("Thank you for  your  ride " + x.getName());
                System.out.println("Do you have any feedback:");
                String feedback = sc.nextLine();
                DriverRides.addFeedback(id,feedback);
            }
        } else {
            Main.getChoice();
        }
    }

    void checkStatus(int id) {
            Customers customer = customerList.get(id);
            if(customer.getStatus().equals("booked") && customer!=null) {
                details(customer);
            }
    }

    public void removeCustomers(int id) {
        if (customerList.get(id) != null && customerList.size() > id) { 
            customerList.set(id,null);
        } else {
            System.out.println("Customer id: " + id + " is not found");
        }
    }
}
