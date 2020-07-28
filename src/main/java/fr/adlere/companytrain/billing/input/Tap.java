package fr.adlere.companytrain.billing.input;


import fr.adlere.companytrain.billing.enums.Station;

import java.util.Objects;

public class Tap {

    private int unixTimestamp;
    private int customerId;
    private Station station;

    public Tap(int unixTimestamp, int customerId, Station station) {
        this.unixTimestamp = unixTimestamp;
        this.customerId = customerId;
        this.station = station;
    }

    public Tap() {
    }

    public int getUnixTimestamp() {
        return unixTimestamp;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setUnixTimestamp(int unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tap tap = (Tap) o;
        return unixTimestamp == tap.unixTimestamp &&
                customerId == tap.customerId &&
                station == tap.station;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unixTimestamp, customerId, station);
    }
    @Override
    public String toString() {
        return "Tap{" +
                "unixTimestamp=" + unixTimestamp +
                ", customerId=" + customerId +
                ", station=" + station +
                '}';
    }
}
