package lk.iit.level6.concurrent.assignment;

import java.math.BigDecimal;

public class TicketManagementSystem {
    public static void main(String[] args) throws InterruptedException {

        TravelerDetails travelerDetails = new TravelerDetails("Chamod", "0726862497", "chamod@gmail.com");
        TravelerDetails travelerDetails1 = new TravelerDetails("Chandupa", "0779846318", "chandupa@gmail.com");
        TravelerDetails travelerDetails2 = new TravelerDetails("Oshan", "0759985335", "oshan@gmail.com");

        TravelInfo travelInfo = new TravelInfo("Colombo", "Nuwara Eliya");
        TravelInfo travelInfo2 = new TravelInfo("Kandy", "Maradhana");
        TravelInfo travelInfo3 = new TravelInfo("Colombo", "Anuradhapura");


        TravelTicket travelTicket = new TravelTicket(1, new BigDecimal(3000), travelerDetails, travelInfo);
        TravelTicket travelTicket2 = new TravelTicket(2, new BigDecimal(2000), travelerDetails1, travelInfo2);
        TravelTicket travelTicket3 = new TravelTicket(3, new BigDecimal(1500), travelerDetails2, travelInfo3);


        TicketVendorDispenser ticketTicketDispenser = new TicketVendorDispenser(5, 5);

        TicketBuyer ticketBuyer = new TicketBuyer(ticketTicketDispenser, travelTicket);
        TicketBuyer ticketBuyer2 = new TicketBuyer(ticketTicketDispenser, travelTicket2);
        TicketBuyer ticketBuyer3 = new TicketBuyer(ticketTicketDispenser, travelTicket3);

        InkRefillTechnician inkRefillTechnician = new InkRefillTechnician("Toner Technician", ticketTicketDispenser);
        PaperRestockExpert paperRestockExpert = new PaperRestockExpert("Paper Technician", ticketTicketDispenser);

        ThreadGroup ticketGroup = new ThreadGroup("TicketGroup");
        ThreadGroup maintenanceGroup = new ThreadGroup("MaintenanceGroup");

        Thread passengerThread = new Thread(ticketGroup,ticketBuyer, "John");
        Thread passengerThread2 = new Thread(ticketGroup,ticketBuyer2, "Janindu");
        Thread passengerThread3 = new Thread(ticketGroup,ticketBuyer3, "Pathiran");

        Thread tonerTechnicianThread = new Thread(maintenanceGroup,inkRefillTechnician, "Toner Technician");
        Thread paperTechnicianThread = new Thread(maintenanceGroup,paperRestockExpert, "Paper Technician");


        passengerThread.start();
        passengerThread2.start();
        passengerThread3.start();

        tonerTechnicianThread.start();
        paperTechnicianThread.start();

        passengerThread.join();
        passengerThread2.join();
        passengerThread3.join();

//        ticketBuyer.shutdown();
//        ticketBuyer2.shutdown();
//        ticketBuyer3.shutdown();

        inkRefillTechnician.shutdown();
        paperRestockExpert.shutdown();

        System.out.println("Final paper level is " + ticketTicketDispenser.getPaperLevel());
        System.out.println("Final Toner level is "+ ticketTicketDispenser.getInkLevel());

    }
}