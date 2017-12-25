package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
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
        DecimalFormat decimalFormatter = new DecimalFormat("0.0");

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        magnitudeTextView = (TextView) view.findViewById(R.id.magnitude);
        locationOffsetTextView = (TextView) view.findViewById(R.id.location_offset);
        primaryLocationTextView = (TextView) view.findViewById(R.id.primary_location);
        dateTextView = (TextView) view.findViewById(R.id.date);
        timeTextView = (TextView) view.findViewById(R.id.time);

        Earthquake currentEarthquake = getItem(position);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

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

        magnitudeTextView.setText(decimalFormatter.format(currentEarthquake.getMagnitude()));
        locationOffsetTextView.setText(locationOffset);
        primaryLocationTextView.setText(primaryLocation);
        dateTextView.setText(dateFormatter.format(new Date(currentEarthquake.getTimeInMilliseconds())));
        timeTextView.setText(timeFormatter.format(new Date(currentEarthquake.getTimeInMilliseconds())));

        return view;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
