package com.example.cis183_hw02_rgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;


    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context      = c;
        listOfColors = ls;
    }

    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.colorlist_cell, null);
        }

        TextView redvalue   = view.findViewById(R.id.tv_v_cc_redvalue);
        TextView redlabel   = view.findViewById(R.id.tv_v_cc_redlabel);
        TextView greenvalue = view.findViewById(R.id.tv_v_cc_greenvalue);
        TextView greenlabel = view.findViewById(R.id.tv_v_cc_greenlabel);
        TextView bluevalue  = view.findViewById(R.id.tv_v_cc_bluevalue);
        TextView bluelabel  = view.findViewById(R.id.tv_v_cc_bluelabel);
        TextView hexvalue   = view.findViewById(R.id.tv_v_cc_hexvalue);
        TextView hexlabel   = view.findViewById(R.id.tv_v_cc_hexlabel);

        ColorInfo color = listOfColors.get(i);

        redvalue.setText(color.getRedValue());
        greenvalue.setText(color.getGreenValue());
        bluevalue.setText(color.getBlueValue());
        hexvalue.setText(color.getHexValue());

        //sets the background color of the custom cell using the hex value
        view.setBackgroundColor(Color.parseColor("#" + hexvalue.getText().toString()));

        //sets color of text depending on if background is light or dark
        if(Integer.parseInt(redvalue.getText().toString()) < 80 || Integer.parseInt(greenvalue.getText().toString()) < 80)
        {
            redvalue.setTextColor(Color.WHITE);
            redlabel.setTextColor(Color.WHITE);
            greenvalue.setTextColor(Color.WHITE);
            greenlabel.setTextColor(Color.WHITE);
            bluevalue.setTextColor(Color.WHITE);
            bluelabel.setTextColor(Color.WHITE);
            hexvalue.setTextColor(Color.WHITE);
            hexlabel.setTextColor(Color.WHITE);
        }
        else
        {
            redvalue.setTextColor(Color.BLACK);
            redlabel.setTextColor(Color.BLACK);
            greenvalue.setTextColor(Color.BLACK);
            greenlabel.setTextColor(Color.BLACK);
            bluevalue.setTextColor(Color.BLACK);
            bluelabel.setTextColor(Color.BLACK);
            hexvalue.setTextColor(Color.BLACK);
            hexlabel.setTextColor(Color.BLACK);
        }

        return view;
    }
}
