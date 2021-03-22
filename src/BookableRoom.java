/**
 * Class of bookable room.
 */
public class BookableRoom {

    private String statusOfRoom;

    private int occupancy;

    private String date;

    private Room room;

    /**
     * Constructor method.
     * @param newDate - String
     * @param newRoom - Room variable
     */
    public BookableRoom(String newDate,Room newRoom){
        this.occupancy = 0;
        this.statusOfRoom = "EMPTY";
        this.room = newRoom;
        this.date = newDate;
    }

    public String getRoom(){
        return this.room.getCode();
    }

    public Room getTheRoom(){
        return  this.room;
    }

    public String getStatusOfRoom(){
        return this.statusOfRoom;
    }

    public void setStatusOfRoom(String newStatusOfRoom) {
        this.statusOfRoom = newStatusOfRoom;
    }

    public void setRoomCode(String newCode){
        this.room.setCode(newCode);
    }

    public int getOccupancy() {
        return occupancy;
    }

    public String getDate(){
        return this.date;
    }

    public void setOccupancy(int newOccupancy){
        this.occupancy = newOccupancy;
        modifyStatus();
    }

    /**
     * Function that modifies the status of a room.
     */
    public void modifyStatus(){
        if(this.occupancy == 0)
            this.statusOfRoom = "EMPTY";
        else if (this.occupancy < room.getCapacity())
            this.statusOfRoom = "AVAILABLE";
        else{
            this.statusOfRoom = "FULL";
        }
    }

    public String getCode(){
        return this.room.getCode();
    }

    /**
     * Function that returns a string.
     * @return - String
     */
    public String toString(){
        return "| " + this.date + " | " + this.statusOfRoom + " | " +
                this.room.getCode() + " | occupancy: " + this.occupancy + " |";
    }
}
