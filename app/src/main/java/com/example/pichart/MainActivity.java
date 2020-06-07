// ShanmugamSS
// This project is taken from the youtube channel - KGP Talkie
// https://www.youtube.com/watch?v=MiVx3AQD_PI&list=PLc2rvfiptPSR7NliWRLwweX55XwrsrTOO

// Result : Worked Perfectly Fine
//
// Just take care of the Build build.gradle(Module:app) . Libraries need to be added. No other filesneed to be changed.
// Nothing is copied directly . Read the source and coded myself.

package com.example.pichart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart  = (PieChart)findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(true);
        pieChart.setExtraOffsets(5,10, 5,5);
        pieChart.setTransparentCircleRadius(61f);
        pieChart.animateY(2000);
        ArrayList<PieEntry> yValues = new ArrayList<>();

        // Add the Pie Chart Data Here

        yValues.add(new PieEntry(30,"India"));
        yValues.add(new PieEntry(20,"China"));
        yValues.add(new PieEntry(20,"USA"));
        yValues.add(new PieEntry(20,"Germany"));
        yValues.add(new PieEntry(10,"Austraila"));
        PieDataSet dataSet = new PieDataSet(yValues,"Countries");

        // Provides Chart Description

        Description descr = new Description();
        descr.setEnabled(true);
        descr.setTextAlign(Paint.Align.RIGHT);
        descr.setTextSize(20);
        descr.setText(" Pi Chart for Countries ");
        pieChart.setDescription(descr);

        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.YELLOW);
        pieChart.setData(data);
    }
}