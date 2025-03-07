package clases;

/**
 * Class Passenger
 */
public class Passenger {
    /**
     * Name of the Passenger
     */
    String name;
    /**
     * Surname of the Passenger
     */
    String surname;
    /**
     * Identification number of the Passenger
     */
    int id;
    /**
     * Age of the Passenger
     */
    int age;
    /**
     * Plane plate to wich the Passenger is asigned 
     */
    int planeTicket;
    /**
     * Bolean to see if the Passenger has checked Luggage
     */
    boolean checkedLuggage;
    /**
     * Quantity of allowed hand lugagge the Passenger may have on board
     */
    int allowedHandLuggage;

    /**
     * Constructor of Passenger
     * @param name Name of the Passenger
     * @param surname Surname of the Passenger
     * @param id Identification number of the Passenger
     * @param age Age of the Passenger
     * @param planeTicket Plane plate to wich the Passenger is asigned 
     * @param checkedLuggage Bolean to see if the Passenger has checked Luggage
     * @param allowedHandLuggage Quantity of allowed hand lugagge the Passenger may have on board
     */
    public Passenger(String name, String surname, int id, int age, int planeTicket, boolean checkedLuggage, int allowedHandLuggage){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.age = age;
        this.planeTicket = planeTicket;
        this.checkedLuggage = checkedLuggage;
        this.allowedHandLuggage = allowedHandLuggage;
    }

    /**
     * Gets the name of the Passenger
     * @return The name of the Passenger
     */
    public String getName(){
        return this.name;
    }

    /**
     * Modified toString that returns nothing so as to not disrupt with other toString(s)
     */
    public String toString() {
        // return name+" "+surname;
        return "";
    }
}
