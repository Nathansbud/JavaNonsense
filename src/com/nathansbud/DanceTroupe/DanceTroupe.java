package com.nathansbud.DanceTroupe;

public class DanceTroupe {
    public static void main(String[] args) {
        Dancer d = new Dancer("Rana Lulla");
        d.Perform(new Performance("Mumbai", true));
        d.Perform(new Performance("Mumbai", true));

        d.listAllPerformances();
        System.out.println(d.getBestSoldOutShow().getRating());
        System.out.println(d.averageShows());
    }
}
