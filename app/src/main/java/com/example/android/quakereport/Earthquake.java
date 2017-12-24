package com.example.android.quakereport;

/**
 * Created by Administrador on 24/12/2017.
 */

public class Earthquake {
    private String magnitude;
    private String location;
    private String date;

    public Earthquake(String _magnitude, String _location, String _date) {
        magnitude = _magnitude;
        location = _location;
        date = _date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
