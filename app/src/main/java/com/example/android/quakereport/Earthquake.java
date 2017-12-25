package com.example.android.quakereport;

/**
 * Created by Administrador on 24/12/2017.
 */

public class Earthquake {
    private double magnitude;
    private String location;
    private long timeInMilliseconds;

    public Earthquake(double _magnitude, String _location, long _timeInMilliseconds) {
        magnitude = _magnitude;
        location = _location;
        timeInMilliseconds = _timeInMilliseconds;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMilliseconds() {
        return timeInMilliseconds;
    }
}
