package lk.iit.level6.concurrent.assignment;

public interface TicketVendorMachine {

     int FULL_PAPER_TRAY = 10;//250
     int SHEETS_PER_PACK = 5;//50



     int FULL_INK_LEVEL = 10;//500
     int MIN_INK_LEVEL = 5;

     void printTicket(TravelTicket travelTicket);
}
