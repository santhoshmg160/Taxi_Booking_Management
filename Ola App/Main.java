import java.util.Scanner;

public class Main{

    static Scanner sc = new Scanner(System.in);
    static DriverList driverList = new DriverList();
    static CustomerList customerList = new CustomerList();
    static String name,vehicleNo,city,currentLoc,dropLoc;
    static long contactNo;
    
    static void getChoice() {
        System.out.println("1.CREATE");
        System.out.println("2.READ");
        System.out.println("3.POST");
        System.out.println("4.DELETE");
        System.out.println("5.BookTravel");
        System.out.println("6.DriverRides");
        System.out.println("7.CustomerRides");
        System.out.println("8.Total Drivers");
        System.out.println("9.Total Customers");
        int number = sc.nextInt();
        switch(number) {
            case 1:
                int select = getClients();
                sc.nextLine();
                if(select == 1) {
                    System.out.println("Enter Drivers name");
                    name = sc.nextLine();
                    System.out.println("Enter Vehicle Number");
                    vehicleNo =  sc.nextLine();
                    vehicleNo = driverList.checkAlreadyExists(vehicleNo);
                    additionalDetails();
                    contactNo = driverList.checkAlreadyExists(contactNo);
                    System.out.println("Enter current Location:"); 
                    currentLoc = sc.nextLine();
                    driverList.addDriver(name,vehicleNo,city,contactNo,currentLoc);
                } else {
                    System.out.println("Enter Customers name");
                    name = sc.nextLine();
                    additionalDetails();
                    contactNo = customerList.checkAlreadyExists(contactNo); 
                    customerList.addCustomer(name,city,contactNo);
                    System.out.println("Do you want to travel press y/n");
                    char type = sc.next().charAt(0);
                    sc.nextLine();
                    if(type == 'y') {
                        bookTicket();
                        customerList.addLocations(currentLoc,dropLoc);                    
                    }
                }
                getChoice();
                break;
            case 2:
                select = getClients();
                sc.nextLine();
                System.out.println("Enter Your Id:");
                if(select == 1) {
                    int id = sc.nextInt();
                    driverList.getDriverById(id);
                } else {
                    int id = sc.nextInt();
                    customerList.getCustomerById(id);
                }
                getChoice();
                break;
            case 3:
                select = getClients();
                sc.nextLine();
                System.out.println("Enter your id to update the details");
                if (select == 1) {
                    int id = sc.nextInt();
                    driverList.updateDriverDetailsById(id);
                } else {
                    int id = sc.nextInt();
                    customerList.updateCustomerById(id);
                }
                
                getChoice();
                break;
            case 4:
                select = getClients();
                if(select == 1) {
                    System.out.println("Enter your id to remove from our driverList");
                    int id = sc.nextInt();
                    sc.nextLine();
                    driverList.removeDrivers(id);
                } else {
                    System.out.println("Enter your id to remove from our customerList");
                    int id = sc.nextInt();
                    sc.nextLine();
                    customerList.removeCustomers(id);
                }
                getChoice();
                break;
            case 5:
                System.out.println("Enter Your id to travel:");
                int id = sc.nextInt();
                sc.nextLine();
                int check = customerList.getCustomerId(id);
                customerList.checkStatus(id);
                if(check==-1) {
                    System.out.println("Customer id: " + id + " is not found");
                } else {
                    currentLoc = customerList.checkCurrentLoc(id);
                    if(!currentLoc.equals("no")) {
                        System.out.println("Do you want to change  your currentLoc press y/n:");
                        char type = sc.next().charAt(0);
                        sc.nextLine();
                        if(type != 'y') {
                            System.out.println("Enter your drop location:");
                            dropLoc = sc.nextLine();
                        } else {
                            bookTicket();
                        }
                    } else {
                        bookTicket();
                    }
                    customerList.addLocations(id, currentLoc, dropLoc);
                }
                getChoice();
                break;
            case 6:
                System.out.println("enter your id:");
                id = sc.nextInt();
                sc.nextLine();
                DriverRides.disPlayAllRides(id);
                getChoice();
                break;
            case 7:
                System.out.println("enter your id:");
                id = sc.nextInt();
                sc.nextLine();
                CustomerRides.disPlayAllRides(id);
                getChoice();
                break;
            case 8:
                driverList.displayAllDrivers();
                getChoice();
                break;
            case 9:
                customerList.displayAllCustomers();
                getChoice();
                break;
            default:
                break;
        }
    }

    static void bookTicket() {

        System.out.println("Enter Current Location:");
        currentLoc = sc.nextLine();
        System.out.println("Enter your drop location:");
        dropLoc = sc.nextLine();
    }

    static void additionalDetails() {
        System.out.println("Enter city");
        city = sc.nextLine();
        System.out.println("Enter Contact Number");
        contactNo = sc.nextLong();
        sc.nextLine();
    }

    static int getClients() {
        System.out.println("1.Drivers");
        System.out.println("2.Customers");
        int select = sc.nextInt();
        return select;
    }

    public static void main(String[] args) {
        getChoice();
        sc.close();
    }
}