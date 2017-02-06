
package addressbook;

import java.util.ArrayList;
import java.util.List;


public  class DAO {
    
    public DAO(){
        
    }
    public static List<Person> getAllAddresses(){
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Erik", "Porter", "207-595-9212", "650 East Denmark Road"));
        people.add(new Person("Lauren", "Porter", "207-329-4401", "62 Kansas Road"));
        people.add(new Person("Brian", "Porter", "207-321-8030", "62 Kansas Road"));
        people.add(new Person("Alex", "Walker", "207-393-7696", "10 Pond Road, Bridgeton, ME"));
        people.add(new Person("Mark", "Hewitt", "207-697-2262", "14 Easy Street, Stow, Maine"));
        people.add(new Person("Tyler", "Hall", "no idea", "somwhere in Fryeburg near a river"));
        people.add(new Person("Erik", "Porter"));
        return people;
    }
    
}
