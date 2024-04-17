import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Trays tray = new Trays();
        Waiter waiter = new Waiter(tray);
        List<Guest> guests = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Guest guest = new Guest(tray, waiter);
            guests.add(guest);
            Thread thread = new Thread(guest);

            System.out.println(Thread.currentThread());
            thread.start();
        }

        for (Guest guest : guests) {

            try {
                guest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
