
public class Waiter {
    private static Trays trays;

    public Waiter(Trays trays) {
        Waiter.trays = trays;

    }

    private static void fill_tray(String message) {

        switch (message) {
            case "Cake" -> trays.add_Cake_number();
            case "Borek" -> trays.add_Borek_number();
            case "Drink" -> trays.add_Drink_number();
            default -> System.out.println("Invalid item.");
        }
    }


    public static void tray_information(String message) {

        System.out.println("Number of items   "+"Borek:"+trays.stored_Borek+"  Drink: "+trays.stored_Drink+"  Cake: "+trays.stored_Cake);
        System.out.println(message + " tray finished");

        fill_tray(message);

    }


}
