/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        /*ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake("1.1", "San Francisco", "Jan 1, 2018"));
        earthquakes.add(new Earthquake("2.2", "London", "Jan 2, 2018"));
        earthquakes.add(new Earthquake("3.3", "Tokyo", "Jan 3, 2018"));
        earthquakes.add(new Earthquake("4.4", "Mexico City", "Jan 4, 2018"));
        earthquakes.add(new Earthquake("5.5", "Moscow", "Jan 5, 2018"));
        earthquakes.add(new Earthquake("6.6", "Rio de Janeiro", "Jan 6, 2018"));
        earthquakes.add(new Earthquake("7.7", "Paris", "Jan 7, 2018"));*/

        final ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthquakeAdapter adapter = new EarthquakeAdapter(
                this,earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri earthquakeUri = Uri.parse(adapter.getItem(position).getUrl());

                Intent intent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(intent);
            }
        });
    }
}
