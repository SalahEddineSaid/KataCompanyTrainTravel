package fr.adlere.companytrain.billing.output;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Summary implements Serializable {

    private List<CustomerSummary> customerSummaries;

    public Summary() {
    }

    public List<CustomerSummary> getCustomerSummaries() {
        return customerSummaries;
    }

    public static Summary createSummary() {
        Summary daySummary = new Summary();
        daySummary.setCustomerSummaries(new ArrayList<>());
        return daySummary;
    }

    public void setCustomerSummaries(List<CustomerSummary> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return customerSummaries.equals(summary.customerSummaries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerSummaries);
    }

    @Override
    public String toString() {
        return "Summary{" +
                "customerSummaries=" + customerSummaries +
                '}';
    }

}
