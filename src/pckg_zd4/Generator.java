package pckg_zd4;

import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private final int HIGH;
    private final int LOW;


    public Generator(int high, int low){
        HIGH=high;
        LOW = low;

    }
    public static int genAgeGuess(Generator generator) {
        int genAge = ThreadLocalRandom.current().nextInt(generator.getLOW(), generator.getHIGH());
        return genAge;
    }
    public int getLOW(){return LOW;}
    public int getHIGH(){return HIGH;}




}

