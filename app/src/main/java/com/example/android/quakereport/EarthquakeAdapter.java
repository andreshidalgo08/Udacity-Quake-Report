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
    public EarthquakeAdapter(@NonNull Context context, @NonNull ArrayList<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        TextView magnitudeTextView;
        TextView locationTextView;
        TextView dateTextView;
        TextView timeTextView;

        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        magnitudeTextView = (TextView) view.findViewById(R.id.magnitude);
        locationTextView = (TextView) view.findViewById(R.id.location);
        dateTextView = (TextView) view.findViewById(R.id.date);
        timeTextView = (TextView) view.findViewById(R.id.time);

        Earthquake currentEarthquake = getItem(position);

        magnitudeTextView.setText(currentEarthquake.getMagnitude());
        locationTextView.setText(currentEarthquake.getLocation());
        dateTextView.setText(dateFormatter.format(new Date(currentEarthquake.getTimeInMilliseconds())));
        timeTextView.setText(timeFormatter.format(new Date(currentEarthquake.getTimeInMilliseconds())));

        return view;
    }
}
