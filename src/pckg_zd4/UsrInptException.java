package pckg_zd4;

public class UsrInptException extends Throwable {
    private int lower;
    private int upper;
    private int playerGuess;
    private String message;


    public UsrInptException(String message){
        super();
        this.message = message;
    }

    public void setUpper(int upper){
        this.upper = upper;
        System.out.println("Your upper border(value) is: " + upper);
    }

    public void setLower(int lower){
        this.lower = lower;
        System.out.println("Your lower border(value) is: " + lower);

    }
    public void setPlayerGuess(int playerGuess){
        this.playerGuess= playerGuess;
        System.out.println("Your guess is: " + playerGuess);

    }

}
