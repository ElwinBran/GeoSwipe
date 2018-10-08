package com.github.elwinbran.geoswipe;

public class LocationTrivia
{
    private final int image;

    private final boolean inEurope;

    public LocationTrivia(int image, boolean inEurope)
    {
        this.image = image;
        this.inEurope = inEurope;
    }

    public int getImage()
    {
        return this.image;
    }

    public boolean isInEurope()
    {
        return this.inEurope;
    }
}
