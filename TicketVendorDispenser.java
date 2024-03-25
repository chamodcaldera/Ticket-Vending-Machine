package lk.iit.level6.concurrent.assignment;



public class TicketVendorDispenser implements TicketVendorServiceInterface {
    private int paperLevel;
    private int inkLevel;

    public TicketVendorDispenser(int paperLevel, int inkLevel) {
        this.paperLevel = paperLevel;
        this.inkLevel = inkLevel;
    }

    private synchronized boolean isResourceAvailable() {
        return paperLevel > 0 && inkLevel >= TicketVendorMachine.MIN_INK_LEVEL;
    }

    private synchronized void printTicket() {
        inkLevel -= 1;
        paperLevel -=1 ;
    }

    @Override
    public synchronized void replaceInkCartridge() {
        try {
            while (inkLevel >= TicketVendorMachine.MIN_INK_LEVEL) {
                wait();
            }
            inkLevel = TicketVendorMachine.FULL_INK_LEVEL;
            System.out.println(Thread.currentThread().getName() + " Filled the Toner");
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public synchronized void addPrintingPaper() {
        try {
            while ((paperLevel + TicketVendorMachine.SHEETS_PER_PACK) > TicketVendorMachine.FULL_PAPER_TRAY) {
                wait();
            }
            paperLevel += TicketVendorMachine.SHEETS_PER_PACK;
            System.out.println(Thread.currentThread().getName() + " Filled the Paper");
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public synchronized void printTicket(TravelTicket travelTicket) {
        try {
            while (!isResourceAvailable()) {
                wait();
            }
            printTicket();
            System.out.println("Ticket printed by " + Thread.currentThread().getName() + "Ticket : " + travelTicket.toString());
            notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public synchronized int getPaperLevel() {
        return paperLevel;
    }

    @Override
    public int getInkLevel() {
        return inkLevel ;
    }


}
