package fr.adlere.companytrain.billing.exceptions;

import fr.adlere.companytrain.billing.input.DayTravel;

public class ValidateDayTravelException {

    public ValidateDayTravelException() {
    }

    public  boolean ValidateDayTravelException(DayTravel dayTravel) {
        if(dayTravel == null) throw new DayValidationException("Day Travel must be not null");
        if(dayTravel.getTaps() == null) throw new DayValidationException("Taps must be not null");
        if(dayTravel.getTaps().size()%2 != 0) throw new DayValidationException("Tap is not pair check if some one does sill in the station ");

        return true;
    }
}
