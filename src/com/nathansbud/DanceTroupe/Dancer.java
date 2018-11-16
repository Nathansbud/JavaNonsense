package com.nathansbud.DanceTroupe;

public class Dancer {
    private String name;

    private Performance[] performances = new Performance[1000];
    private int lastPerformance = 0;

    public Dancer(String _name) {
        name = _name;
    }

    public Performance getBestSoldOutShow() {
        if(lastPerformance > 0) {
            Performance best = performances[0];
            for(int i = 0; i < lastPerformance; i++) {
                if(performances[i].isSoldOut()) {
                    if(performances[i].getRating() > best.getRating()) {
                        best = performances[i];
                    }
                }
            }

            return best;
        } else {
            System.out.println("This dancer has yet to perform!");
            return new Performance("NonExist", false);
        }
    }

    public Performance getPerformance(int index) {
        if(lastPerformance > -1) {
            return performances[index];
        } else {
            return new Performance("NonExist", false);
        }
    }

    public void Perform(Performance p) {
        p.setRating((float)(Math.round(Math.random()*100)/10.0));
        performances[lastPerformance++] = p;
    }

    public float averageShows() {
        float avg = 0;
        for(int i = 0; i < lastPerformance; i++) {
            avg += performances[i].getRating();
        }
        return avg /= lastPerformance;
    }

    public void listAllPerformances() {
        for(int i = 0; i < lastPerformance - 1; i++) {
            for(int j = 0; j < lastPerformance - 1; j++) {
                if(performances[j].getRating() > performances[j+1].getRating()) {
                    Performance temp = performances[j];
                    performances[j] = performances[j + 1];
                    performances[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < lastPerformance; i++) {
            System.out.println("City: " + performances[i].getCity());
            System.out.println("Rating: " + performances[i].getRating());
            System.out.println("Sold Out: " + performances[i].isSoldOut());
        }
    }
}
