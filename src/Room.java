/**
 * Class of room.
 */
public class Room {

    private String code;

    private int capacity;

    /**
     * Constructor method.
     * @param newCode - String
     * @param newCapacity - Int
     */
    public Room( String newCode, int newCapacity){
        this.code = newCode;
        this.capacity = newCapacity;
    }

    public String getCode(){
        return  this.code;
    }

    public void setCode(String newCode){
        this.code = newCode;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Function that returns a string.
     * @return - String
     */
    public String toString(){
        return "| " + this.code + " | capacity: " + this.capacity + " |";
    }
}
