package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Plane
 */
public class Plane {
    Scanner miScanner = new Scanner(System.in);
    /**
     * Model of the Plane
     */
    String model;
    /**
     * Plate or code of the Plane
     */
    String plate;
    /**
     * Airline to wich the Plane belongs
     */
    String airline;
    /**
     * Time of arrival to any Landing Lane
     */
    LocalDateTime arrival; 
    /**
     * Time of departure to any Landing Lane
     */
    LocalDateTime departure;
    /**
     * Array of Passenger sits on the Plane
     */
    Passenger[][] sits = new Passenger[6][30];
    /**
     * Asignation to a landing lane
     */
    LandingLane [] asigned = new LandingLane[1];

    /**
     * Constructor of Plane
     * @param model Model of the Plane
     * @param airline Airline to wich the Plane belongs
     * @param plate Plate or code of the Plane
     * @param arrival Time of arrival to any Landing Lane
     * @param departure Time of departure to any Landing Lane
     */
    public Plane(String model, String airline, String plate, LocalDateTime arrival, LocalDateTime departure) {
        this.model = model;
        setCompany(airline);
        this.plate = plate;
        this.arrival = arrival;
        setDeparture(departure);
    }
    

    // Cambiar comprobacion a airline
    /**
     * Sets to wich airline the Plane belongs to 
     * @param airline Airline the Plane will belong to 
     */
    public void setCompany(String airline) {
        this.airline = airline;
    }

    /**
     * Sets the landing lane wich the Plane is asigned to 
     * @param asigned The landing lane wich the Plane will be asigned to 
     */
    public void setAsigned(LandingLane asigned) {
        this.asigned[0] = asigned;
    }

    /**
     * Gets the landing lane wich the Plane is asigned to 
     * @return The landing lane wich the Plane is asigned to 
     */
    public LandingLane getAsigned() {
        return this.asigned[0];
    }

    /**
     * Gets the plate or code of the Plane
     * @return The plate of the plane
     */
    public String getPlate(){
        return this.plate;
    }

    /**
     * Gets the Arrival time of the Plane
     * @return The Arrival time of the Plane
     */
    public LocalDateTime getArrival(){
        return this.arrival;
    }

    /**
     * Sets the arrival time of the plane
     * @param newArrivalTime The new arrival time of the plane
     */
    public void setArrival(LocalDateTime newArrivalTime){
        this.arrival = newArrivalTime;
    }

    /**
     * Gets the departure time of the Plane
     * @return The departure time of the Plane
     */
    public LocalDateTime getDeparture(){
        return this.departure;
    }

    /**
     * Sets the departure time of the plane checking that its after its arrival 
     * @param newDepartureTime The new departure time of the Plane
     */
    public void setDeparture(LocalDateTime newDepartureTime){
        if (newDepartureTime.isBefore(this.arrival)) {
            System.out.println("The departure time must be after the arrival time");
            this.departure = this.arrival.plusHours(1);
            System.out.println("Departure time set to 1 hour after arrival time");
        }else {
            this.departure = newDepartureTime;
        }
    }

    /**
     * Reserves a seat on the Plane for a Passenger
     * @param newPassenger The new passenger we are going to be asigning to a seat
     */
    public void reserveSeat(Passenger newPassenger) {
        toString();
        System.out.println("Select one of the empty sits");
        String asiento = miScanner.nextLine().toUpperCase();
        int number = Integer.parseInt(asiento.substring(0,2));
        int letter = asiento.charAt(2) - 65;
        if (sits[letter][number] == null) {
            System.out.println("Reservation confirmed");
            sits[letter][number] = newPassenger;
        }else {
            System.out.println("Selected sit not available or out of bounds");
        }
    }

    /**
     * LIMITED TO BE USED WITH A FAKER DATA CREATOR Reserves a seat on the Plane for a Passenger 
     * @param newPassenger The new passenger we are going to be asigning to a seat
     */
    public void fakerReserveSeat(Passenger newPassenger){
        // 18 is a magic number
        for (int i = 0; i < 18; i++) {
            int numero = Faker.entero(0, 30);
            int letra = Faker.entero(0,6);
            if (sits[letra][numero] == null) {;
                sits[letra][numero] = newPassenger;
            }
            //Corregir esto tt
        }
    }

    /**
     * Cancels a seat for a passenger 
     * @param cancellingPasssenger The Passenger we are cancelling the seat for 
     */
    public void unreserveSeat(Passenger cancellingPasssenger) {
        boolean passengerFound = false;
        for (int i = 0; i < 6 && passengerFound == false; i++) {
            for (int j = 0; j < 30 && passengerFound == false; j++) {
                if (sits[i][j] == cancellingPasssenger) {
                    passengerFound = true;
                    sits[i][j] = null;
                    System.out.println("Sit canceled");
                }
            }
        }
    }

    /**
     * Basic toString functionality that shows the information of the Plane
     */
    public String toString() {
        String line = "Model: "+model+"\n Plate: "+plate+"\n";
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 6; j++) {
                if (sits[j][i] != null) {
                    line += (sits[j][i] + "|X|");
                } else {
                    line += ("|O|");
                }
            }
            line += "\n";
        }
        return line;
    }

}
