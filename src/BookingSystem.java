import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class of booking system.
 */
public class BookingSystem {

    private AssistantOnShift[] assistantOnShifts;

    private BookableRoom[] bookableRooms;

    private Booking[] bookings;

    public AssistantOnShift[] getAssistantOnShifts() {
        return assistantOnShifts;
    }

    public Booking[] getBookings() {
        return bookings;
    }

    public BookableRoom[] getBookableRooms() {
        return bookableRooms;
    }

    public void setAssistantOnShifts(AssistantOnShift[] assistantOnShifts) {
        this.assistantOnShifts = assistantOnShifts;
    }

    public void setBookableRooms(BookableRoom[] bookableRooms) {
        this.bookableRooms = bookableRooms;
    }

    public void setBookings(Booking[] bookings) {
        this.bookings = bookings;
    }

    // Functions to add and remove assistants on shift.

    /**
     * Function to add an assistant on shift.
     * @param assistant - AssistantOnShift variable
     */
    public void addAssistantOnShift(AssistantOnShift assistant){

            // Convert array to arraylist.

            ArrayList<AssistantOnShift> tempAssistantOnShift = new ArrayList<>(Arrays.asList(assistantOnShifts));

            // Add element in arraylist.

            tempAssistantOnShift.add(assistant);

            // Convert arraylist back to array.

            assistantOnShifts = tempAssistantOnShift.toArray(new AssistantOnShift[0]);
    }

    /**
     * Function to remove an assistant on shift.
     * @param assistant - AssistantOnShift variable
     */
    public void removeAssistantOnShift(AssistantOnShift assistant){
        for(AssistantOnShift i: assistantOnShifts) {
            if(i == assistant) {

                // Convert array to arraylist.

                ArrayList<AssistantOnShift> tempAssistantOnShift = new ArrayList<>(Arrays.asList(assistantOnShifts));

                //Remove element.

                tempAssistantOnShift.remove(assistant);

                // Convert arraylist back to array.

                assistantOnShifts = tempAssistantOnShift.toArray(new AssistantOnShift[0]);
            }
        }
    }

    // Function to remove BookableRooms.

    /**
     * Function that removes a Bookable room.
     * @param bookableRoom - BookableRoom variable
     */
    public void removeBookableRoom(BookableRoom bookableRoom){
        for(BookableRoom i: bookableRooms) {
            if(i == bookableRoom) {

                // Convert array to arraylist.

                ArrayList<BookableRoom> tempBookableRoom = new ArrayList<>(Arrays.asList(bookableRooms));

                // Remove element from arraylist.

                tempBookableRoom.remove(bookableRoom);

                // Convert arraylist back to array.

                bookableRooms = tempBookableRoom.toArray(new BookableRoom[0]);
            }
        }
    }

    // Functions to remove bookings.

    /**
     * Function that removes a booking.
     * @param booking - Booking variable
     */
    public void removeBooking(Booking booking){
        for(Booking i: bookings) {
            if(i == booking) {

                // Convert array to arraylist.

                ArrayList<Booking> tempBooking = new ArrayList<>(Arrays.asList(bookings));

                // Remove element from arraylist.

                tempBooking.remove(booking);

                // Convert arraylist back to array.

                bookings = tempBooking.toArray(new Booking[0]);
            }
        }
    }
}
