/**
 * Class of assistant.
 */
public class Assistant {

     private String email;

     private String name;

     /**
      * Constructor method.
      * @param newName - String
      * @param newEmail - String
      */
     public Assistant(String newName, String newEmail){
          this.email = newEmail;
          this.name = newName;
     }

     public String getEmail(){
          return this.email;
     }

     /**
      *  Function that returns a string.
      * @return - String
      */
     public String toString(){
          return "| " + this.name + " | " + this.email + " |";
     }

     public String getName(){
          return this.name;
     }
}

