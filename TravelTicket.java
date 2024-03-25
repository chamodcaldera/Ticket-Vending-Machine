package lk.iit.level6.concurrent.assignment;

import java.math.BigDecimal;

public class TravelTicket {

    private final int ticketNumber;
    private final BigDecimal ticketPrice;

    private final TravelerDetails travelerDetails;

    private final TravelInfo locationInfo;


    public TravelTicket(int ticketNumber, BigDecimal ticketPrice, TravelerDetails travelerDetails, TravelInfo locationInfo) {
        this.ticketNumber = ticketNumber;
        this.ticketPrice = ticketPrice;
        this.travelerDetails = travelerDetails;
        this.locationInfo = locationInfo;
    }


    public int getTicketNumber() {
        return ticketNumber;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public TravelerDetails getPassengerInfo() {
        return travelerDetails;
    }

    public TravelInfo getLocationInfo() {
        return locationInfo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", ticketPrice=" + ticketPrice +
                ", passengerInfo=" + travelerDetails +
                ", locationInfo=" + locationInfo +
                '}';
    }
}
