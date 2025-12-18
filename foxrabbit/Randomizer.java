import java.util.Random;

public class Randomizer {
    private static final Random generator = new Random();

    public static int generateInt(int upper) {
        return generator.nextInt(upper);
    }

    public static double generateDouble() {
        return generator.nextDouble();
    }
}