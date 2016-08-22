import java.util.Random;

/**
 * Created by Javier on 8/21/2016.
 */
public class NumberGenerator {

    private Random mRandom;

    public NumberGenerator()
    {
        mRandom  = new Random();
    }

    public int generate(int max)
    {
        return mRandom.nextInt(max) + 1;
    }
}
