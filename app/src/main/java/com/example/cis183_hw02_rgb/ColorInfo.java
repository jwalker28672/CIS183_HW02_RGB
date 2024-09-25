package com.example.cis183_hw02_rgb;

public class ColorInfo
{
    private String redValue;
    private String greenValue;
    private String blueValue;
    private String hexValue;

    public ColorInfo()
    {

    }

    public ColorInfo(String r, String g, String b, String h)
    {
        redValue   = r;
        greenValue = g;
        blueValue  = b;
        hexValue   = h;

    }

    //=================================================================================
    //                             GETTERS
    //=================================================================================


    public String getRedValue()
    {
        return redValue;
    }

    public String getGreenValue()
    {
        return greenValue;
    }

    public String getBlueValue()
    {
        return blueValue;
    }

    public String getHexValue()
    {
        return hexValue;
    }

    //=================================================================================
    //                             SETTERS
    //=================================================================================


    public void setRedValue(String redValue)
    {
        this.redValue = redValue;
    }

    public void setGreenValue(String greenValue)
    {
        this.greenValue = greenValue;
    }

    public void setBlueValue(String blueValue)
    {
        this.blueValue = blueValue;
    }

    public void setHexValue(String hexValue)
    {
        this.hexValue = hexValue;
    }
}
