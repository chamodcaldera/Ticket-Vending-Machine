package lk.iit.level6.concurrent.assignment;

import java.util.Random;

public class TicketBuyer implements Runnable{

    private final TicketVendorMachine ticketVendorMachine;
    private final TravelTicket travelTicket;




    public TicketBuyer(TicketVendorMachine ticketVendorMachine, TravelTicket travelTicket) {
        this.ticketVendorMachine = ticketVendorMachine;
        this.travelTicket = travelTicket;

    }


    @Override
    public void run() {

        Random random = new Random();

        ticketVendorMachine.printTicket( this.travelTicket);

                System.out.println("Passenger " + this.travelTicket.getPassengerInfo().getPassengerName() + " got " + travelTicket);

        try {
            Thread.sleep(random.nextInt(100)+1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
