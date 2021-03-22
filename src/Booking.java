import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Class of booking.
 */
public class Booking {

    private String status;

    private int identificationCode;

    private AssistantOnShift assistant;

    private BookableRoom room;

    private String studentEmail;

    private static int codeCount = 1;

    /**
     * Constructor method.
     * @param newAssistant - AssistantOnShift variable
     * @param newRoom - BookableRoom variable
     * @param newStudentEmail - String
     */
    public Booking(AssistantOnShift newAssistant, BookableRoom newRoom, String newStudentEmail){
        this.assistant = newAssistant;
        this.room = newRoom;
        this.studentEmail = newStudentEmail;
        this.identificationCode = codeCount;
        this.status = "SCHEDULED";
        codeCount++;
    }

    public AssistantOnShift getAssistant() {
        return assistant;
    }

    public BookableRoom getRoom() {
        return room;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdentificationCode() {
        return identificationCode;
    }

    /**
     * Function that modifies the status of a booking.
     */
    public void modifyStatus(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String d1 = formatter.format(date);

        // Compare the current date with the date of the booking.

        if(this.room.getDate().compareTo(d1) > 0) {
            this.status = "SCHEDULED";
        }
        else if(this.room.getDate().compareTo(d1) < 0){
            this.status = "COMPLETED";
        }
    }

    public String getStatus(){
        return this.status;
    }

    /**
     * Function that returns a string.
     * @return - String
     */
    public String toString(){
        return "| " + this.assistant.getDate() + " | " + this.status + " | " + assistant.getEmail() + " | "
                + room.getCode() + " | " + this.studentEmail + " |";
    }
}
