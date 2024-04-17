import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guest extends Thread {
    Trays tray;
    Waiter waiter;
    int borek = 4;
    int drink = 4;
    int cake = 2;

    // Define maximum consumption limits
    private final int MAX_BOREK = 4;
    private final int MAX_CAKE = 2;
    private final int MAX_DRINK = 4;

    // Track consumed items for each guest
    private int consumedBorek = 0;
    private int consumedCake = 0;
    private int consumedDrink = 0;


    public Guest(Trays trays, Waiter waiter) {
        this.tray = trays;
        this.waiter = waiter;
    }

    void make_request_borek(Trays tray) {
        if (consumedBorek <= MAX_BOREK) {
            boolean a = tray.dec_Borek_number();
            if (a) {
                borek--;
                consumedBorek++;
                System.out.println("Guest " + Thread.currentThread().threadId() +
                        " consumed: Borek - " + consumedBorek +
                        ", Cake - " + consumedCake +
                        ", Drink - " + consumedDrink);
            } else {
                System.out.println(Thread.currentThread().threadId() + " You cannot eat Borek.");
            }
        } else {
            System.out.println(Thread.currentThread().threadId() + " has reached the maximum limit for Borek.");
        }
    }

    void make_request_cake(Trays tray) {
        if (consumedCake <= MAX_CAKE) {
            boolean a = tray.dec_Cake_number();
            if (a) {
                cake--;
                consumedCake++;
                System.out.println("Guest " + Thread.currentThread().threadId() +
                        " consumed: Borek - " + consumedBorek +
                        ", Cake - " + consumedCake +
                        ", Drink - " + consumedDrink);
            } else {
                System.out.println(Thread.currentThread().threadId() + " You cannot eat Cake.");
            }
        } else {
            System.out.println(Thread.currentThread().threadId() + " has reached the maximum limit for Cake.");
        }
    }

    void make_request_drink(Trays tray) {
        if (consumedDrink <= MAX_DRINK) {
            boolean a = tray.dec_Drink_number();
            if (a) {
                drink--;
                consumedDrink++;
                System.out.println("Guest " + Thread.currentThread().threadId() +
                        " consumed: Borek - " + consumedBorek +
                        ", Cake - " + consumedCake +
                        ", Drink - " + consumedDrink);
            } else {
                System.out.println(Thread.currentThread().threadId() + " You cannot eat Cake.");
            }
        } else {
            System.out.println(Thread.currentThread().threadId() + " has reached the maximum limit for Cake.");
        }
    }

    public void run() {
        // eğer 0 1 2 den bir tanesi bittiyse hiç onu seçmemesi lazım
        // static koyarsan tüm threadler kendi arasında o statc değeri kullanabilir

        List<String> availableItems = new ArrayList<>();

        // Randomly select items until all items are consumed
        Random random = new Random();
        while (borek > 0 || drink > 0 || cake > 0) {

            availableItems.clear();


            if (borek > 0) availableItems.add("borek");
            if (drink > 0) availableItems.add("drink");
            if (cake > 0) availableItems.add("cake");


            int randomIndex = random.nextInt(availableItems.size()); // Generate a random index within the size of the list
            String randomItem = availableItems.get(randomIndex);


            switch (randomItem) {
                case "borek":
                    make_request_borek(tray);
                    break;
                case "cake":
                    make_request_cake(tray);
                    break;
                case "drink":
                    make_request_drink(tray);
                    break;


            }

            if (tray.stored_Cake <= 0 && tray.stored_Drink <= 0 && tray.stored_Borek <= 0){
                System.out.println("Guest " + Thread.currentThread().threadId() + " cannot make a request as all items are finished.");

                System.out.println("Guest " + Thread.currentThread().threadId() +
                        " consumed: Borek - " + consumedBorek +
                        ", Cake - " + consumedCake +
                        ", Drink - " + consumedDrink);
                break;
            }

        }
    }

    public void printTotalConsumption() {
        System.out.println("Guest " + Thread.currentThread().threadId() +
                " consumed: Borek - " + consumedBorek +
                ", Cake - " + consumedCake +
                ", Drink - " + consumedDrink);
    }

}
