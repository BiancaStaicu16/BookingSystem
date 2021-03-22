/**
 * Class of university resources.
 */
public class UniversityResources {

    private Assistant[]  assistant;

    private Room[] rooms;

    public void setAssistant(Assistant[] newAssistant) {
        this.assistant = newAssistant;
    }

    public void setRooms(Room[] newRooms){
        this.rooms = newRooms;
    }

    public  Assistant[] getAssistant() {
        return assistant;
    }

    public  Room[] getRooms() {
        return rooms;
    }
}
