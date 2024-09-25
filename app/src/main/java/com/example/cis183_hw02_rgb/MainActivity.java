package com.example.cis183_hw02_rgb;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String red;
    String green;
    String blue;
    String hex;

    View rl_j_main;

    TextView tv_j_redlabel;
    TextView tv_j_greenlabel;
    TextView tv_j_bluelabel;
    TextView tv_j_hexlabel;
    TextView tv_j_redvalue;
    TextView tv_j_greenvalue;
    TextView tv_j_bluevalue;
    TextView tv_j_hexvalue;

    Button btn_j_savecolor;

    SeekBar sb_j_redvalue;
    SeekBar sb_j_greenvalue;
    SeekBar sb_j_bluevalue;

    ListView lv_j_listofcolors;

    ColorListAdapter adapter;

    ArrayList<ColorInfo> listofcolors = new ArrayList<ColorInfo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rl_j_main         = findViewById(R.id.main);
        tv_j_redvalue     = findViewById(R.id.tv_v_redvalue);
        tv_j_greenvalue   = findViewById(R.id.tv_v_greenvalue);
        tv_j_bluevalue    = findViewById(R.id.tv_v_bluevalue);
        tv_j_hexvalue     = findViewById(R.id.tv_v_hexvalue);
        tv_j_redlabel     = findViewById(R.id.tv_v_redlabel);
        tv_j_greenlabel   = findViewById(R.id.tv_v_greenlabel);
        tv_j_bluelabel    = findViewById(R.id.tv_v_bluelabel);
        tv_j_hexlabel     = findViewById(R.id.tv_v_Hexlabel);
        sb_j_redvalue     = findViewById(R.id.sb_v_redvalue);
        sb_j_greenvalue   = findViewById(R.id.sb_v_greenvalue);
        sb_j_bluevalue    = findViewById(R.id.sb_v_bluevalue);
        btn_j_savecolor   = findViewById(R.id.btn_v_savecolor);
        lv_j_listofcolors = findViewById(R.id.lv_v_listofcolors);

        initializeSeekBars();
        redValueSeekBarListener();
        greenValueSeekBarListener();
        blueValueSeekbarListener();
        addColorButtonListener();
        listViewClickerListener();
        getHexValue();

    }

    private void redValueSeekBarListener()
    {
        //handles changing text and storing hex code for color
        sb_j_redvalue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //takes the integer value of i and turns it into a string
                //to display in redvalue text view
                tv_j_redvalue.setText(String.valueOf(i));
                changeTextColor(i);

                //adds leading zero to hex number when it gets to single digit hex number
                if(i < 16)
                {
                    red = "0" + Integer.toHexString(i);
                }
                else
                {
                    red = Integer.toHexString(i);
                }

                getHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    //same functions as redSeekBarListener
    private void greenValueSeekBarListener()
    {

        sb_j_greenvalue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_greenvalue.setText(String.valueOf(i));
                changeTextColor(i);

                if(i < 16)
                {
                    green = "0" + Integer.toHexString(i);
                }
                else
                {
                    green = Integer.toHexString(i);
                }

                getHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });

    }

    //same functions as RedSeekBarListener
    private void blueValueSeekbarListener()
    {
        sb_j_bluevalue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_bluevalue.setText(String.valueOf(i));

                if(i < 16)
                {
                    blue = "0" + Integer.toHexString(i);
                }
                else
                {
                    blue = Integer.toHexString(i);
                }

                getHexValue();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    //add color to array list when pushing button
    private void addColorButtonListener()
    {
        btn_j_savecolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //create new object to hold ColorInfo
                ColorInfo colorToAdd = new ColorInfo();

                //fill in the values for the new object
                colorToAdd.setRedValue(String.valueOf(sb_j_redvalue.getProgress()));
                colorToAdd.setGreenValue(String.valueOf(sb_j_greenvalue.getProgress()));
                colorToAdd.setBlueValue(String.valueOf(sb_j_bluevalue.getProgress()));
                colorToAdd.setHexValue(hex);

                //add object to ArrayList
                listofcolors.add(colorToAdd);
                fillListView();

                resetColor();


            }
        });
    }

    //when clicking on items in list view
    private void listViewClickerListener()
    {
        lv_j_listofcolors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //sets all SeekBars to values stored in the ArrayList at the position that was clicked
                //on in the list view
                //uses function in Integer class to change string to int
                sb_j_redvalue.setProgress(Integer.parseInt(listofcolors.get(i).getRedValue()));
                sb_j_greenvalue.setProgress(Integer.parseInt(listofcolors.get(i).getGreenValue()));
                sb_j_bluevalue.setProgress((Integer.parseInt(listofcolors.get(i).getBlueValue())));

            }
        });

    }

    //initializes all seek bars to the default value
    private void initializeSeekBars()
    {

        //sets all seek bar max value to 255
        //sets the default color to white and updates the value text views
        sb_j_redvalue.setMax(255);
        sb_j_redvalue.setProgress(255);
        tv_j_redvalue.setText(String.valueOf(sb_j_redvalue.getProgress()));

        //sets a string to the hex value of the SeekBar
        red = Integer.toHexString(sb_j_redvalue.getProgress());

        sb_j_greenvalue.setMax(255);
        sb_j_greenvalue.setProgress(255);
        tv_j_greenvalue.setText(String.valueOf(sb_j_greenvalue.getProgress()));

        green = Integer.toHexString(sb_j_greenvalue.getProgress());

        sb_j_bluevalue.setMax(255);
        sb_j_bluevalue.setProgress(255);
        tv_j_bluevalue.setText(String.valueOf(sb_j_bluevalue.getProgress()));

        blue = Integer.toHexString(sb_j_bluevalue.getProgress());
    }

    private void getHexValue()
    {

        //creates a string with the hex value of all the colors put together
        hex =(red + green + blue).toUpperCase();

        tv_j_hexvalue.setText(hex);

        //changes the background on the view using the hex code
        rl_j_main.setBackgroundColor(Color.parseColor("#" + hex));

    }

    private void fillListView()
    {
        adapter = new ColorListAdapter(this,listofcolors);

        lv_j_listofcolors.setAdapter(adapter);

    }

    //change text function for when background is to light or dark
    public void changeTextColor(int i)
    {
        if(i > 80)
        {
            tv_j_redlabel.setTextColor(Color.BLACK);
            tv_j_redvalue.setTextColor(Color.BLACK);
            tv_j_greenlabel.setTextColor(Color.BLACK);
            tv_j_greenvalue.setTextColor(Color.BLACK);
            tv_j_bluelabel.setTextColor(Color.BLACK);
            tv_j_bluevalue.setTextColor(Color.BLACK);
            tv_j_hexlabel.setTextColor(Color.BLACK);
            tv_j_hexvalue.setTextColor(Color.BLACK);
        }
        else
        {
            tv_j_redlabel.setTextColor(Color.WHITE);
            tv_j_redvalue.setTextColor(Color.WHITE);
            tv_j_greenlabel.setTextColor(Color.WHITE);
            tv_j_greenvalue.setTextColor(Color.WHITE);
            tv_j_bluelabel.setTextColor(Color.WHITE);
            tv_j_bluevalue.setTextColor(Color.WHITE);
            tv_j_hexlabel.setTextColor(Color.WHITE);
            tv_j_hexvalue.setTextColor(Color.WHITE);
        }
    }

    //resets the background and all color values to default to white after saving a color
    public void resetColor()
    {
        sb_j_redvalue.setProgress(255);
        sb_j_greenvalue.setProgress(255);
        sb_j_bluevalue.setProgress(255);

    }
}