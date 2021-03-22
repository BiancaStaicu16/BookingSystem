import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Main class.
 */
public class BookingApp {

    private static final UniversityResources universityResources = new UniversityResources();

    private static final BookingSystem bookingSystem = new BookingSystem();

    public static void main(String args[]) throws ParseException {

        // Create a list of all rooms.

        Room room1 = new Room("IC215", 1);
        Room room2 = new Room("IC289", 3);
        Room room3 = new Room("IC210", 2);

        // Add rooms in list.

        universityResources.setRooms(new Room[]{room1, room2, room3});

        // Create a list of all assistants.

        Assistant assistant1 = new Assistant("Ana Smith", "anasmith12@uok.ac.uk");
        Assistant assistant2 = new Assistant("Brian Brown", "brownbr1@uok.ac.uk");
        Assistant assistant3 = new Assistant("Alicia Bacon", "aliciab14@uok.ac.uk");

        // Add assistants in list.

        universityResources.setAssistant(new Assistant[]{assistant1, assistant2, assistant3});

        // Create a list of bookable rooms.

        BookableRoom bookableRoom1 = new BookableRoom("01/05/2021 07:00", room1);
        BookableRoom bookableRoom2 = new BookableRoom("01/05/2021 07:00", room2);
        BookableRoom bookableRoom3 = new BookableRoom("01/05/2021 07:00", room3);
        BookableRoom bookableRoom4 = new BookableRoom("01/05/2021 08:00", room1);
        BookableRoom bookableRoom5 = new BookableRoom("01/05/2021 08:00", room2);
        BookableRoom bookableRoom6 = new BookableRoom("01/05/2021 08:00", room3);
        BookableRoom bookableRoom7 = new BookableRoom("01/05/2021 09:00", room1);
        BookableRoom bookableRoom8 = new BookableRoom("01/05/2021 09:00", room2);
        BookableRoom bookableRoom9 = new BookableRoom("01/05/2021 09:00", room3);

        // Add bookable rooms in list.

        bookingSystem.setBookableRooms(new BookableRoom[]{bookableRoom1, bookableRoom2, bookableRoom3, bookableRoom4,
                bookableRoom5, bookableRoom6, bookableRoom7, bookableRoom8, bookableRoom9});

        // Create a list of assistants on shift.

        AssistantOnShift assistantOnShift1 = new AssistantOnShift("01/05/2021 07:00", assistant1);
        AssistantOnShift assistantOnShift2 = new AssistantOnShift("01/05/2021 07:00", assistant2);
        AssistantOnShift assistantOnShift3 = new AssistantOnShift("01/05/2021 07:00", assistant3);
        AssistantOnShift assistantOnShift4 = new AssistantOnShift("01/05/2021 08:00", assistant1);
        AssistantOnShift assistantOnShift5 = new AssistantOnShift("01/05/2021 08:00", assistant2);
        AssistantOnShift assistantOnShift6 = new AssistantOnShift("01/05/2021 08:00", assistant3);
        AssistantOnShift assistantOnShift7 = new AssistantOnShift("01/05/2021 09:00", assistant1);
        AssistantOnShift assistantOnShift8 = new AssistantOnShift("01/05/2021 09:00", assistant2);
        AssistantOnShift assistantOnShift9 = new AssistantOnShift("22/02/2021 09:00", assistant3);

        // Add assistants on shift in list.

        bookingSystem.setAssistantOnShifts(new AssistantOnShift[]{assistantOnShift1, assistantOnShift2, assistantOnShift3,
                assistantOnShift4, assistantOnShift5, assistantOnShift6, assistantOnShift7,
                assistantOnShift8, assistantOnShift9});

        // Create bookings.

        bookingSystem.setBookings(createBookings());

        // Main menu.

        while (true) {
            System.out.println("""
                    University of Knowledge - COVID test
                    
                    Manage Bookings
                    
                    Please, enter the number to select your option:
                    """);

            System.out.println("""
                    To manage Bookable Rooms:
                    1. List
                    2. Add
                    3. Remove
                    To manage Assistants on Shift:
                    4. List
                    5. Add
                    6. Remove
                    To manage Bookings:
                    7. List
                    8. Add
                    9. Remove
                    10. Conclude
                    After selecting one the options above, you will be presented other screens.
                    If you press 0, you will be able to return to this main menu.
                    Press -1 (or ctrl+c) to quit this application.
                    """);

            // User input.

            Scanner optionsToChoose = new Scanner(System.in);
            int option = optionsToChoose.nextInt();

            if (option == 1) {

                // If a user selects 1, it will be listed all bookable rooms.

                clearScreen();
                System.out.println("University of Knowledge - COVID test\n");
                for (BookableRoom i : bookingSystem.getBookableRooms()) {
                    System.out.println(i.toString());
                }
                if (exitWithValues(optionsToChoose)) break;
            } else if (option == 2) {

                // If a user selects 2, they will see the list of rooms
                //(from the university) and will be able to create bookable rooms.

                clearScreen();
                while (true) {
                    System.out.println("""
                            University of Knowledge - COVID test
                            
                            Adding bookable room
                            """);
                    for (Room i : universityResources.getRooms())
                        System.out.println(i.toString());
                    System.out.println("""
                            Please, enter one of the following:
                            
                            The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),
                            separated by a white space.0. Back to main menu.
                            -1. Quit application.""");

                    Scanner input1 = new Scanner(System.in);
                    String input = input1.nextLine();
                    if (input.equals("0")) {
                        option = 0;
                        break;
                    } else if (input.equals("-1")) {
                        option = -1;
                        break;
                    }

                    String arr[] = input.split(" ", 2);
                    String firstWord = arr[0];
                    String theRest = arr[1];

                    // Check if entries are valid.

                    Date date = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    String d1 = formatter.format(date);
                    Room room = obtainRoom(firstWord);
                    if (room != null) {
                        if (theRest.compareTo(d1) > 0) {
                            boolean verify = true; // it does not exist
                            for (BookableRoom i : bookingSystem.getBookableRooms()) {
                                if ((i.getDate().equals(theRest)) && (i.getCode().equals(firstWord))) {
                                    System.out.println(i.toString());
                                    verify = false;
                                    break;
                                }
                            }
                            if (verify) {
                                BookableRoom bookableRoom = new BookableRoom(theRest, room);
                                System.out.println("Bookable Room added successfully:\n" + bookableRoom.toString() +
                                                   "Please, enter one of the following:\n" + "The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),\n"
                                                   + "separated by a white space.");
                            }
                        }
                    } else {
                        System.out.println("""
                                Error!
                                The room entered does not exist
                                Please, enter one of the following:
                                
                                The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),
                                separated by a white space.
                                """);
                        if (exitWithValues(optionsToChoose)) {
                            option = -1;
                        }
                        break;
                    }
                }
            } else if (option == 3) {

                //  If a user selects 3 from, list bookable rooms and they will be able to remove.

                clearScreen();
                System.out.println("University of Knowledge - COVID test\n");
                for (BookableRoom i : bookingSystem.getBookableRooms()) {
                    if (i.getStatusOfRoom().equals("EMPTY"))
                        System.out.println(i.toString());
                }
                System.out.println("""
                        Removing bookable room
                        
                        Please, enter one of the following:
                        
                        The sequential ID to select the bookable room to be removed.
                        0. Back to main menu.
                        -1. Quit application.""");
                while (true) {
                    Scanner input2 = new Scanner(System.in);
                    String input3 = input2.nextLine();
                    if (input3.equals("0")) {
                        option = 0;
                        break;
                    } else if (input3.equals("-1")) {
                        option = -1;
                        break;
                    }
                    boolean isValid = false;
                    for (BookableRoom j : bookingSystem.getBookableRooms()) {
                        if (j.getCode().equals(input3))
                            isValid = true;
                    }
                    if (isValid) {
                        for (BookableRoom i : bookingSystem.getBookableRooms()) {
                            if (i.getStatusOfRoom().equals("EMPTY") && i.getCode().equals(input3)) {
                                String printBookableRoom = i.toString();
                                bookingSystem.removeBookableRoom(i);
                                System.out.println("Bookable Room removed successfully:");
                                System.out.println(printBookableRoom);
                            }
                        }
                        System.out.println("""
                                Please, enter one of the following:
                                
                                The sequential ID to select the bookable room to be removed
                                0. Back to main menu.
                                -1. Quit application.""");
                    } else {
                        System.out.println("""
                                Error!
                                The Bookable Room entered does not exist
                                Please, enter one of the following:
                                
                                The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),
                                separated by a white space.
                                """);
                        if (exitWithValues(optionsToChoose)) {
                            option = -1;
                        }
                        break;
                    }
                }
            } else if (option == 4) {

                // If a user selects 4, they will be able to see a list of all assistants on shift.

                clearScreen();
                System.out.println("University of Knowledge - COVID test\n");
                for (AssistantOnShift i : bookingSystem.getAssistantOnShifts()) {
                    System.out.println(i.toString());
                }
                if (exitWithValues(optionsToChoose)) break;
            } else if (option == 5) {

                // If a user selects 5, they will see the list of
                //assistants (from the university) and will be able to create assistants on shift.

                clearScreen();
                System.out.println("""
                        University of Knowledge - COVID test
                        
                        Adding assistant on shift
                        """);
                for (AssistantOnShift i : bookingSystem.getAssistantOnShifts()) {
                    System.out.println(i.toString());
                }
                System.out.println("""
                        Please, enter one of the following:
                        
                        The sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.
                        """);
                System.out.println("""
                        0. Back to main menu.
                        -1. Quit application.
                        """);
                while (true) {
                    Scanner input2 = new Scanner(System.in);
                    String input3 = input2.nextLine();
                    if (input3.equals("0")) {
                        option = 0;
                        break;
                    } else if (input3.equals("-1")) {
                        option = -1;
                        break;
                    }
                    String arr[] = input3.split(" ", 2);
                    String firstWord = arr[0];
                    String theRest = arr[1];
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = new Date();
                    String d1 = formatter.format(date);
                    boolean isValid = false;
                    for (Assistant i : universityResources.getAssistant()) {
                        if (i.getEmail().equals(firstWord)) {
                            isValid = true;
                            break;
                        }
                    }
                    Assistant assistant = obtainAssistant(firstWord);
                    if (isValid) {
                        if (!(assistant.getEmail().equals(firstWord) && theRest.compareTo(d1) > 0)) {
                            AssistantOnShift assistantOnShiftA = new AssistantOnShift(theRest, assistant);
                            AssistantOnShift assistantOnShiftB = new AssistantOnShift(theRest, assistant);
                            AssistantOnShift assistantOnShiftC = new AssistantOnShift(theRest, assistant);
                            bookingSystem.addAssistantOnShift(assistantOnShiftA);
                            bookingSystem.addAssistantOnShift(assistantOnShiftB);
                            bookingSystem.addAssistantOnShift(assistantOnShiftC);
                            System.out.println("Assistant on Shift added successfully:");
                            System.out.println(assistantOnShiftA.toString());
                        }
                        System.out.println("""
                                Please, enter one of the following:
                                
                                The sequential ID to select the bookable room to be removed
                                0. Back to main menu.
                                -1. Quit application.""");
                    } else {
                        System.out.println("""
                                Error!
                                The Assistant entered does not exist
                                Please, enter one of the following:
                                
                                The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),
                                separated by a white space.
                                """);
                        if (exitWithValues(optionsToChoose)) {
                            option = -1;
                        }
                        break;
                    }
                }
            } else if (option == 6) {

                // If a user selects 6, they will see a list of assistants and they will be able to remove.

                clearScreen();
                System.out.println("""
                        University of Knowledge - COVID test
                        
                        Removing assistant on shift
                        Please, enter one of the following:
                        
                        """);
                for (Assistant i : universityResources.getAssistant()) {
                    System.out.println(i.toString());
                }
                System.out.println("The sequential ID to select the assistant on shift to be removed.\n");
                System.out.println("""
                        0. Back to main menu.
                        -1. Quit application.
                        """);
                while (true) {
                    Scanner input2 = new Scanner(System.in);
                    String input3 = input2.nextLine();
                    if (input3.equals("0")) {
                        option = 0;
                        break;
                    } else if (input3.equals("-1")) {
                        option = -1;
                        break;
                    }
                    boolean isValid = false;
                    for (Assistant i : universityResources.getAssistant()) {
                        if (i.getEmail().equals(input3)) {
                            isValid = true;
                            break;
                        }
                    }
                    if (isValid) {
                        for (AssistantOnShift i : bookingSystem.getAssistantOnShifts()) {
                            if (i.getEmail().equals(input3)) {
                                bookingSystem.removeAssistantOnShift(i);
                                System.out.println("Assistant on Shift removed successfully:\n" +
                                        i.toString() + "\n" +
                                        "Please, enter one of the following:\n" +

                                        "The sequential ID to select the assistant on shift to be removed.\n" +
                                        "0. Back to main menu.\n" +
                                        "-1. Quit application.\n");
                            }
                        }
                    } else {
                        System.out.println("""
                                Error!
                                The Assistant entered does not exist
                                Please, enter one of the following:
                                
                                The sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM),
                                separated by a white space.
                                """);
                        if (exitWithValues(optionsToChoose)) {
                            option = -1;
                        }
                        break;
                    }
                }
            } else if (option == 7) {

                // If a user selects 7, they will be able to see a list of bookings.

                clearScreen();
                System.out.println("University of Knowledge - COVID test\n");
                System.out.println("""
                        Select which booking to list:
                        1. All
                        2. Only bookings status:SCHEDULED
                        3. Only bookings status:COMPLETED
                        0. Back to main menu.
                        -1. Quit application.
                        """);
                Scanner input1 = new Scanner(System.in);
                int input = input1.nextInt();
                if (input == 2) {
                    for (Booking i : bookingSystem.getBookings()) {
                        if (i.getStatus().equals("SCHEDULED"))
                            System.out.println(i.toString());
                    }
                } else if (input == 3) {
                    for (Booking i : bookingSystem.getBookings()) {
                        if (i.getStatus().equals("COMPLETED"))
                            System.out.println(i.toString());
                    }
                } else if (input == 0) {
                    break;
                } else if (input == -1) {
                    break;
                } else {
                    for (Booking i : bookingSystem.getBookings()) {
                        System.out.println(i.toString());
                    }
                }
                exitWithValues(optionsToChoose);
            } else if (option == 8) {

                // If a user selects 8, the system will list the available timeslots, i.e.,
                // date and time in which there is a bookable room EMPTY or AVAILABLE, and an assistant on shift FREE,
                //in a chronological order

                clearScreen();
                while (true) {
                    System.out.println("""
                            University of Knowledge - COVID test
                            
                            Adding booking (appointment for a COVID test) to the system
                            
                            List of available time-slots:""");
                    ArrayList<String> availableTimes = new ArrayList<>();
                    for (BookableRoom i : bookingSystem.getBookableRooms()) {
                        for (AssistantOnShift j : bookingSystem.getAssistantOnShifts()) {
                            if (i.getDate().equals(j.getDate()) && j.getStatus().equals("FREE")
                                    && (i.getStatusOfRoom().equals("EMPTY")
                                    || i.getStatusOfRoom().equals("AVAILABLE"))) {
                                if (!availableTimes.contains(i.getDate())) {
                                    availableTimes.add(i.getDate());
                                    System.out.println(i.getDate());
                                }
                            }
                        }
                    }
                    System.out.println("""
                            Please, enter one of the following:
                            
                            The student email and the time-slot, separated by a white space.
                            """);
                    System.out.println("""
                            0. Back to main menu.
                            -1. Quit application.
                            """);
                    Scanner input1 = new Scanner(System.in);
                    String input = input1.nextLine();
                    if (input.equals("0")) {
                        option = 0;
                        break;
                    } else if (input.equals("-1")) {
                        option = -1;
                        break;
                    }
                    String arr[] = input.split(" ", 2);
                    String firstWord = arr[0];
                    String theRest = arr[1];
                    if (availableTimes.contains(theRest) && firstWord.contains("@uok.ac.uk")) {
                        boolean toBreak = false;
                        for (BookableRoom i : bookingSystem.getBookableRooms()) {
                            for (AssistantOnShift j : bookingSystem.getAssistantOnShifts()) {
                                if (i.getDate().equals(j.getDate()) && j.getStatus().equals("FREE")
                                        && (i.getStatusOfRoom().equals("EMPTY")
                                        || i.getStatusOfRoom().equals("AVAILABLE"))) {
                                    Booking newBooking = new Booking(j, i, firstWord);
                                    System.out.println("Booking added successfully:\n" +
                                            newBooking.toString() + "\n");
                                    toBreak = true;
                                    break;
                                }
                            }
                            if (toBreak) break;
                        }
                    } else {
                        System.out.println("""
                                Error!
                                Invalid input.
                                """);
                    }
                }

            } else if (option == 9) {

                // If a user selects 9, they will be able to see a list of scheduled bookings and to remove.

                clearScreen();
                System.out.println("University of Knowledge - COVID test");
                for (Booking i : bookingSystem.getBookings()) {
                    if (i.getStatus().equals("SCHEDULED"))
                        System.out.println(i.toString());
                }
                System.out.println("""
                        Removing booking from the system
                        
                        Please, enter one of the following:
                        
                        The sequential ID to select the booking to be removed from the listed bookings above.
                        0. Back to main menu.
                        -1. Quit application.
                        """);
                while (true) {
                    Scanner input2 = new Scanner(System.in);
                    int input3 = input2.nextInt();
                    if (input3 == 0) {
                        break;
                    } else if (input3 == -1) {
                        option = -1;
                        break;
                    }
                    boolean isValid = false;
                    for (Booking i : bookingSystem.getBookings()) {
                        if (i.getIdentificationCode() == input3) {
                            isValid = true;
                            break;
                        }
                    }
                    if (isValid) {
                        for (Booking i : bookingSystem.getBookings()) {
                            if (i.getIdentificationCode() == input3) {
                                bookingSystem.removeBooking(i);
                                System.out.println("Booking removed successfully:\n" +
                                        i.toString() +
                                        "Please, enter one of the following:\n" + "The sequential ID to select the booking to be removed from the listed bookings above.\n" +

                                        "0. Back to main menu.\n" +
                                        "-1. Quit application.");
                            }
                        }
                    } else {
                        System.out.println("""
                                Error!
                                The booking entered does not exist
                                Please, enter one of the following:
                                
                                The sequential ID listed to select the booking to be removed from the listed bookings above.\s""");
                        if (exitWithValues(optionsToChoose)) {
                            option = -1;
                        }
                        break;
                    }
                }


            } else if (option == 10) {

                // If a user selects 10, they can conclude (finish) a
                //booking. That is, the testing was performed as planned and the record can no longer be deleted from the system.

                clearScreen();
                System.out.println("University of Knowledge - COVID test");
                for (Booking i : bookingSystem.getBookings()) {
                    if (i.getStatus().equals("SCHEDULED"))
                        System.out.println(i.toString());
                }
                System.out.println("""
                        Conclude booking
                        
                        Please, enter one of the following:
                        
                        The sequential ID to select the booking to be completed.
                        0. Back to main menu.
                        -1. Quit application.""");

                while (true) {
                    Scanner input2 = new Scanner(System.in);
                    int input3 = input2.nextInt();
                    if (input3 == 0) {
                        break;
                    } else if (input3 == -1) {
                        option = -1;
                        break;
                    }
                    boolean isValid = false;
                    for (Booking i : bookingSystem.getBookings()) {
                        if (i.getIdentificationCode() == input3) {
                            isValid = true;
                            break;
                        }
                    }
                    if (isValid) {
                        for (Booking i : bookingSystem.getBookings()) {
                            if (i.getIdentificationCode() == input3) {
                                i.setStatus("COMPLETED");
                                System.out.println("Booking completed successfully:\n" +
                                        i.toString() +
                                        "Please, enter one of the following:\n" + "The sequential ID to select the booking to be removed from the listed bookings above.\n" +

                                        "0. Back to main menu.\n" +
                                        "-1. Quit application.");
                            }
                        }
                    } else {
                        System.out.println("""
                                Error!
                                The booking entered does not exist
                                Please, enter one of the following:
                                
                                The sequential ID listed to select the booking to be removed from the listed bookings above.\s""");
                        if (exitWithValues(optionsToChoose)) {
                            option = -1;
                        }
                        break;
                    }
                }
            }


        if (option == 0) {
            clearScreen();
        } else if (option == -1) {
            break;
        }
      }
    }

    // Function that obtains the room based on its code.

    /**
     * Function that returns a specific room.
     * @param code - String
     * @return - Room variable
     */
    private static Room obtainRoom(String code) {
            for(Room i: universityResources.getRooms()){
                if(i.getCode().equals(code))
                    return i;
            }
            return null;
    }

    // Function that manages the user's inputs.

    /**
     * Function that returns a boolean.
     * @param optionsToChoose - Scanner variable
     * @return - Boolean
     */
    private static boolean exitWithValues(Scanner optionsToChoose) {
        int option;
        boolean to_continue = false;
        while(true) {
            System.out.println("""
                    0. Back to main menu.
                    -1. Quit application.
                    """);
            option = optionsToChoose.nextInt();
            if (option == 0) {
                clearScreen();
                to_continue = true;
                break;
            } else if (option == -1) {
                break;
            } else {
                System.out.println("Option does not exist.");
            }
        }
        return !to_continue;
    }

    /**
     * Function that clears the console.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Create bookings function.

    /**
     * Function that creates bookings.
     * @return - Array of bookings
     */
    public static Booking[] createBookings(){
        String[] studentsForTest = {"jason23@uok.ac.uk", "barny23@uok.ac.uk", "mason23@uok.ac.uk",
                                 "sonyx23@uok.ac.uk"};
        ArrayList<Booking> tempBooking = new ArrayList<>();
        Booking[] bookings;

        for (String s : studentsForTest) {
            boolean isFree = true;
            for (AssistantOnShift i : bookingSystem.getAssistantOnShifts()) {
                if (i.getStatus().equals("FREE") && isFree) {
                    for (BookableRoom j : bookingSystem.getBookableRooms()) {
                        if ((j.getStatusOfRoom().equals("EMPTY") || j.getStatusOfRoom().equals("AVAILABLE"))
                                && i.getDate().equals(j.getDate())) {
                            Booking booking = new Booking(i, j, s);
                            tempBooking.add(booking);
                            j.setOccupancy(j.getOccupancy() + 1);
                            i.setStatus("BUSY");
                            isFree = false;
                            break;
                        }
                    }
                }
            }
        }
        bookings = tempBooking.toArray(new Booking[0]);
        return  bookings;
    }

    // Function that identifies a certain assistant.

    /**
     * Function that returns the assistant based on the email.
     * @param email - String
     * @return - Assistant variable
     */
    public static Assistant obtainAssistant(String email) {
        for (Assistant i : universityResources.getAssistant()) {
            if (i.getEmail().equals(email))
                return i;
        }
        return null;
    }
}
