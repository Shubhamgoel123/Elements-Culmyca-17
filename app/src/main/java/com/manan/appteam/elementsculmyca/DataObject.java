package com.manan.appteam.elementsculmyca;

/**
 * Created by naman on 1/26/2017.
 */

public class DataObject {
    private String mCategoryName;
    private int mImageResourceId;

    DataObject(String categoryName, int imageResourceId) {
        mCategoryName = categoryName;
        mImageResourceId = imageResourceId;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }


}
