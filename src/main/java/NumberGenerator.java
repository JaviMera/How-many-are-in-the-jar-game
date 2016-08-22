import java.util.Random;

/**
 * Created by Javier on 8/21/2016.
 */
public class NumberGenerator {

    private Random mRandom;
    private int mNumber;

    public NumberGenerator()
    {
        mRandom  = new Random();
    }

    public void generate(int max)
    {
        mNumber = mRandom.nextInt(max) + 1;
    }

    public int getNumber() {
        return mNumber;
    }
}
