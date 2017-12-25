package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrador on 24/12/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        TextView magnitudeTextView;
        TextView locationOffsetTextView;
        TextView primaryLocationTextView;
        TextView dateTextView;
        TextView timeTextView;

        String primaryLocation;
        String locationOffset;

        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        magnitudeTextView = (TextView) view.findViewById(R.id.magnitude);
        locationOffsetTextView = (TextView) view.findViewById(R.id.location_offset);
        primaryLocationTextView = (TextView) view.findViewById(R.id.primary_location);
        dateTextView = (TextView) view.findViewById(R.id.date);
        timeTextView = (TextView) view.findViewById(R.id.time);

        Earthquake currentEarthquake = getItem(position);

        String originalLocation = currentEarthquake.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0];
            primaryLocation = parts[1];
        }
        else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        magnitudeTextView.setText(currentEarthquake.getMagnitude());
        locationOffsetTextView.setText(locationOffset);
        primaryLocationTextView.setText(primaryLocation);
        dateTextView.setText(dateFormatter.format(new Date(currentEarthquake.getTimeInMilliseconds())));
        timeTextView.setText(timeFormatter.format(new Date(currentEarthquake.getTimeInMilliseconds())));

        return view;
    }
}
