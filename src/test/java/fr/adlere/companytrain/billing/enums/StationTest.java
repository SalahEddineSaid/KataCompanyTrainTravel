package fr.adlere.companytrain.billing.enums;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationTest {

    @Test
    void getZones_ZonesStaion_ReturnTheListOfZones() {
        assertEquals(Arrays.asList(Zone.ZONE_ONE), Station.A.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_ONE), Station.B.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_TWO), Station.D.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_TREE,Zone.ZONE_TWO), Station.C.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_TREE,Zone.ZONE_TWO), Station.E.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_TREE,Zone.ZONE_FOUR), Station.F.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_FOUR), Station.G.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_FOUR), Station.H.getZones());
        assertEquals(Arrays.asList(Zone.ZONE_FOUR), Station.I.getZones());
    }
}
