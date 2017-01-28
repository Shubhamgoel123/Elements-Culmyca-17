package com.manan.appteam.elementsculmyca;

/**
 * Created by pc on 28-01-2017.
 */
import com.google.android.gms.maps.model.LatLng;

public interface ClusterItem {

    /**
     * The position of this marker. This must always return the same value.
     */
    LatLng getPosition();

    /**
     * The title of this marker.
     */
    String getTitle();

    /**
     * The description of this marker.
     */
    String getSnippet();
}

