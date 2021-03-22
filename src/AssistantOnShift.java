/**
 * Class of assistant on shift.
 */
public class AssistantOnShift {

    private String status;

    private String date;

    private Assistant assistant;

    /**
     * Constructor method.
     * @param newDate - String
     * @param newAssistant - Assistant variable
     */
    public AssistantOnShift(String newDate, Assistant newAssistant){
        this.date = newDate;
        this.assistant = newAssistant;
        this.status = "FREE";
    }

    public String getStatus(){
        return this.status;
    }

    public String getName(){
        return this.assistant.getName();
    }

    public String getEmail(){
        return assistant.getEmail();
    }

    public String getDate(){
        return this.date;
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
    }

    public String toString(){
        return "| " + this.date + " | " + this.status + " | " + assistant.getEmail() + " |";
    }
}


