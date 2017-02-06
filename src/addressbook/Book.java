
package addressbook;

import static addressbook.AddressBook.addressBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Book {
   private static List<Person> people;
   private static Scanner input; 
   private static String mode;
   public Book(){
       DAO data = new DAO(); 
       people = DAO.getAllAddresses();
       input = new Scanner(System.in);
       System.out.println("What mode would you like to enter? View, Edit, or Add?");
       processAction(input.next());
       
   }
   public void addPerson(Person person){
       people.add(person);
   }
   public void addPeople(List<Person> morePeople){
       people.addAll(morePeople);
   }

    public List<Person> getPeople() {
        return people;
    }
    public static Person getPersonByLastName(String lastName){
        Person target = null;
        for (Person person : people){
            if (person.getLastName().toLowerCase().equals(lastName.toLowerCase())){
                target = person;
                break;
            }
        }        
        return target;
    }
    public static Person getPersonByFirstName(String firstName){
        Person target = null;
        for (Person person : people){
            if (person.getFirstName().toLowerCase().equals(firstName.toLowerCase())){
                target = person;
                break;
            }
        }        
        return target;
    }
   
    private static void searchByLastName(String lastName){
        Person found = addressBook.getPersonByLastName(lastName);
                if (found == null){
                    System.out.println("No Person by that Name ");
                    System.out.println("Would you like to search a different last name?");
                    if (input.next().toLowerCase().equals("yes")){
                        System.out.println("Please enter a new last name");
                        lastName = input.next();
                        searchByFirstName(lastName);
                    }
                }
                    
                
                else{
                    found.display();
                }
    }
    private static void searchByFirstName(String firstName){
        Person found = addressBook.getPersonByFirstName(firstName);
                if (found == null){
                    System.out.println("No Person by that Name ");
                    System.out.println("Would you like to search a different first name?");
                    if (input.next().toLowerCase().equals("yes")){
                        System.out.println("Please enter a new first name");
                        firstName = input.next();
                        searchByFirstName(firstName);
                    }
                }
                    
                
                else{
                    found.display();
                }
    }
    
    public static void processAction(String command){
        //first check if it is trying to change the mode
        command= command.toLowerCase();
       switch (command) {
           case "view":
               search();
               break;
       //then go through the possibilities if it is not trying to change mode for the mode it is in
           case "edit":
               edit(findForEdit());
               break;
           case "add":
               add();
               break;
           default:
               System.out.println("Please enter a valid mode");
               break;
       }
        
        //getPersonByFirstName("Erik").display();
        System.out.println("What would you like to do next? View, Add, or Edit?");
        String newCommand = input.next();                
        processAction(newCommand);
    }
    
     private static void search(){
        

        System.out.println("Please enter the search type you would like. Last Name or First Name, by typing last or first.");
        String nameType = input.next();
        if (nameType.toLowerCase().equals("first")){
            System.out.println("What is the First name of the person you are looking for?");
            String firstName = input.next();
            searchByFirstName(firstName);

        }
        else if (nameType.toLowerCase().equals("last")){
            System.out.println("What is the last name of the person you are looking for?");
            String lastName = input.next();
            searchByLastName(lastName);
        }
        else{
            System.out.println("Not valid input type, would you still like to view contacts?");
            if (input.next().toLowerCase().equals("yes")){
                search();
            }
        }
        
            
        
        
    }
    
    private static void add(){
        System.out.println("What is their first name?");
        String firstName = input.next();
        System.out.println("What is their last name?");
        String lastName = input.next();
        System.out.println("Do you know their phone number and address?");
        if (input.next().equals("yes")){

            System.out.println("What is their address?");
            String address = input.next();
            System.out.println("What is phone number?");
            String phoneNumber = input.next();
             people.add(new Person(firstName, lastName, phoneNumber, address));
        }
        else{
            people.add(new Person(firstName, lastName));
        }System.out.println("Person Successfully Added!");
    }
    
    private static Person findForEdit(){
        Person found;
        System.out.println("Find by first name or last name?");
        String nameType = input.next();
        nameType = nameType.toLowerCase();
        if (nameType.equals("first")){
            System.out.println("What is the First name of the person you are looking for?");
            String firstName = input.next();
            found = getPersonByFirstName(firstName);

        }
        else if (nameType.equals("last")){
            System.out.println("What is the last name of the person you are looking for?");
            String lastName = input.next();
            found = getPersonByLastName(lastName);
        }
        else{
            System.out.println("Not valid input type, would you still like to edit contacts?");
            if (input.next().toLowerCase().equals("yes")){
                return findForEdit();
            }
            return null;
        }
        if (found == null){
            System.out.println("No Person Found, would you like to search again?");
            if (input.next().toLowerCase().equals("yes")){
                return findForEdit();
            }
            return null;
        }
        return found;
        
    }
    private static void edit(Person target){
        boolean somethingChanged = true;
        if (target != null){
            target.display();
            System.out.println("What would you like to edit? Type first, last, phone, or address.");
            String infoType = input.next();
            if (infoType.equals("first")){
                System.out.println("What would you like to change it to?");
                target.setFirstName(input.next());
            }
            else if (infoType.equals("last")){
                System.out.println("What would you like to change it to?");
                target.setLastName(input.next());
            }
            else if (infoType.equals("phone")){
                System.out.println("What would you like to change it to?");
                target.setPhoneNumber(input.next());
            }
            else if (infoType.equals("address")){
                System.out.println("What would you like to change it to?");
                target.setAddress(input.next());
                
            }
            else{
                somethingChanged = false;
                System.out.println("Invalid data type.");
                System.out.println("Would you still like to edit?");
                if (input.next().toLowerCase().equals("yes")){
                    edit(target);
                }
            }
        }
        if(somethingChanged){
            System.out.println("Edit Complete. ");
            System.out.println("Current Data: ");
            target.display();
        }
        
    }
   
    
}
