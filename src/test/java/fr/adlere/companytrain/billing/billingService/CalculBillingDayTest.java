package fr.adlere.companytrain.billing.billingService;

import fr.adlere.companytrain.billing.enums.Station;
import fr.adlere.companytrain.billing.input.DayTravel;
import fr.adlere.companytrain.billing.input.Tap;
import fr.adlere.companytrain.billing.output.CustomerSummary;
import fr.adlere.companytrain.billing.output.Summary;
import fr.adlere.companytrain.billing.output.Trip;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculBillingDayTest {


    /*customer 1*/
    private DayTravel get_DayTravel_A_D(){

        DayTravel dayTravelAtoD=new DayTravel();
        List<Tap> taps=new ArrayList<>();
        taps.add(new Tap(1,1, Station.A));
        taps.add(new Tap(2,1,Station.D));

        dayTravelAtoD.setTaps(taps);

        return dayTravelAtoD;
    }
    private Summary get_Summary_A_D(){

        Summary summary=new Summary();
        List<CustomerSummary> customerSummaries =new ArrayList<>();
        CustomerSummary customerSummary=new CustomerSummary();
        customerSummary.setCustomerId(1);
        customerSummary.setTotalCostInCents(240);
        customerSummary.setTrips(Arrays.asList(
                new Trip(Station.A,Station.D,1,240,1,2)));

        customerSummaries.add(customerSummary);
        summary.setCustomerSummaries(customerSummaries);

        return summary;
    }
    @Test
    void check_Summary_A_D() throws IOException {
        CalculBillingDay calculSummary=new CalculBillingDay();
        DayTravel journey = get_DayTravel_A_D();
        Summary expected = get_Summary_A_D();
        Summary summary = calculSummary.calculSummary(journey);
        assertEquals(summary,expected);
    }

    /*customer 2*/
    private DayTravel get_DayTravel_B_C_H_G_D_F(){

        DayTravel dayTravelAtoD=new DayTravel();
        List<Tap> taps=new ArrayList<>();
        taps.add(new Tap(2,2, Station.B));
        taps.add(new Tap(3,2, Station.C));
        taps.add(new Tap(3,2, Station.H));
        taps.add(new Tap(10,2,Station.G));
        taps.add(new Tap(20,2,Station.D));
        taps.add(new Tap(65,2,Station.F));

        dayTravelAtoD.setTaps(taps);

        return dayTravelAtoD;
    }

    private Summary get_Summary_B_C_H_G_D_F(){

        Summary summary=new Summary();
        List<CustomerSummary> customerSummaries =new ArrayList<>();
        CustomerSummary customerSummary=new CustomerSummary();
        customerSummary.setCustomerId(2);
        customerSummary.setTotalCostInCents(720);
        customerSummary.setTrips(Arrays.asList(
                new Trip(Station.B,Station.C,2,240,1,2),
                new Trip(Station.H,Station.G,3,200,4,4),
                new Trip(Station.D,Station.F,20,280,2,3)
        ));
        customerSummaries.add(customerSummary);
        summary.setCustomerSummaries(customerSummaries);

        return summary;
    }


    @Test
    void check_Summary_B_C_H_G_D_F() throws IOException {
        CalculBillingDay calculSummary=new CalculBillingDay();
        DayTravel journey = get_DayTravel_B_C_H_G_D_F();
        Summary expected = get_Summary_B_C_H_G_D_F();
        Summary summary = calculSummary.calculSummary(journey);
        assertEquals(summary,expected);
    }

    /*customer 3*/
    private Summary get_Summary_H_E_E_A(){

        Summary summary=new Summary();
        List<CustomerSummary> customerSummaries =new ArrayList<>();
        CustomerSummary customerSummary=new CustomerSummary();
        customerSummary.setCustomerId(3);
        customerSummary.setTotalCostInCents(440);
        customerSummary.setTrips(Arrays.asList(
                new Trip(Station.H,Station.E,3,200,4,3),
                new Trip(Station.E,Station.A,30,240,2,1)
        ));

        customerSummaries.add(customerSummary);
        summary.setCustomerSummaries(customerSummaries);

        return summary;
    }
    private DayTravel get_DayTravel_H_E_E_A(){

        DayTravel dayTravelAtoD=new DayTravel();
        List<Tap> taps=new ArrayList<>();
        taps.add(new Tap(3,3, Station.H));
        taps.add(new Tap(27,3,Station.E));
        taps.add(new Tap(30,3,Station.E));
        taps.add(new Tap(35,3,Station.A));

        dayTravelAtoD.setTaps(taps);

        return dayTravelAtoD;
    }
    @Test
    void check_Summary_H_E_E_A() throws IOException {
        CalculBillingDay calculSummary=new CalculBillingDay();
        DayTravel journey = get_DayTravel_H_E_E_A();
        Summary expected = get_Summary_H_E_E_A();
        Summary summary = calculSummary.calculSummary(journey);
        assertEquals(summary,expected);
    }




    /*  customer 4*/

    private Summary get_Summary_A_I_F_E(){

        Summary summary=new Summary();
        List<CustomerSummary> customerSummaries =new ArrayList<>();
        CustomerSummary customerSummary=new CustomerSummary();
        customerSummary.setCustomerId(4);
        customerSummary.setTotalCostInCents(500);
        customerSummary.setTrips(Arrays.asList(
                new Trip(Station.A,Station.I,41,300,1,4),
                new Trip(Station.E,Station.F,70,200,3,3)
        ));

        customerSummaries.add(customerSummary);
        summary.setCustomerSummaries(customerSummaries);

        return summary;
    }

    private DayTravel get_DayTravel_A_I_E_F(){

        DayTravel dayTravelAtoD=new DayTravel();
        List<Tap> taps=new ArrayList<>();
        taps.add(new Tap(41,4,Station.A));
        taps.add(new Tap(47,4,Station.I));
        taps.add(new Tap(70,4,Station.E));
        taps.add(new Tap(81,4,Station.F));

        dayTravelAtoD.setTaps(taps);

        return dayTravelAtoD;
    }
    @Test
    void check_Summary_A_I_F_E() throws IOException {
        CalculBillingDay calculSummary=new CalculBillingDay();
        DayTravel journey = get_DayTravel_A_I_E_F();
        Summary expected = get_Summary_A_I_F_E();
        Summary summary = calculSummary.calculSummary(journey);
        assertEquals(summary,expected);
    }




























    }
