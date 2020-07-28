package fr.adlere.companytrain.billing.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerSummary implements Serializable {

    private int customerId;
    private int totalCostInCents;
    private List<Trip> trips = new ArrayList<>();

    public CustomerSummary() {
    }

    public static CustomerSummary createCustomerSummary(int customerId) {
        CustomerSummary customerSummary = new CustomerSummary();
        customerSummary.setCustomerId(customerId);
        customerSummary.setTrips(new ArrayList<>());
        return customerSummary;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setTotalCostInCents(int totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTotalCostInCents() {
        return totalCostInCents;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerSummary that = (CustomerSummary) o;
        return customerId == that.customerId &&
                totalCostInCents == that.totalCostInCents &&
                Objects.equals(trips, that.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, totalCostInCents, trips);
    }
}

