package Biblioteca;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.time.temporal.ChronoUnit;

/**
 * Clase Faker para generar datos aleatorios.
 */
public class Faker {
    // Arrays con datos de ejemplo
    private static final String[] nombres = {
            "Juan", "Pedro", "María", "Ana", "Luis", "Sofía", "Carlos", "Laura", "Fernando", "Elena",
            "Miguel", "Isabel", "Javier", "Beatriz", "Andrés", "Carmen", "Hugo", "Valeria", "Ricardo", "Paula",
            "Gabriel", "Alejandra", "Roberto", "Manuela", "Diego", "Victoria", "Daniel", "Natalia", "Álvaro", "Marta"
    };

    private static final String[] apellidos = {
            "García", "Rodríguez", "Martínez", "López", "González", "Pérez", "Fernández", "Sánchez", "Ramírez",
            "Torres",
            "Díaz", "Jiménez", "Moreno", "Vargas", "Rojas", "Castro", "Mendoza", "Romero", "Herrera", "Ortega",
            "Navarro", "Delgado", "Cabrera", "Reyes", "Acosta", "Campos", "Peña", "Vega", "Guerrero", "Cruz"
    };

    private static final String[] ciudades = {
            "Madrid", "Barcelona", "Buenos Aires", "Ciudad de México", "Lima", "Bogotá", "Santiago", "Caracas",
            "Montevideo", "Quito", "La Paz", "San Salvador", "San José", "Managua", "Asunción", "Brasilia",
            "Lisboa", "Roma", "París", "Berlín", "Londres", "Nueva York", "Los Ángeles", "Chicago", "Toronto",
            "Tokio", "Seúl", "Pekín", "Bangkok", "Sídney", "Ámsterdam", "Dublín", "Moscú", "Atenas", "Dubái"
    };

    // Fragmentos de texto Lorem Ipsum ampliado
    private static final String[] palabrasLorem = {
            "Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "sed", "do",
            "eiusmod", "tempor", "incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua", "ut",
            "enim", "ad", "minim", "veniam", "quis", "nostrud", "exercitation", "ullamco", "laboris",
            "nisi", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "duis", "aute", "irure",
            "dolor", "in", "reprehenderit", "voluptate", "velit", "esse", "cillum", "fugiat", "pariatur"
    };

    private static final String[] idiomas = {
            "Español", "Inglés", "Francés", "Alemán", "Italiano", "Portugués", "Chino", "Japonés", "Coreano", "Ruso"
    };

    private static final String[] aeropuertos = {
            "Madrid - Barajas | Spain", "Barcelona - El Prat | Spain", "Paris - Charles de Gaulle | France",
            "London - Heathrow | UK", "Frankfurt - Frankfurt | Germany",
            "Amsterdam - Schiphol | Netherlands", "Rome - Fiumicino | Italy", "Munich - Munich | Germany",
            "Istanbul - Istanbul | Turkey", "Zurich - Zurich | Switzerland",
            "Vienna - Vienna | Austria", "Brussels - Brussels | Belgium", "Copenhagen - Copenhagen | Denmark",
            "Stockholm - Arlanda | Sweden", "Oslo - Gardermoen | Norway",
            "Helsinki - Vantaa | Finland", "Dublin - Dublin | Ireland", "Lisbon - Lisbon | Portugal",
            "Warsaw - Chopin | Poland", "Prague - Prague | Czech Republic",
            "Budapest - Budapest | Hungary", "Athens - Athens | Greece", "Moscow - Sheremetyevo | Russia",
            "Saint Petersburg - Pulkovo | Russia", "Kiev - Boryspil | Ukraine",
            "Bucharest - Henri Coanda | Romania", "Sofia - Sofia | Bulgaria", "Belgrade - Belgrade | Serbia",
            "Zagreb - Zagreb | Croatia", "Ljubljana - Ljubljana | Slovenia",
            "Sarajevo - Sarajevo | Bosnia and Herzegovina", "Skopje - Skopje | North Macedonia",
            "Tirana - Tirana | Albania", "Podgorica - Podgorica | Montenegro", "Pristina - Pristina | Kosovo",
            "Tallinn - Tallinn | Estonia", "Riga - Riga | Latvia", "Vilnius - Vilnius | Lithuania",
            "Minsk - Minsk | Belarus", "Chisinau - Chisinau | Moldova",
            "Tbilisi - Tbilisi | Georgia", "Yerevan - Yerevan | Armenia", "Baku - Baku | Azerbaijan",
            "Almaty - Almaty | Kazakhstan", "Astana - Astana | Kazakhstan",
            "Tashkent - Tashkent | Uzbekistan", "Bishkek - Bishkek | Kyrgyzstan", "Dushanbe - Dushanbe | Tajikistan",
            "Ashgabat - Ashgabat | Turkmenistan", "Ulaanbaatar - Ulaanbaatar | Mongolia",
            "Beijing - Capital | China", "Shanghai - Pudong | China", "Hong Kong - Hong Kong | China",
            "Tokyo - Narita | Japan", "Seoul - Incheon | South Korea",
            "Bangkok - Suvarnabhumi | Thailand", "Singapore - Changi | Singapore",
            "Kuala Lumpur - Kuala Lumpur | Malaysia", "Jakarta - Soekarno-Hatta | Indonesia",
            "Manila - Ninoy Aquino | Philippines",
            "Hanoi - Noi Bai | Vietnam", "Ho Chi Minh City - Tan Son Nhat | Vietnam",
            "Phnom Penh - Phnom Penh | Cambodia", "Vientiane - Wattay | Laos", "Yangon - Yangon | Myanmar",
            "Dhaka - Hazrat Shahjalal | Bangladesh", "Colombo - Bandaranaike | Sri Lanka", "Male - Velana | Maldives",
            "Kathmandu - Tribhuvan | Nepal", "Thimphu - Paro | Bhutan",
            "New Delhi - Indira Gandhi | India", "Mumbai - Chhatrapati Shivaji | India",
            "Bangalore - Kempegowda | India", "Chennai - Chennai | India", "Hyderabad - Hyderabad | India",
            "Karachi - Jinnah | Pakistan", "Lahore - Allama Iqbal | Pakistan", "Islamabad - Islamabad | Pakistan",
            "Kabul - Hamid Karzai | Afghanistan", "Tashkent - Tashkent | Uzbekistan",
            "Dubai - Dubai | UAE", "Abu Dhabi - Abu Dhabi | UAE", "Doha - Hamad | Qatar",
            "Riyadh - King Khalid | Saudi Arabia", "Jeddah - King Abdulaziz | Saudi Arabia",
            "Kuwait - Kuwait | Kuwait", "Bahrain - Bahrain | Bahrain", "Muscat - Muscat | Oman",
            "Tehran - Imam Khomeini | Iran", "Baghdad - Baghdad | Iraq",
            "Amman - Queen Alia | Jordan", "Beirut - Rafic Hariri | Lebanon", "Damascus - Damascus | Syria",
            "Cairo - Cairo | Egypt", "Alexandria - Borg El Arab | Egypt",
            "Casablanca - Mohammed V | Morocco", "Algiers - Houari Boumediene | Algeria", "Tunis - Carthage | Tunisia",
            "Tripoli - Mitiga | Libya", "Rabat - Sale | Morocco"
    };

    private static final String[] planeModels = {
            "Boeing 737",
            "Boeing 747",
            "Boeing 757",
            "Boeing 767",
            "Boeing 777",
            "Boeing 787 Dreamliner",
            "Airbus A220",
            "Airbus A300",
            "Airbus A310",
            "Airbus A318",
            "Airbus A319",
            "Airbus A320",
            "Airbus A321",
            "Airbus A330",
            "Airbus A340",
            "Airbus A350",
            "Airbus A380",
            "Embraer E170",
            "Embraer E175",
            "Embraer E190",
            "Embraer E195",
            "Bombardier CRJ200",
            "Bombardier CRJ700",
            "Bombardier CRJ900",
            "Bombardier CRJ1000",
            "McDonnell Douglas MD-80",
            "McDonnell Douglas MD-90",
            "McDonnell Douglas DC-10",
            "McDonnell Douglas MD-11",
            "Cessna 172",
            "Cessna Citation X",
            "ATR 42",
            "ATR 72",
            "Concorde",
            "Lockheed Martin C-130 Hercules",
            "Sukhoi Superjet 100",
            "Tupolev Tu-154",
            "Ilyushin Il-76",
            "Antonov An-225 Mriya"
    };

    public static final String[] bookTitles = {
        "The Great Adventure", "Mystery of the Lost Island", "Journey to the Unknown",
        "The Secret Keeper", "Legends of the Ancient World", "The Last Kingdom",
        "Whispers in the Dark", "The Forgotten City", "Echoes of the Past",
        "The Time Traveler's Diary", "Shadows of the Forest", "The Hidden Treasure",
        "The Alchemist's Code", "The Enchanted Castle", "The Pirate's Curse",
        "The Golden Compass", "The Final Frontier", "The Dragon's Legacy",
        "The Phantom's Revenge", "The Sorcerer's Apprentice", "The Eternal Flame",
        "The Crystal Maze", "The Haunted Manor", "The Lost Chronicles",
        "The Warrior's Path", "The Forbidden Spell", "The Starry Night",
        "The Silent Witness", "The Crimson Tide", "The Emerald Crown",
        "The Sapphire Secret", "The Ruby Quest", "The Diamond Heist",
        "The Shadow Hunter", "The Ice Queen's Curse", "The Fire Within",
        "The Waterfall's Whisper", "The Desert Rose", "The Midnight Sun",
        "The Winter's Tale", "The Summer's Dream", "The Autumn's Call",
        "The Spring's Awakening", "The Moonlit Path", "The Sunlit Horizon",
        "The Storm Chaser", "The Wind Whisperer", "The Ocean's Song",
        "The Mountain's Echo", "The Valley of Secrets", "The River's Journey",
        "The Sky's Embrace", "The Forest's Heart", "The Island of Dreams",
        "The City of Gold", "The Village of Shadows", "The Castle of Illusions",
        "The Tower of Light", "The Bridge of Time", "The Road to Eternity",
        "The Garden of Eden", "The Labyrinth of Truth", "The Mirror of Lies",
        "The Book of Spells", "The Scroll of Wisdom", "The Key to the Future",
        "The Door to the Past", "The Window to the Soul", "The Portrait of a Lady",
        "The Tale of Two Cities", "The Chronicles of Narnia", "The Hobbit's Journey",
        "The Fellowship of the Ring", "The Return of the King", "The Two Towers",
        "The Catcher in the Rye", "To Kill a Mockingbird", "Pride and Prejudice",
        "Sense and Sensibility", "Wuthering Heights", "Jane Eyre",
        "The Picture of Dorian Gray", "The Count of Monte Cristo", "Les Misérables",
        "War and Peace", "Anna Karenina", "Crime and Punishment",
        "The Brothers Karamazov", "The Idiot", "The Master and Margarita",
        "The Old Man and the Sea", "For Whom the Bell Tolls", "A Farewell to Arms",
        "The Sun Also Rises", "The Grapes of Wrath", "Of Mice and Men",
        "East of Eden", "The Pearl", "The Red Pony", "The Winter of Our Discontent"
    };

    public static final String[] categories = {
        "Fiction", "Non-Fiction", "Science Fiction", "Fantasy", "Mystery",
        "Thriller", "Romance", "Historical Fiction", "Biography", "Self-Help",
        "Philosophy", "Psychology", "Science", "Technology", "Education",
        "Travel", "Adventure", "Horror", "Poetry", "Drama"
    };




    /**
     * Genera un número entero aleatorio entre min y max (inclusive).
     * 
     * @param min Valor mínimo.
     * @param max Valor máximo.
     * @return Número entero aleatorio.
     */
    public static int entero(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min)) + min;
    }

    public static String categoria() {
        return categories[entero(0, categories.length)];
    }
    public static String titulo() {
        return bookTitles[entero(0, bookTitles.length)];
    }

    public static String url(){
        return "https://www." + bookTitles[entero(0, bookTitles.length)] + ".com";
    }

    /**
     * Genera un idioma aleatorio.
     * @return
     */
    public static String idioma() {
        return idiomas[entero(0, idiomas.length)];
    }

    /**
     * Genera un modelo de avión aleatorio.
     * @return
     */
    public static String modeloAvion() {
        return planeModels[entero(0, planeModels.length)];
    }

    /**
     * Genera un DNI aleatorio.
     * @return
     */
    public static String DNI() {
        String line = "";
        for (int i = 0; i < 8; i++) {
            line += entero(0, 9);
        }
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int numero = entero(0, 22);
        line += letras.charAt(numero);
        return line;
    }

    /**
     * Genera una matrícula aleatoria.
     * @return
     */
    public static String matricula() {
        String line = "";
        for (int i = 0; i < 4; i++) {
            line += (char) entero(65, 90);
        }
        line += "-";
        for (int i = 0; i < 4; i++) {
            line += entero(0, 9);
        }
        return line;
    }

    /**
     * Genera un nombre de aeropuerto aleatorio.
     * @return
     */
    public static String nombresAeropuertos() {
        return aeropuertos[entero(0, aeropuertos.length)];
    }

    /**
     * Genera una posición de trabajo aleatoria.
     * @return
     */
    public static String posicionTrabajo() {
        String[] posiciones = { "Copiloto", "Azafata", "Azafato", "Mecánico" };
        return posiciones[entero(0, posiciones.length)];
    }

    /**
     * Genera un buleano.
     * 
     * @return Buleano.
     */
    public static boolean buleano() {
        return (entero(0, 1) == 1);
    }

    /**
     * Genera un precio aleatorio en un rango dado.
     * 
     * @param min Valor mínimo del precio.
     * @param max Valor máximo del precio.
     * @return Precio aleatorio con dos decimales.
     */
    public static double precio(double min, double max) {
        return (double) Math.floor(Math.random() * (max - min + 1)) + min;
    }

    /**
     * Genera un nombre aleatorio.
     * 
     * @return Nombre aleatorio.
     */
    public static String nombre() {
        return nombres[entero(0, nombres.length)];
    }

    /**
     * Genera un apellido aleatorio.
     * 
     * @return Apellido aleatorio.
     */
    public static String apellido() {
        return apellidos[entero(0, apellidos.length)];
    }

    /**
     * Genera un nombre completo aleatorio.
     * 
     * @return Nombre y apellido combinados.
     */
    public static String nombreCompleto() {
        return nombre() + apellido();
    }

    /**
     * Genera una edad aleatoria entre 18 y 60 años.
     * 
     * @return Edad aleatoria.
     */
    public static int edad() {
        return entero(18, 64);
    }

    /**
     * Genera una ciudad aleatoria.
     * 
     * @return Ciudad aleatoria.
     */
    public static String ciudad() {
        return ciudades[entero(0, ciudades.length)];
    }

    /**
     * Genera un número de teléfono aleatorio con formato "+34 XXX XXX XXX".
     * 
     * @return Número de teléfono aleatorio.
     */
    public static String telefono() {
        String line = "+34 ";
        int longitudNumeroTelefono = 9;
        for (int i = 0; i < longitudNumeroTelefono; i++) {
            if (i % 3 == 0) {
                line += " ";
            } else {
                line += entero(0, 9);
            }
        }
        return line;
    }

    /**
     * Genera un correo electrónico aleatorio basado en un nombre y apellido
     * aleatorio.
     * 
     * @return Correo electrónico aleatorio.
     */
    public static String correo() {
        return nombreCompleto() + "@gmail.com";
    }

    /**
     * Genera un texto Lorem Ipsum con una cantidad específica de palabras.
     * 
     * @param cantidad Cantidad de palabras a generar.
     * @return Texto Lorem Ipsum generado.
     */
    public static String lorem(int cantidad) {
        String line = "";
        for (int i = 0; i < cantidad; i++) {
            line += palabrasLorem[entero(0, palabrasLorem.length)] + " ";
        }
        return line;
    }

    /**
     * Genera un texto Lorem Ipsum corto (5-10 palabras).
     * 
     * @return Texto Lorem Ipsum corto.
     */
    public static String loremCorto() {
        int numeroPalabras = entero(5, 10);
        return lorem(numeroPalabras);
    }

    /**
     * Genera un texto Lorem Ipsum largo (20-50 palabras).
     * 
     * @return Texto Lorem Ipsum largo.
     */
    public static String loremLargo() {
        int numeroPalabras = entero(20, 50);
        return lorem(numeroPalabras);
    }

    /**
     * Genera un LocalDateTime aleatorio entre dos fechas
     * 
     * @param start Fecha de inicio
     * @param end   Fecha de fin
     * @return LocalDateTime
     */
    public static LocalDateTime getRandomDateTime(LocalDateTime start, LocalDateTime end) {
        long startEpoch = start.toEpochSecond(java.time.ZoneOffset.UTC);
        long endEpoch = end.toEpochSecond(java.time.ZoneOffset.UTC);

        long randomEpoch = ThreadLocalRandom.current().nextLong(startEpoch, endEpoch);

        return LocalDateTime.ofEpochSecond(randomEpoch, 0, java.time.ZoneOffset.UTC);
    }

    /**
     * Clase main para probar Faker
     * 
     */
    // public static void main(String[] args) {
    // System.out.println(Faker.apellido());
    // }

}
