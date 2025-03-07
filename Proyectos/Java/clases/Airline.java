package clases;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Airline
 */
public class Airline {
    /**
     * Name of the Airline
     */
    String name;
    /**
     * Array list of planes in the Airline
     */
    ArrayList<Plane> Planes;
    /**
     * Array list of Airports in the Airline
     */
    ArrayList<Airport> Airports;

    /**
     * Array of chars used for IATA creation, check nextIATA for more information
     */
    char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
            'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    /**
     * Constructor of airline
     * @param name The name of the Airline
     */
    public Airline(String name) {
        this.name = name;
        this.Planes = new ArrayList<>();
        this.Airports = new ArrayList<>();
    }

    /**
     * Checks if the new airport has a duplicated IATA
     * @param newAirport The airport we want to check
     */
    public void checkDuplicatedIATA(Airport newAirport) {
        boolean duplicatedIATA = false;
        for (int i = 0; i < Airports.size() && duplicatedIATA == false; i++) {
            if (newAirport.getIATA() == Airports.get(i).getIATA()) {
                duplicatedIATA = true;
                newAirport.setIATA(nextIATA(newAirport));
                checkDuplicatedIATA(newAirport);
            }
        }
    }

    /**
     * Makes a new IATA based on the original IATA so that if multiple airports have the same name they will have diferent IATAs, Limited to 26 airports with the same name WIP: make it infinite
     * @param newAirport The airport we want to change the IATA of
     * @return A new IATA for said airport
     */
    public String nextIATA(Airport newAirport) {
        String AirportName = newAirport.getName();
        String nextIATA = AirportName.substring(0, 2) + alphabet[(int) Math.random() * 27];
        return nextIATA;
    }

    /**
     * Adds a new airport to the Airline, also checksDuplicatedIata
     * @param newAirport The airport we want to add
     */
    public void addAirport(Airport newAirport) {
        checkDuplicatedIATA(newAirport);
        this.Airports.add(newAirport);
    }

    /**
     * Gets the name of the Airline
     * @return Name of the Airline
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a new plane to the Airline
     * @param newPlane The plane we want to add 
     */
    public void addPlane(Plane newPlane) {
            this.Planes.add(newPlane);
        
    }

    /**
     * Basic toString functionality that shows the contents of the Airline both airports and planes
     */
    public String toString() {
        String line = "";
        for (int i = 0; i < Planes.size(); i++) {
            line += Planes.get(i).toString();
        }
        for (int i = 0; i < Airports.size(); i++) {
            line += Airports.get(i).toString();
        }
        return line;
    }
}
