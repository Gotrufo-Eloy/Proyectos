package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

// WIP: Crear codigos unicos, y gestionar sistema de horas para comprobar disponibilidad
/**
 * Class LandingLane
 */
public class LandingLane {
    /**
     * Code of the Landing Lane
     */
    int code;
    /**
     * Length of the Landing Lane
     */
    int length;
    /**
     * Availability of the Landing Lane
     */
    boolean available;
    /**
     * Array list of planes considered as "lane traffic" meaning the planes that land and departure from the Landing Lane
     */
    ArrayList<Plane> laneTraffic;
    /**
     * The airport on wich the Landing Lane is located
     */
    Airport [] asignedAirport = new Airport[1];

    /**
     * Constructor of Landing Lane
     * @param code Code of the Landing Lane
     * @param length Length of the Landing Lane
     */
    public LandingLane(int code, int length) {
        this.code = code;
        setLength(length);
        this.available = true;
        this.laneTraffic = new ArrayList<>();

    }

    /**
     * Gets the Asigned airport on wich the Landing Lane is located
     * @return the Asigned airport
     */
    public Airport getAsignedAirport(){
        return asignedAirport[0];
    }

    /**
     * Sets the Asigned airport on wich the Landing Lane will be located
     * @param newAirport the new airport
     */
    public void setAsignedAirport(Airport newAirport){
        this.asignedAirport[0] = newAirport;
    }

    /**
     * Gets the code of the Landing Lane
     * @return the code of the Landing Lane
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Sets the code of the Landing Lane
     * @param newCode the new code of the Landing Lane
     */
    public void setCode(int newCode) {
        this.code = newCode;
    }

    /**
     * Gets the availability of the Landing Lane
     * @return the availability of the Landing Lane
     */
    public boolean getAvailable() {
        return this.available;
    }

    /**
     * Sets the availability of the Landing Lane
     * @param newAvailable the new status of the Landing Lane
     */
    public void setAvailable(boolean newAvailable) {
        this.available = newAvailable;
    }

    /**
     * Asigns planes to the Landing Lane
     * @param newPlane The plane we want to asign to the Landing Lane
     */
    public void addPlaneToLandingLane(Plane newPlane) {
        if (laneTraffic.size() == 0) {
            laneTraffic.add(newPlane);
        } else {
            LocalDateTime lastPlaneArrival = laneTraffic.getLast().getArrival();
            LocalDateTime lastPlaneDeparture = laneTraffic.getLast().getDeparture();
            LocalDateTime newPlaneArrival = newPlane.getArrival();
            LocalDateTime newPlaneDeparture = newPlane.getDeparture();
            if (newPlaneArrival.isEqual(lastPlaneArrival) && newPlaneDeparture.isEqual(lastPlaneDeparture)) {
                System.out.println("That plane is already on that lane");
            } else {
                if (newPlane.getArrival().isAfter(lastPlaneDeparture)) {
                    laneTraffic.add(newPlane);
                } else {
                    System.out.println("The plane arrival time must be after the last plane departure time");
                }
            }

            
        }

    }

    /**
     * Sets the length of the Landing Lane checks if its not negative
     * @param length The length of the Landing Lane
     */
    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("La longitud de la pista debe ser superior a 0m");
        }
    }

    /**
     * Basic toString functionality that shows the information of the Landing Lane 
     */
    public String toString() {
        return "Aeropuerto: "+asignedAirport[0].getName()+"\nCodigo: " + code + " Longitud: " + length + "(m) Disponible: " + available;
    }
}
