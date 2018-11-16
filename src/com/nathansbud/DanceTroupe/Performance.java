package com.nathansbud.DanceTroupe;

public class Performance {
    private String city;
    private boolean soldOut;
    private float rating;

    Performance() {
        city = "NonExist";
        soldOut = false;
    }

    public Performance(String _city, boolean _soldOut) {
        city = _city;
        soldOut = _soldOut;
    }

    public void setRating(float _rating) {
        rating = _rating;
    }

    public String getCity() {
        return city;
    }

    public float getRating() {
        return rating;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

}
