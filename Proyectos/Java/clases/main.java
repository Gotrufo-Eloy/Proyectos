package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main del codigo
 */
public class main {
    /**
     * This is the airline array
     */
    public static ArrayList<Airline> airlines = new ArrayList<>();

    /**
     * This is just a date used to generate the planes arrival and departure times
     */
    public static LocalDateTime dateOfStart = LocalDateTime.of(2020, 1, 1, 0, 0);

    /**
     * This is just a date used to generate the planes arrival and departure times
     */
    public static LocalDateTime dateOfEnd = LocalDateTime.of(2020, 12, 31, 23, 59);

    /**
     * Shows the main menu of the program
     */
    public static void menu() {
        System.out.println("");
        System.out.println("1. Create airports/Landing lanes/Planes/Passengers");
        System.out.println("2. Assign planes to landing lanes");
        System.out.println("3. Show airports/Landing lanes/Planes/Passengers information");
        System.out.println("4. Exit");
    }

    /**
     * Shows the submenu of the information menu
     */
    public static void informationSubMenu() {
        System.out.println("1. Show airports information");
        System.out.println("2. Show landing lanes information");
        System.out.println("3. Show planes information");
        System.out.println("4. Show passengers information");
    }

    /**
     * Shows the submenu of the creation menu
     */
    public static void creationSubMenu() {
        System.out.println("1. Create airport");
        System.out.println("2. Create landing lane");
        System.out.println("3. Create plane");
        System.out.println("4. Create passenger");
    }

    /**
     * Finds an airline by its name
     * 
     * @param name     The name of the airline we are looking for
     * @param airlines The list of airlines we are gonna be looking in
     * @return The airline we are looking for, null if it is not found
     */
    public static Airline findAirlineByName(String name, List<Airline> airlines) {
        for (Airline airline : airlines) {
            if (airline.getName().equalsIgnoreCase(name)) {
                return airline;
            }
        }
        return null;
    }

    /**
     * Creates an airport and adds it to the airline
     * 
     * @param airline The airline the airport will belong to
     */
    public static void createAirport(Airline airline) {
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Enter the name of the airport");
        String newAirportName = stringScanner.nextLine();
        while (newAirportName.length() < 3) {
            System.err.println("The name of the airport must be at least 3 characters long");
            System.out.println("Enter the name of the airport");
            newAirportName = stringScanner.nextLine();
        }
        System.out.println("Enter the city of the airport");
        String newAirportCity = stringScanner.nextLine();
        System.out.println("Enter the country of the airport \n");
        String newAirportCountry = stringScanner.nextLine();
        Airport newAirport = new Airport(newAirportName, newAirportCity, newAirportCountry);
        airline.addAirport(newAirport);
        System.out.println("Airport created successfully");
        System.out.println(newAirport.toString());
    }

    /**
     * Creates a landing lane and adds it to the airport, also get the necesary data
     * to do so from the user
     * 
     * @param airline     The airline the airport belongs to
     * @param airportCode The position of the airport in the array of airports
     */
    public static void getLandingLaneDataFromUser(Airline airline, int airportCode) {
        Scanner intScanner = new Scanner(System.in);
        int newLandingLaneCode = airline.Airports.get(airportCode).LandingLanes.size();
        System.out.println("The code of the landing lane is: " + newLandingLaneCode);
        // System.out.println("Enter the code of the landing lane");
        // int newLandingLaneCode = intScanner.nextInt();
        System.out.println("Enter the length of the landing lane");
        int newLandingLaneLength = intScanner.nextInt();
        airline.Airports.get(airportCode).addLandingLane(new LandingLane(newLandingLaneCode, newLandingLaneLength));
    }

    /**
     * Obtains the data necesary to set up a new plane and returns it
     * 
     * @return The new plane created with the data obtained from the user
     */
    public static Plane getPlaneDataFromUser() {
        Scanner stringScanner = new Scanner(System.in);
        System.out.println("Enter the name of the plane");
        String newPlaneName = stringScanner.nextLine();
        System.out.println("Enter the airline of the plane");
        String newPlaneAirline = stringScanner.nextLine();
        System.out.println("Enter the code of the plane");
        String newPlaneCode = stringScanner.nextLine();
        System.out.println("Enter the arrival time of the plane");
        LocalDateTime newPlaneArrival = LocalDateTime.parse(stringScanner.nextLine());
        System.out.println("Enter the departure time of the plane");
        LocalDateTime newPlaneDeparture = LocalDateTime.parse(stringScanner.nextLine());

        return new Plane(newPlaneName, newPlaneAirline, newPlaneCode, newPlaneArrival, newPlaneDeparture);
    }

    /**
     * Creates the initial data of the program, being STEMCo the only airline, with
     * 100 planes, 3 airports 5 to 15 landing lanes each, and 100 passengers
     */
    public static void inicialization() {
        Airline STEMCo = new Airline("STEMCo");
        for (Integer i = 0; i < 100; i++) {
            LocalDateTime initialTime = Faker.getRandomDateTime(dateOfStart, dateOfEnd);
            Plane newPlane = new Plane(Faker.nombre(), "STEM Airlines", i.toString(),
                    initialTime, Faker.getRandomDateTime(initialTime, dateOfEnd));
            STEMCo.addPlane(newPlane);
        }

        for (int i = 0; i < STEMCo.Planes.size(); i++) {
            Passenger newPassenger = new Passenger(Faker.nombre(), Faker.apellido(), i, Faker.entero(12, 65), i,
                    Faker.buleano(), Faker.entero(0, 2));
            STEMCo.Planes.get(i).fakerReserveSeat(newPassenger);
        }

        for (int i = 0; i < 3; i++) {
            Airport newAirport = new Airport(Faker.nombre(), Faker.lorem(1), Faker.lorem(1));
            STEMCo.addAirport(newAirport);
        }

        for (int i = 0; i < STEMCo.Airports.size(); i++) {
            for (int j = 0; j < Faker.entero(5, 15); j++) {
                LandingLane newLandingLane = new LandingLane(j, Faker.entero(100, 200));
                STEMCo.Airports.get(i).addLandingLane(newLandingLane);
            }
        }
        airlines.add(STEMCo);
        // System.out.println(STEMCo.toString());
        System.out.println("Initial data loaded");
    }

    /**
     * Checks if an airline exists
     * 
     * @param airline The name of the airline we are looking for
     * @return True if the airline exists, false if it does not
     */
    public static boolean airlineExists(String airline) {
        boolean exists = false;
        for (int i = 0; i < airlines.size() && exists == false; i++) {
            if (airlines.get(i).getName().equalsIgnoreCase(airline)) {
                exists = true;
            }
        }
        if (exists == false) {
            System.out.println("Airline not found");
        }
        return exists;
    }

    /**
     * Checks if an airport exists
     * 
     * @param airport The name of the airport we are looking for
     * @param airline The airline the airport belongs to
     * @return True if the airport exists, false if it does not
     */
    public static boolean airportExists(String airport, String airline) {
        boolean exists = false;
        for (int i = 0; i < findAirlineByName(airline, airlines).Airports.size(); i++) {
            if (findAirlineByName(airline, airlines).Airports.get(i).getName().equalsIgnoreCase(airport)) {
                exists = true;
            }
        }
        if (exists == false) {
            System.out.println("Airport not found");
        }
        return exists;
    }

    /**
     * Checks if a plane exists
     * 
     * @param planePlate The plate of the plane we are looking for
     * @param airline    The airline the plane belongs to
     * @return True if the plane exists, false if it does not
     */
    public static boolean planeExists(String planePlate, String airline) {
        boolean exists = false;
        for (int j = 0; j < findAirlineByName(airline, airlines).Planes.size(); j++) {
            if (findAirlineByName(airline, airlines).Planes.get(j).getPlate().equalsIgnoreCase(planePlate)) {
                exists = true;
            }
        }
        if (exists == false) {
            System.out.println("Plane not found");
        }

        return exists;
    }

    /**
     * Checks if a landing lane exists
     * 
     * @param landingLaneCode The code of the landing lane we are looking for
     * @param airline         The airline the landing lane belongs to
     * @param airport         The airport the landing lane belongs to
     * @return True if the landing lane exists, false if it does not
     */
    public static boolean landingLaneExists(int landingLaneCode, String airline, String airport) {
        boolean exist = false;

        if (landingLaneCode != -1) {
            for (int j = 0; j < findAirlineByName(airline, airlines).Airports
                    .get(findAirportPosOnArray(airport, airline)).LandingLanes.size(); j++) {
                if (findAirlineByName(airline, airlines).Airports
                        .get(findAirportPosOnArray(airport, airline)).LandingLanes
                        .get(j)
                        .getCode() == landingLaneCode) {
                    exist = true;
                }
            }
            if (exist == false) {
                System.out.println("Landing lane not found");
            }
        }
        return exist;
    }

    /**
     * Finds the position of a plane in the array of planes
     * 
     * @param planePlate The plate of the plane we are looking for
     * @param airline    The airline the plane belongs to
     * @return The position of the plane in the array of planes as an int
     */
    public static int findPlanePosOnArray(String planePlate, String airline) {
        int planeCode = 0;
        for (int j = 0; j < findAirlineByName(airline, airlines).Planes.size(); j++) {
            if (findAirlineByName(airline, airlines).Planes.get(j).getPlate().equalsIgnoreCase(planePlate)) {
                planeCode = j;
            }
        }
        return planeCode;
    }

    /**
     * Finds the position of an airport in the array of airports
     * 
     * @param airportName The name of the airport we are looking for
     * @param airline     The airline the airport belongs to
     * @return The position of the airport in the array of airports as an int
     */
    public static int findAirportPosOnArray(String airportName, String airline) {
        int airportCode = 0;
        for (int i = 0; i < findAirlineByName(airline, airlines).Airports.size(); i++) {
            if (findAirlineByName(airline, airlines).Airports.get(i).getName().equalsIgnoreCase(airportName)) {
                airportCode = i;
            }
        }
        return airportCode;
    }

    /**
     * Finds a passenger by its seat
     * 
     * @param planePlate The plate of the plane the passenger is in
     * @param airline    The airline the plane belongs to
     * @param row        The row of the seat the passenger is in
     * @param column     The column of the seat the passenger is in
     * @return The passenger we are looking for
     */
    public static Passenger findPassengerBySeat(String planePlate, String airline, int row, int column) {
        Passenger passenger = null;

        passenger = findAirlineByName(airline, airlines).Planes
                .get(findPlanePosOnArray(planePlate, airline)).sits[column][row];
        return passenger;
    }

    /**
     * Gets the row of a seat from the seat number
     * 
     * @param seatNumber The seat number we are gonna get the row from
     * @return The row of the seat as an int
     */
    public static int getRow(String seatNumber) {
        return Integer.parseInt(seatNumber.substring(0, 2));
    }

    /**
     * Gets the column of a seat from the seat number
     * 
     * @param seatNumber The seat number we are gonna get the column from
     * @return The column of the seat as an int
     */
    public static int getColumn(String seatNumber) {
        return seatNumber.charAt(2) - 65;
    }

    /**
     * Gets the airline name from the user showing only the available airlines
     * 
     * @return The name of the airline the user entered
     */
    public static String getAirlineFromUser() {
        Scanner stringScanner = new Scanner(System.in);
        String line = "Airlines available:\n";
        for (int i = 0; i < airlines.size(); i++) {
            line += airlines.get(i).getName() + "\n";
        }
        System.out.println(line);
        System.out.println("Enter the name of the airline:");
        String airlineName = stringScanner.nextLine();
        return airlineName;
    }

    /**
     * Gets the airport name from the user showing only the available airports
     * 
     * @param airline The airline the airport belongs to
     * @return The name of the airport the user entered
     */
    public static String getAirportFromUser(String airline) {
        Scanner stringScanner = new Scanner(System.in);
        String line = "Airports available:\n";
        for (int i = 0; i < findAirlineByName(airline, airlines).Airports.size(); i++) {
            line += findAirlineByName(airline, airlines).Airports.get(i).getName() + "\n";
        }
        System.out.println(line);
        System.out.println("Enter the name of the airport:");
        String airportName = stringScanner.nextLine();
        return airportName;
    }

    /**
     * Gets the landing lane code from the user, showing the available landing lanes
     * by checkign the compatibility with the new plane that we wanna add to a
     * landing lane.
     * 
     * @param airline        The ariline the landing lane and the plane belong to
     * @param airport        The airport the landing lane belongs to
     * @param arrivalOfPlane The localdatetime we wanna be checking for
     *                       compatibility with the landing lane
     * @return The code of the landing lane we are gonna be adding the new plane to
     */
    public static int getLandingLaneCodeFromUser(String airline, String airport, LocalDateTime arrivalOfPlane,
            LocalDateTime departureOfPlane, String planeCode) {
        Scanner intScanner = new Scanner(System.in);
        String line = "Landing lanes available:\n";
        LandingLane planeAsignatedLine = findAirlineByName(airline, airlines).Planes
                .get(findPlanePosOnArray(planeCode, airline)).getAsigned();
        Airport newAirport = findAirlineByName(airline, airlines).Airports
        .get(findAirportPosOnArray(airport, airline));
        boolean alreadyOnLane = false;
        for (int i = 0; i < newAirport.LandingLanes.size(); i++) {

            LandingLane landingLane = newAirport.LandingLanes.get(i);
            alreadyOnLane = false;

            if (!checkCompatibilityWithLane(airline, airport, i, arrivalOfPlane)) {
                if (planeAsignatedLine == landingLane) {
                    line += landingLane.getCode()
                            + " Available: already asigned to that landing lane\n";
                    alreadyOnLane = true;
                } else {
                    landingLane.setAvailable(false);
                }
            } else {
                landingLane.setAvailable(true);
            }
            if (alreadyOnLane == false) {
                line += landingLane.getCode() + " Available: "
                        + landingLane.getAvailable()
                        + "\n";

            }
        }
        System.out.println(line);
        System.out.println("Enter the code of the landing lane:");

        int landingLaneCode = intScanner.nextInt();

        // Asignate the landing lane to the airplane array

        return landingLaneCode;
    }

    /**
     * Gets the arrival time of a plane base on a a planecode
     * 
     * @param airline   The airline the plane belongs to
     * @param planeCode The code of the plane we want to get the arrival time
     * @return The arrival time of a plane
     */
    public static LocalDateTime getPlaneLocalDateTimeArrivalFromCode(String airline, String planeCode) {
        return findAirlineByName(airline, airlines).Planes
                .get(findPlanePosOnArray(planeCode, airline)).getArrival();
    }

    /**
     * Gets the departure time of a plane base on a a planecode
     * 
     * @param airline   The airline the plane belongs to
     * @param planeCode The code of the plane we want to get the departure time
     * @return The departure time of a plane
     */
    public static LocalDateTime getPlaneLocalDateTimeDepartureFromCode(String airline, String planeCode) {
        return findAirlineByName(airline, airlines).Planes
                .get(findPlanePosOnArray(planeCode, airline)).getDeparture();
    }

    /**
     * This is the most convoluted function:
     * First it checks if the plane can land on the landing lanes and then checks
     * wether its already there or not
     * If its not and the plane has no asigned landing lane it just adds the plane
     * to the landing lane
     * If it already has the same landing lane nothing but a System.out happens
     * If the plane already has a diferent landing lane the funct ask the user
     * wether to keep the original landing lane in wich case nothing happens or
     * wether to change it to the new landing lane removing the plane from the lane
     * traffic of said landing lane and updating the plane asigned landing lane
     * information
     * 
     * @param airline         The airline the plane and the landing lane belong to
     * @param airport         The airport where the landing lane is located
     * @param landingLaneCode The code of the landing lane we want to asing to the
     *                        new plane
     * @param arrivalOfPlane  Time of arrival of plane
     * @param planeCode       Code of the plane we want to asign to the landing lane
     */
    public static void checkPlaneLandingLaneStatus(String airline, String airport, int landingLaneCode,
            LocalDateTime arrivalOfPlane, String planeCode) {
        Plane asignedPlane = findAirlineByName(airline, airlines).Planes
                .get(findPlanePosOnArray(planeCode, airline));
        LandingLane planeAsignatedLine = asignedPlane.getAsigned();
        Scanner stringScanner = new Scanner(System.in);
        Airport newAsignedAirport = findAirlineByName(airline, airlines).Airports
                .get(findAirportPosOnArray(airport, airline));
        LandingLane[] alreadyOnLanePermanent = new LandingLane[1];

        for (int i = 0; i < newAsignedAirport.LandingLanes.size(); i++) {
            LandingLane landingLane = newAsignedAirport.LandingLanes.get(i);
            if (!checkCompatibilityWithLane(airline, airport, i, arrivalOfPlane)) {
                if (planeAsignatedLine == landingLane) {
                    alreadyOnLanePermanent[0] = landingLane;
                }
            }
        }

        if (!checkCompatibilityWithLane(airline, airport, landingLaneCode, arrivalOfPlane)) {
            System.out.println("You cannot select that Landing Lane since its unavailable");
        } else {
            if (planeAsignatedLine == null) {
                asignedPlane
                        .setAsigned(newAsignedAirport.LandingLanes.get(landingLaneCode));
                newAsignedAirport.LandingLanes
                        .get(landingLaneCode)
                        .addPlaneToLandingLane(
                                asignedPlane);
                System.out.println("The plane has been updated to Landing Lane: " + landingLaneCode + " Airport: "
                        + newAsignedAirport);
            } else {
                Airport planeAsignedAirport = newAsignedAirport.LandingLanes.get(planeAsignatedLine.getCode())
                        .getAsignedAirport();

                if (alreadyOnLanePermanent[0] != null && alreadyOnLanePermanent[0].getCode() == landingLaneCode) {
                    System.out.println("Plane already on that lane");
                    landingLaneCode = -1;
                } else {
                    System.out.println("The plane is already asigned to Landing Lane: " + planeAsignatedLine.getCode()
                            + " From airport: " + planeAsignedAirport.getName() + "\nWould you like to change it to: "
                            + landingLaneCode + " Airport: " + newAsignedAirport.getName() + " (y/n)");
                    String input = stringScanner.nextLine();
                    if (input.equalsIgnoreCase("y")) {
                        System.out
                                .println("The plane has been updated to Landing Lane: " + landingLaneCode + " Airport: "
                                        + newAsignedAirport.getName());

                        for (int i = 0; i < planeAsignatedLine.laneTraffic.size(); i++) {
                            if (planeAsignatedLine.laneTraffic.get(i).getPlate().equals(asignedPlane.getPlate())) {
                                planeAsignatedLine.laneTraffic.remove(i);
                            }
                        }
                        newAsignedAirport.LandingLanes
                                .get(landingLaneCode)
                                .addPlaneToLandingLane(
                                        asignedPlane);
                        asignedPlane
                                .setAsigned(newAsignedAirport.LandingLanes.get(landingLaneCode));

                    } else {
                        System.out.println("The plane has not been changed");
                    }
                }
            }
        }

    }

    /**
     * Checks if the new plane is compatible with the landing lane we wanna add it
     * to
     * 
     * @param airline  The airline the plane and the landing lane belong to
     * @param airport  The airport the landing lane belongs to
     * @param i        The position of the landing lane in the array of landing
     *                 lanes
     * @param newPlane The plane we wanna add to the landing lane
     * @return True if the plane is compatible with the landing lane, false if it is
     *         not
     */
    public static boolean checkCompatibilityWithLane(String airline, String airport, int i,
            LocalDateTime arrivalOfPlane) {
        boolean compatibleWithLane = false;
        LandingLane landingLaneBeingChecked = findAirlineByName(airline, airlines).Airports
                .get(findAirportPosOnArray(airport, airline)).LandingLanes
                .get(i);
        if (landingLaneBeingChecked.laneTraffic.size() == 0) {
            compatibleWithLane = true;
        } else {
            LocalDateTime lastPlaneDeparture = landingLaneBeingChecked.laneTraffic.getLast()
                    .getDeparture();
            if (arrivalOfPlane.isAfter(lastPlaneDeparture)) {
                compatibleWithLane = true;
            }
        }
        return compatibleWithLane;
    }

    /**
     * Get the plane plate/code from the user showing only the available planes
     * 
     * @param airline Airline wich we are working on
     * @return The plane plate/code
     */
    public static String getPlaneCodeFromUser(String airline) {
        Scanner stringScanner = new Scanner(System.in);
        String line = "Planes available:\n";
        for (int i = 0; i < findAirlineByName(airline, airlines).Planes.size(); i++) {
            Plane plane = findAirlineByName(airline, airlines).Planes.get(i);
            if (plane.getAsigned() != null) {
                line += plane.getPlate() + " This plane is Asigned to the landing lane: " + plane.getAsigned().getCode()
                        + " on the Airport: " + plane.getAsigned().getAsignedAirport().getName() + "\n";
            } else {
                line += plane.getPlate() + "\n";
            }

        }
        System.out.println(line);
        System.out.println("Enter the code of the plane:");
        String planeCode = stringScanner.nextLine();
        return planeCode;
    }

    /**
     * Get the seat number from the user showing only the available seats
     * 
     * @param airline The airline the plane belongs to
     * @return The seat number the user entered
     */
    public static String getSeatNumberFromUser(String airline) {
        Scanner stringScanner = new Scanner(System.in);
        String line = "Sits available:\n";
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 6; j++) {
                if (findAirlineByName(airline, airlines).Planes
                        .get(findPlanePosOnArray(airline, airline)).sits[j][i] == null) {
                    line += i + (char) (j + 65) + " ";
                } else {
                    line += " X ";
                }
            }
            line += "\n";
        }
        System.out.println(line);
        System.out.println("Enter the seat number of the passenger:");
        String seatNumber = stringScanner.nextLine();
        while (seatNumber.length() != 3) {
            System.err.println("Invalid seat number");
            System.out.println("Enter the seat number of the passenger:");
            seatNumber = stringScanner.nextLine();
        }
        return seatNumber;
    }

    /**
     * Creates a new airline
     */
    public static void createAirline() {
        // TODO: Implementar
        Scanner stringScanner = new Scanner(System.in);
    }

    /**
     * Creates a new airport
     */
    public static void createAirport() {
        String airlineName = getAirlineFromUser();
        Airline airline = findAirlineByName(airlineName, airlines);
        if (airline != null) {
            createAirport(airline);
        } else {
            System.out.println("Airline not found.");
        }
    }

    /**
     * Creates a new landing lane
     */
    public static void createLandingLane() {
        String airlineName = getAirlineFromUser();
        if (airlineExists(airlineName)) {
            String airportName = getAirportFromUser(airlineName);
            if (airportExists(airportName, airlineName)) {
                getLandingLaneDataFromUser(findAirlineByName(airlineName, airlines),
                        findAirportPosOnArray(airportName, airlineName));
            }
        }
    }

    /**
     * Creates a new plane
     */
    public static void createPlane() {
        Scanner stringScanner = new Scanner(System.in);
        String newPlaneAirline = getAirlineFromUser();

        if (airlineExists(newPlaneAirline)) {
            System.out.println("Enter the name of the plane");
            String newPlaneName = stringScanner.nextLine();
            System.out.println("Enter the code of the plane");
            String newPlaneCode = stringScanner.nextLine();
            System.out.println("Enter the arrival time of the plane");
            LocalDateTime newPlaneArrival = LocalDateTime.parse(stringScanner.nextLine());
            System.out.println("Enter the departure time of the plane");
            LocalDateTime newPlaneDeparture = LocalDateTime.parse(stringScanner.nextLine());
            findAirlineByName(newPlaneAirline, airlines).addPlane(new Plane(newPlaneName, newPlaneAirline,
                    newPlaneCode, newPlaneArrival, newPlaneDeparture));
        }
    }

    /**
     * Creates a new passenger
     */
    public static void createPassenger() {
        Scanner intScanner = new Scanner(System.in);
        Scanner stringScanner = new Scanner(System.in);

        String newPassengerAirline = getAirlineFromUser();
        if (airlineExists(newPassengerAirline)) {
            String newPassengerPlaneCode = getPlaneCodeFromUser(newPassengerAirline);
            if (planeExists(newPassengerPlaneCode, newPassengerAirline)) {
                System.out.println("Enter the name of the passenger");
                String newPassengerName = stringScanner.nextLine();
                System.out.println("Enter the last name of the passenger");
                String newPassengerLastName = stringScanner.nextLine();
                System.out.println("Enter the age of the passenger");
                int newPassengerAge = intScanner.nextInt();
                System.out.println("Enter the airline name of the fligth");
                int newPassengerSeat = intScanner.nextInt();
                System.out.println("Enter if the passenger has checked luggage");
                boolean newPassengerCheckedLugagge = stringScanner.nextBoolean();
                System.out.println("Enter the luggage of the passenger");
                int newPassengerLuggage = intScanner.nextInt();
                findAirlineByName(newPassengerAirline, airlines).Planes
                        .get(findPlanePosOnArray(newPassengerPlaneCode, newPassengerAirline))
                        .reserveSeat(new Passenger(newPassengerName, newPassengerLastName, newPassengerAge,
                                newPassengerSeat, newPassengerLuggage, newPassengerCheckedLugagge,
                                newPassengerLuggage));
            }
        }
    }

    /**
     * Assigns a plane to a landing lane
     */
    public static void assingnPlanesToLandingLanes() {
        String airlineName = getAirlineFromUser();

        if (airlineExists(airlineName)) {
            String airportName = getAirportFromUser(airlineName);
            if (airportExists(airportName, airlineName)) {
                String planeCode = getPlaneCodeFromUser(airlineName);
                if (planeExists(planeCode, airlineName)) {
                    int landingLaneCode = getLandingLaneCodeFromUser(airlineName, airportName,
                            getPlaneLocalDateTimeArrivalFromCode(airlineName, planeCode),
                            getPlaneLocalDateTimeDepartureFromCode(airlineName, planeCode), planeCode);
                    if (landingLaneExists(landingLaneCode, airlineName, airportName)) {
                        checkPlaneLandingLaneStatus(airlineName, airportName, landingLaneCode,
                                getPlaneLocalDateTimeArrivalFromCode(airlineName, planeCode), planeCode);
                    }
                }
            }
        }
    }

    /**
     * Shows the airport information
     */
    public static void showAirportInformation() {
        String airlineName = getAirlineFromUser();

        if (airlineExists(airlineName)) {
            String airportName = getAirportFromUser(airlineName);
            if (airportExists(airportName, airlineName)) {
                System.out.println(findAirlineByName(airlineName, airlines).Airports
                        .get(findAirportPosOnArray(airportName, airlineName)).toString());
            }
        }
    }

    /**
     * Shows the Plane information
     */
    public static void showPlaneInformation() {
        String airlineName = getAirlineFromUser();
        if (airlineExists(airlineName)) {
            String planeCode = getPlaneCodeFromUser(airlineName);
            if (planeExists(planeCode, airlineName)) {
                System.out.println(findAirlineByName(airlineName, airlines).Planes
                        .get(findPlanePosOnArray(planeCode, airlineName)).toString());
            }
        }
    }

    /**
     * Shows the passenger information
     */
    public static void showPassengerInformation() {
        String airlineName = getAirlineFromUser();

        if (airlineExists(airlineName)) {
            String planeCode = getPlaneCodeFromUser(airlineName);
            if (planeExists(planeCode, airlineName)) {
                String seatNumber = getSeatNumberFromUser(airlineName);
                Passenger passenger = findPassengerBySeat(planeCode, airlineName, getRow(seatNumber),
                        getColumn(seatNumber));
                if (passenger != null) {
                    System.out.println(passenger.toString());
                } else {
                    System.err.println("Passenger not found");
                }

            }
        }
    }

    /**
     * Shows the landing lane information
     */
    public static void showLandingLaneInformation() {
        String airlineName = getAirlineFromUser();

        if (airlineExists(airlineName)) {
            String airportName = getAirportFromUser(airlineName);
            if (airportExists(airportName, airlineName)) {
                // WIP getLandingLaneCodeFromUser(airlineName, airportName) so that it works
                int landingLaneCode = getLandingLaneCodeFromUser(airlineName, airportName, LocalDateTime.now(),
                        LocalDateTime.now().plusSeconds(1), null);
                if (landingLaneExists(landingLaneCode, airlineName, airportName)) {
                    System.out.println(findAirlineByName(airlineName, airlines).Airports
                            .get(findAirportPosOnArray(airportName, airlineName)).LandingLanes
                            .get(landingLaneCode)
                            .toString());
                }
            }
        }
    }

    /**
     * Part of the code that actually runs <3
     * 
     * @param args IDK BRUH
     */
    public static void main(String[] args) {
        inicialization();
        Scanner intScanner = new Scanner(System.in);
        boolean EXIT = false;

        while (EXIT == false) {
            menu();
            int input = intScanner.nextInt();
            if (input == 1) {
                creationSubMenu();
                input = intScanner.nextInt();

                if (input == 1) {
                    createAirport();
                } else if (input == 2) {
                    createLandingLane();
                } else if (input == 3) {
                    createPlane();
                } else if (input == 4) {
                    createPassenger();
                } else if (input == 5) {
                    createAirline();
                } else {
                    System.out.println("Invalid input");
                }

            } else if (input == 2) {
                assingnPlanesToLandingLanes();

            } else if (input == 3) {
                informationSubMenu();
                input = intScanner.nextInt();

                if (input == 1) {
                    showAirportInformation();
                } else if (input == 2) {
                    showLandingLaneInformation();
                } else if (input == 3) {
                    showPlaneInformation();
                } else if (input == 4) {
                    showPassengerInformation();
                } else {
                    System.out.println("Invalid input");
                }

            } else if (input == 4) {
                EXIT = true;
                System.err.println("Exiting program");
            } else {
                System.err.println("Invalid input");
            }
        }
    }
}