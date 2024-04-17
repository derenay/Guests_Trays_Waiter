import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Trays {

    Lock lock = new ReentrantLock();
    String message;

    int cake_number = 5;
    int drink_number = 5;
    int borek_number = 5;

    int stored_Cake = 15;
    int stored_Borek = 25;
    int stored_Drink = 25;


    public void add_Drink_number(){
        while (drink_number < 5 && stored_Drink > 0){
            System.out.println("Adding drinks to drink tray");
            drink_number++;
            stored_Drink--;
            if(drink_number == 5){
                System.out.println("Number of Drink on the tray: "+ drink_number);
                break;
            }
            if(stored_Drink <= 0){
                System.out.println("-------Drink ends-------");
                break;
            }
        }
    }

    public void add_Cake_number() {
        while (cake_number < 5 && stored_Cake > 0){
            System.out.println("Adding drinks to drink tray");
            cake_number++;
            stored_Cake--;
            if(cake_number == 5){
                System.out.println("Number of cake on the tray: "+ cake_number);
                break;
            }
            if(stored_Cake <= 0){
                System.out.println("-------Cake ends-------");
                break;
            }
        }
    }

    public void add_Borek_number() {
        while (borek_number < 5 && stored_Borek > 0){
            System.out.println("Adding cakes to cake tray");
            borek_number++;
            stored_Borek--;
            if(borek_number == 5){
                System.out.println("Number of cake on the tray: "+ borek_number);
                break;
            }
            if(stored_Borek <= 0){
                System.out.println("-------Cake ends-------");
                break;
            }
        }
    }


    public boolean dec_Drink_number() {

        System.out.println("Drink deleted from tray");
        lock.lock();
        message = "Drink";
        if (this.drink_number == 0) {

            Waiter.tray_information(message);
            lock.unlock();
            return false;
        } else if (this.drink_number == 1) {

            Waiter.tray_information(message);
            this.drink_number--;
            lock.unlock();
            System.out.println("Drink tray: "+drink_number+"----------------------1---------1---------1--------------");
            return true;

        } else {
            this.drink_number--;
            System.out.println("Drink tray: "+drink_number);
            lock.unlock();
            return true;
        }
    }


    public boolean dec_Borek_number() {

        System.out.println("Borek deleted from tray");
        message = "Borek";
        lock.lock();
        if (this.borek_number == 0) {

            Waiter.tray_information(message);
            lock.unlock();
            return false;

        } else if (this.borek_number == 1) {

            Waiter.tray_information(message);
            this.borek_number--;
            System.out.println("Borek tray: "+borek_number+"----------------------1---------1---------1--------------");
            lock.unlock();
            return true;

        } else {
            this.borek_number--;
            System.out.println("Borek tray: "+borek_number);
            lock.unlock();
            return true;
        }

    }




    public boolean dec_Cake_number() {
        System.out.println("Cake deleted from tray");

        message = "Cake";
        lock.lock();
        if (this.cake_number == 0) {

            Waiter.tray_information(message);
            lock.unlock();
            return false;
        } else if (this.cake_number == 1) {

            Waiter.tray_information(message);
            this.cake_number--;
            System.out.println("Cake tray: "+cake_number+"----------------------1---------1---------1--------------");
            lock.unlock();
            return true;

        } else {
            this.cake_number--;
            System.out.println("Cake tray: "+cake_number);
            lock.unlock();
            return true;
        }

    }

}
