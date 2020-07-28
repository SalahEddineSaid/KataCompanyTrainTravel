package fr.adlere.companytrain.billing.enums;

import java.util.ArrayList;
import java.util.List;

public enum Station {
    A, B, C, D, E, F, G, H, I;

    public List<Zone> getZones() {

        List<Zone> zoneList = new ArrayList<>();

        if(this.equals(A) || this.equals(B)) zoneList.add(Zone.ZONE_ONE);
        if(this.equals(D)) zoneList.add(Zone.ZONE_TWO);
        if(this.equals(C) || this.equals(E)) {
            zoneList.add(Zone.ZONE_TREE);
            zoneList.add(Zone.ZONE_TWO);
        }
        if(this.equals(F)) {
            zoneList.add(Zone.ZONE_TREE);
            zoneList.add(Zone.ZONE_FOUR);
        }
        if(this.equals(G) || this.equals(H)|| this.equals(I))zoneList.add(Zone.ZONE_FOUR);

        return zoneList;
    }



}
