package com.manan.appteam.elementsculmyca;

/**
 * Created by naman on 1/27/2017.
 */

public class EventObject {

    private String mEventName;
    private String mSubTitle;
    private String mLocation;
    private int mImageResourceId;

    public EventObject(String mEventName, String mSubTitle, String mLocation, int mImageResourceId) {
        this.mEventName = mEventName;
        this.mSubTitle = mSubTitle;
        this.mLocation = mLocation;
        this.mImageResourceId = mImageResourceId;
    }

    public String getEventName() {
        return mEventName;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
