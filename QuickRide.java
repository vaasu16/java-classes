package test;

abstract public class QuickRide {
    int price;
    String id;

    void common() {
        System.out.println("This is common for all rides");
    }

    abstract void stop();

    public static void main(String[] args) {
        QuickRide r1 = new Cab();
        QuickRide r2 = new Bus();
        QuickRide r3 = new Train();

        System.out.println("Booking a Cab with price: " + r1.price + " and ID: " + r1.id);
        r1.common();
        r1.stop();

        System.out.println("\nBooking a Bus for only: " + r2.price + " and ID: " + r2.id);
        r2.common();
        r2.stop();

        System.out.println("\nBooking a Train with price: " + r3.price + " and ID: " + r3.id);
        r3.common();
        r3.stop();

        try {
            ((Cab) r1).cancel();
        } catch (CancelEx e) {
            System.out.println("Cab Cancelled: " + e.getMessage());
        }

        try {
            ((Train) r3).cancel();
        } catch (CancelEx e) {
            System.out.println("Train Cancelled: " + e.getMessage());
        }
    }
}

class Cab extends QuickRide {
    Cab() {
        price = 500;
        id = "CAB101";
    }

    @Override
    void stop() {
        System.out.println("Cab has stopped safely.");
    }

    void cancel() throws CancelEx {
        throw new CancelEx("Refund of ₹300 will be processed.");
    }
}

class Bus extends QuickRide {
    Bus() {
        price = 200;
        id = "BUS303";
    }

    @Override
    void stop() {
        System.out.println("Bus has stopped at the station.");
    }
}

class Train extends QuickRide {
    Train() {
        price = 1200;
        id = "TRN202";
    }

    @Override
    void stop() {
        System.out.println("Train has stopped at the platform.");
    }

    void cancel() throws CancelEx {
        throw new CancelEx("Refund of ₹1000 will be processed.");
    }
}

class CancelEx extends Exception {
    CancelEx(String msg) {
        super(msg);
    }
}

