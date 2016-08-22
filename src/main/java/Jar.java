/**
 * Created by Javier on 8/21/2016.
 */
public class Jar {

    private String mItemsName;
    private int mMaxNumberOfItems;
    private NumberGenerator mNumberGenerator;

    public Jar(String name, int max)
    {
        mItemsName = name;
        mMaxNumberOfItems = max;
        mNumberGenerator = new NumberGenerator();
    }

    public String getItemsName() {
        return mItemsName;
    }

    public int getMaxNumberOfItems() {
        return mMaxNumberOfItems;
    }

    public int getNumberOfItems()
    {
        return mNumberGenerator.getNumber();
    }

    public void generateItems()
    {
        mNumberGenerator.generate(getMaxNumberOfItems());
    }
}
