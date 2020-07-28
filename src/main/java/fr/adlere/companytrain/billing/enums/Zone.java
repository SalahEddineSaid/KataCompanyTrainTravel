package fr.adlere.companytrain.billing.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum Zone {

    ZONE_ONE(1), ZONE_TWO(2), ZONE_TREE(3), ZONE_FOUR(4);


    /**
     * initialize the price for each case
     *
     * @return Tree map containing the price and list Zone affected
     */
    public static TreeMap<Integer, List<Integer>> initPrice() {

        TreeMap<Integer, List<Integer>> mapPriceZonStations = new TreeMap<Integer, List<Integer>>();
        mapPriceZonStations.put(200, Arrays.asList(ZONE_TREE.value, ZONE_FOUR.value));
        mapPriceZonStations.put(240, Arrays.asList(ZONE_ONE.value, ZONE_TWO.value));
        mapPriceZonStations.put(280, Arrays.asList(ZONE_ONE.value, ZONE_TWO.value, ZONE_TREE.value));
        mapPriceZonStations.put(300, Arrays.asList(ZONE_ONE.value, ZONE_TWO.value, ZONE_FOUR.value));

        return mapPriceZonStations;
    }

    /**
     * Calculate the lowest price and the fare zone, between tow station by given:.
     *
     * @param from start station.
     * @param to   end station.
     * @return map containing the lower price and List zone start and end zone
     */
    public static Map.Entry<Integer, List<Integer>> getLowestPrice(Station from, Station to) {

        TreeMap<Integer, List<Integer>> mapZoneLower = new TreeMap<>();

        for (Map.Entry<Integer, List<Integer>> entry : Zone.initPrice().entrySet()) {
            from.getZones().forEach(e -> {
                to.getZones().forEach(v -> {
                    if (entry.getValue().containsAll(Arrays.asList(e.getValue(), v.getValue())))
                        mapZoneLower.put(entry.getKey(), Arrays.asList(e.getValue(), v.getValue()));

                });
            });
        }

        // System.out.println("Station from =>" + from + " Zone From " + mapZonesFirst.getKey() + " ==> " + mapZonesFirst.getValue().get(0));
       // System.out.println("Station to  =>" + to + " Zone to " + mapZonesFirst.getKey() + " ==> " + mapZonesFirst.getValue().get(1));
        return mapZoneLower.firstEntry();
    }

    private int value;

    Zone(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
