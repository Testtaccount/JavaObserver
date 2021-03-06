package Observer.Observer1.main;

import Observer.Observer1.impl.Person;
import Observer.Observer1.impl.Product;

public class ObserverPatternMain {

    public static void main(String[] args) {

        Person arpitPerson=new Person("Arpit");
        Person johnPerson=new Person("John");

        Product samsungMobile=new Product("Samsung", "Mobile", "Not available");

        //When you opt for option "Notify me when product is available".Below registerObserver method
        //get executed
        samsungMobile.registerObserver(arpitPerson);
        samsungMobile.registerObserver(johnPerson);

        //Now product is available
        samsungMobile.setAvailability("Available");
        samsungMobile.setAvailability("No");
    }

}
