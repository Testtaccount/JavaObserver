package Observer.Observer1.impl;

import Observer.Observer1.interfaces.Observer;

public class Person implements Observer {

    String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public void update(String availabiliy) {
        System.out.println("Hello "+personName+", Product is now "+ availabiliy +" on flipkart");
    }
}
