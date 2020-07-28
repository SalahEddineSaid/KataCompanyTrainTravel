package fr.adlere.companytrain.billing.input;


import java.util.List;
import java.util.Objects;


public class DayTravel {

    private List<Tap> taps;

    public List<Tap> getTaps() {
        return taps;
    }

    public void setTaps(List<Tap> taps) {
        this.taps = taps;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayTravel dayTravel = (DayTravel) o;
        return Objects.equals(taps, dayTravel.taps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taps);
    }

    @Override
    public String toString() {
        return "DayTravel{" +
                "taps=" + taps +
                '}';
    }
}


