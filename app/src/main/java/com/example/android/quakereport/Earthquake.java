package com.example.android.quakereport;

/**
 * Created by Administrador on 24/12/2017.
 */

public class Earthquake {
    private String magnitude;
    private String location;
    private long timeInMilliseconds;

    public Earthquake(String _magnitude, String _location, long _timeInMilliseconds) {
        magnitude = _magnitude;
        location = _location;
        timeInMilliseconds = _timeInMilliseconds;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }
}
