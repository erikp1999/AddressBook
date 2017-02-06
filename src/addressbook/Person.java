

package addressbook;


public class Person {
    
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
 
    
    
    //Creates person if no data is given
    public Person(){
        
    }
    
    //creates with nothing but name
    public Person(String firstName, String lastName){
    this.firstName = firstName;
    this.lastName = lastName;
    
    }
    
    //creates with all data given initially
    public Person(String firstName, String lastName, String phoneNumber, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        
        this.phoneNumber = phoneNumber;
        this.address = address;
        
    }
    
    
    //getter and setter methods for all data

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void display(){
        System.out.println();
        System.out.println("------------------------");
        System.out.print("Name: ");
        String fullName = lastName + ", " + firstName;
        if (fullName != null){
            System.out.print(fullName);
        }
        System.out.println();
        System.out.println();
        System.out.print("Address: ");
        if (address != null){
            System.out.print(address);
        }
        System.out.println();
        System.out.println();
        System.out.print("Phone Number: ");
        if (phoneNumber != null){
            System.out.print(phoneNumber);
        }
        System.out.println();
        System.out.println("------------------------");
        System.out.println();
    
        
    }
    
    
    
}
