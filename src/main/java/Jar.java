/**
 * Created by Javier on 8/21/2016.
 */
public class Jar {

    private String mItemsName;
    private int mMaxNumberOfItems;

    public Jar(String name, int max)
    {
        mItemsName = name;
        mMaxNumberOfItems = max;
    }

    public String getItemsName() {
        return mItemsName;
    }

    public void setItemsName(String mItemsName) {
        mItemsName = mItemsName;
    }

    public int getMaxNumberOfItems() {
        return mMaxNumberOfItems;
    }

    public void setMaxNumberOfItems(int mMaxNumberOfItems) {
        mMaxNumberOfItems = mMaxNumberOfItems;
    }
}
