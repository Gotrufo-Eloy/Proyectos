package clases;

import java.util.ArrayList;

/**
 * Class Airport
 */
public class Airport {
    /**
     * Name of the Airport
     */
    String name;
    /**
     * City of the Airport
     */
    String city;
    /**
     * Country of the Airport
     */
    String country;
    /**
     * IATA of the Airport
     */
    String IATA;
    /**
     * Array list of landing lanes on the Airport
     */
    ArrayList<LandingLane> LandingLanes;

    /**
     * Constructor of Airport
     * @param name Name of the Airport
     * @param city City of the Airport
     * @param country Country of the Airport
     */
    public Airport(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.IATA = initialIATA(name);
        this.LandingLanes = new ArrayList<>();
    }

    /**
     * Gives the Airport an initial IATA that later will be checked on the Airline array to see if its duplicate
     * See checkDuplicatedIATA for more information on that process
     * @param name Name of the Airport on wich we base the IATA
     * @return An IATA
     */
    public String initialIATA(String name){
        return name.substring(0,3).toUpperCase();
    }

    /**
     * Gets the IATA 
     * @return The IATA
     */
    public String getIATA(){
        return this.IATA;
    }

    /**
     * Sets the IATA
     * @param IATA The IATA we want to make the new IATA
     */
    public void setIATA(String IATA){
        this.IATA = IATA;
    }

    /**
     * Gets the name of the Airport
     * @return The name of the Airport
     */
    public String getName(){
        return this.name;
    }

    /**
     * Adds a new Landing Lane to the landing lane array on Airport
     * Also makes the Landing Lane asignedAirport to be this airport, see setAsignedAirport and asignedAirport for more information
     * @param newLane The new Landing Lane we want to add to the Airport
     */
    public void addLandingLane(LandingLane newLane) {
        // Implementacion automatica de que si el codigo se deja como 0 en la creacion de nuevas pistas, automaticamente les asigna el siguiente valor en la lista
        // boolean duplicatedCode = false;
        // for (int i = 0; i < LandingLanes.size() && duplicatedCode == false; i++) {
        //     if (newLane.getCode() == LandingLanes.get(i).getCode()) {
        //         duplicatedCode = true;
        //     }
        // }
        // if (duplicatedCode = false) {
        //     this.LandingLanes.add(newLane);
        // } else {
        //     System.out.println("Ese codigo de Pista de Aterrizaje ya esta usado\nSe recomienda el uso de: " + LandingLanes.size());
        // }
        newLane.setAsignedAirport(this);
        this.LandingLanes.add(newLane);
    }

    /**
     * Basic toString functionality that shows the contents of the Airport 
     */
    public String toString() {
        String line = "Name: " + name +
                "\nCity: " + city +
                "\nCountry: " + country +
                "\nIATA: " + IATA +
                "\nLanding Lanes:\n";
        if (LandingLanes.size() == 0) {
            line += "No landing lanes available\n";
        }else{
            for (int i = 0; i < LandingLanes.size(); i++) {
                line += i + " " + LandingLanes.get(i).toString() + "\n";
            }
        }
        return line;
    }

}
