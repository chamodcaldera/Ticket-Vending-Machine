package lk.iit.level6.concurrent.assignment;

public interface TicketVendorServiceInterface extends TicketVendorMachine {

    void replaceInkCartridge();

    void addPrintingPaper();


    int getPaperLevel();
    int getInkLevel();
}
