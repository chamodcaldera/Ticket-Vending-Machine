package lk.iit.level6.concurrent.assignment;

import java.util.Random;

public class PaperRestockExpert implements Runnable {

    public static final int NUMBER_OF_RETRIES = 3;

    private final TicketVendorServiceInterface machine;
    private final String name;
    private volatile boolean shutdown = false;



    public PaperRestockExpert(String name, TicketVendorServiceInterface machine) {
        this.name = name;
        this.machine = machine;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_RETRIES && !shutdown; i++) {  // Check shutdown flag
            if(machine.getPaperLevel() < TicketVendorMachine.SHEETS_PER_PACK) {
                machine.addPrintingPaper();
            }

            try {
                Thread.sleep(random.nextInt(100) + 1);
            } catch (InterruptedException e) {
                shutdown = true;  // Handle interruption safely
            }
        }
    }

    public void shutdown() {
        shutdown = true;  // Method to trigger shutdown
    }

    public String getName() {
        return name;
    }
}
