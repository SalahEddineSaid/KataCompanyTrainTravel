package fr.adlere.companytrain.billing.enums;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZoneTest {


    @Test
    void getLowestPrice_Station_A_To_Station_D() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.A,Station.D);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(240, Arrays.asList(1,2));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }

    @Test
    void getLowestPrice_Station_B_To_Station_C() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.B,Station.C);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(240, Arrays.asList(1,2));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }

    @Test
    void getLowestPrice_Station_H_To_Station_G() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.H,Station.G);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(200, Arrays.asList(4,4));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
        assertEquals(expected.firstEntry().getValue(),mapEntry.getValue());

    }

    @Test
    void getLowestPriceAndZoneFromTo_Station_D_To_Station_F() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.D,Station.F);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(280, Arrays.asList(2,3));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }



    @Test
    void getLowestPriceAndZoneFromTo_Station_H_To_Station_E() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.H,Station.E);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(200, Arrays.asList(4,3));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }

    @Test
    void getLowestPriceAndZoneFromTo_Station_E_To_Station_A() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.E,Station.A);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(240, Arrays.asList(2,1));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }

    @Test
    void getLowestPriceAndZoneFromTo_Station_A_To_Station_I() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.A,Station.I);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(300, Arrays.asList(1,4));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }


    @Test
    void getLowestPriceAndZoneFromTo_Station_E_To_Station_F() {

        Map.Entry<Integer, List<Integer>> mapEntry = Zone.getLowestPrice(Station.E,Station.F);
        TreeMap<Integer, List<Integer>>  expected = new TreeMap<>();
        expected.put(200, Arrays.asList(3,3));
        assertEquals(expected.firstEntry().getKey(),mapEntry.getKey());
    }

        }
