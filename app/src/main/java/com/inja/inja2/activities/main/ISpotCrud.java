package com.inja.inja2.activities.main;

import android.location.Location;

import com.inja.inja2.model.InjaSpot;

/**
 * Created by sinasix on 6/27/16.
 */
public interface ISpotCrud {
    void addInjaSpot(InjaSpot spot);

    void getSpots(Location location);

    void voteUp(InjaSpot spot);
}
