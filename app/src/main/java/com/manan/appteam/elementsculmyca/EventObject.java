package com.manan.appteam.elementsculmyca;

/**
 * Created by naman on 1/27/2017.
 */

public class EventObject {

    private String mEventId;
    private String mEventDetail;
    private String mEventDate;
    private String mEventTimeStart;
    private String mEventTimeEnd;
    private String mEventCo;
    private String mEventName;
    private String mLocation;
    private int mImageResourceId;
    private String mEventCoNumber;

    public EventObject(String mEventId,
                       String mEventName,
                       String mEventDetail,
                       String mEventDate,
                       String mEventTimeStart,
                       String mEventTimeEnd,
                       String mEventCo,
                       String mLocation,
                       int mImageResourceId,
                       String mEventCoNumber) {
        this.mEventId = mEventId;
        this.mEventDetail = mEventDetail;
        this.mEventDate = mEventDate;
        this.mEventTimeStart = mEventTimeStart;
        this.mEventTimeEnd = mEventTimeEnd;
        this.mEventCo = mEventCo;
        this.mEventName = mEventName;
        this.mLocation = mLocation;
        this.mImageResourceId = mImageResourceId;
        this.mEventCoNumber = mEventCoNumber;
    }

    public String getEventName() {
        return mEventName;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getEventId() {
        return mEventId;
    }

    public String getEventDetail() {
        return mEventDetail;
    }

    public String getEventDate() {
        return mEventDate;
    }

    public String getEventTimeStart() {
        return mEventTimeStart;
    }

    public String getEventTimeEnd() {
        return mEventTimeEnd;
    }

    public String getEventCo() {
        return mEventCo;
    }

    public String getEventCoNumber() {
        return mEventCoNumber;
    }

}
