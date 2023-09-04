class Customers {
    private String name;
    private String city;
    private long contactNo;
    private String currentLoc="";
    private  String dropLoc="";
    private  String status = " ";

    Customers(String name, String city, long contactNo) {
        this.name = name;
        this.city = city;
        this.contactNo = contactNo;
    }

    Customers() {

    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLocation(String currentLoc, String dropLoc) {
        this.currentLoc = currentLoc;
        this.dropLoc = dropLoc;
    }

    public void removeLocation() {
        this.currentLoc  = " ";
        this.dropLoc = " ";
    }

    public String toString() {
        return name + " " + city + " " + contactNo + " " + currentLoc + " " + dropLoc + " " + status;
    }

    public void setCurrentLoc(String currentLoc) {
        this.currentLoc = currentLoc;
    }

    public String getCurrentLoc() {
        return this.currentLoc;
    }

    public void setDropLoc(String dropLoc) {
        this.dropLoc = dropLoc;
    } 
    
    public String getDropLoc() {
        return this.dropLoc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public long getContactNo() {
        return this.contactNo;
    }
}