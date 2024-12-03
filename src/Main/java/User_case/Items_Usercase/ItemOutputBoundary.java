package User_case.Items_Usercase;

public class ItemOutputBoundary implements ItemOutputBoundaryInterface {
    public String message = " ";
    /**
     * Displays a general message to the user.
     * @param message The message to be displayed.
     */
    public void displayOutput(String message){

        System.out.println(message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
