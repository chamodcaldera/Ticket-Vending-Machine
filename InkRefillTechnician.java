package lk.iit.level6.concurrent.assignment;

import java.util.Random;

public class InkRefillTechnician implements Runnable {


        public static final int NUMBER_OF_RETRIES = 3;

        private final TicketVendorServiceInterface machine;
        private final String name;
        private volatile boolean shutdown = false;

        public InkRefillTechnician(String name, TicketVendorServiceInterface machine) {
            this.name = name;
            this.machine = machine;
        }

        @Override
        public void run() {

            Random random = new Random();



            for (int i = 0; i < NUMBER_OF_RETRIES && !shutdown; i++) {
                if (machine.getInkLevel() < TicketVendorMachine.MIN_INK_LEVEL) {
                    machine.replaceInkCartridge();
                }

                try {
                    Thread.sleep(random.nextInt(100) + 1);
                } catch (InterruptedException e) {
                    shutdown = true; // Set shutdown to true if interrupted
                }
            }



        }

    public void shutdown() {
        shutdown = true;
    }


    public String getName() {
            return name;
        }
}


