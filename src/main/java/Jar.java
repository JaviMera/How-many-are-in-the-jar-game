import java.util.Random;

/**
 * Created by Javier on 8/21/2016.
 */
public class Jar {

    private String mItemsName;
    private static final int mMinNumberOfItems = 1;
    private int mMaxNumberOfItems;
    private int mAmountOfItems;

    public Jar(String name, int max)
    {
        mItemsName = name;
        mMaxNumberOfItems = max;
    }

    public String getItemsName() {
        return mItemsName;
    }

    public int getMinNumberOfItems()
    {
        return mMinNumberOfItems;
    }

    public int getMaxNumberOfItems() {
        return mMaxNumberOfItems;
    }

    public int getNumberOfItems()
    {
        return mAmountOfItems;
    }

    public void fill()
    {
        Random random = new Random();
        mAmountOfItems = random.nextInt(mMaxNumberOfItems) + 1;
    }
}
