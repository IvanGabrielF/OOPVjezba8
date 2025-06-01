package pckg_zd4;

public class UserInpts {
    private static int upper;
    private static int lower;
    private int playerGuess;

    private static boolean status;


    public UserInpts(){int guess = playerGuess;}

    public static void setLwr(int lwr) {

    }

    public static void setUppr(int uppr) {

    }

    public void setPlayerGuess(int playerGuess) {
        this.playerGuess = playerGuess;
    }

    public static void setStatus(boolean status) {
        UserInpts.status = status;
    }

    public static int getLwr() {
        return lower;
    }

    public static int getUppr() {
        return upper;
    }

    public int getPlayerGuess() {
        return playerGuess;
    }

    public static boolean isStatus() {
        return status;
    }


}

