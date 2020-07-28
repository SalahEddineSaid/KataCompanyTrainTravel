package fr.adlere.companytrain.billing.billingService;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.adlere.companytrain.billing.enums.Station;
import fr.adlere.companytrain.billing.enums.Zone;
import fr.adlere.companytrain.billing.input.DayTravel;
import fr.adlere.companytrain.billing.input.Tap;
import fr.adlere.companytrain.billing.output.CustomerSummary;
import fr.adlere.companytrain.billing.output.Summary;
import fr.adlere.companytrain.billing.output.Trip;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CalculBillingDay {

    /**
     * grouping the customers by their taps then build the customerSummary for each customer
     * @param dayTravel : customer day
     * @return object Summary that contains list of CustomerSummary
     */
    public Summary calculSummary(DayTravel dayTravel) {

        Summary daySummary = Summary.createSummary();
        List<CustomerSummary> customerSummaries =new ArrayList<>();

        List<Tap> taps =sortTapsByCustomerByDate(dayTravel);
        Map<Integer, List<Tap>> dayCustomerTaps = groupCustomerByIdAndTab(taps);

        for (Map.Entry<Integer, List<Tap>> entry : dayCustomerTaps.entrySet()) {
            Integer id = entry.getKey();
            List<Tap> list = entry.getValue();
            CustomerSummary customerSummary = CustomerSummary.createCustomerSummary(id);
            int i = 0;
            while (i < list.size() - 1) {
                Trip trip = Trip.createTrip(list.get(i),list.get(i+1));
                customerSummary.setTotalCostInCents(customerSummary.getTotalCostInCents() + trip.getCostInCents());
                customerSummary.getTrips().add(trip);
                i += 2;
            }
            customerSummaries.add(customerSummary);
        }
        daySummary.setCustomerSummaries(customerSummaries);

        return daySummary;
    }


    /**
     * sort the journey Taps by Customer Id then by date
     * @param daytravel : customer day
     * @return List of Taps sorted
     */
    private List<Tap> sortTapsByCustomerByDate(DayTravel daytravel) {

        Comparator<Tap> comparator = Comparator.comparing(tap -> tap.getCustomerId());
        comparator = comparator.thenComparing(Comparator.comparing(tap -> tap.getUnixTimestamp()));
            return daytravel.getTaps().stream()
                    .sorted(comparator)
                    .parallel()
                    .collect(Collectors.toList());
    }

    /**
     * Grouping Customers id and after grouping by their taps
     * @param taps : customer day
     * @return Map ID customer and taps
     */
    private Map<Integer, List<Tap>> groupCustomerByIdAndTab(List<Tap> taps){
        Map<Integer, List<Tap>> dayCustomerTaps = new HashMap<>();

        for (Tap tap : taps) {
            dayCustomerTaps.computeIfAbsent(tap.getCustomerId(), k -> new ArrayList<>()).add(tap);
        }
        return dayCustomerTaps;
    }

}
