package concurrencydemo;

class Room {
    public final String name;
    public Room(String name) { this.name = name; }
}
class Payment {}
public class HotelSimulation {
    private static final Room room = new Room("Room-101");
    private static final Payment payment = new Payment();
    public static void deadlockDemo() {
        Thread t1 = new Thread(() -> {
            synchronized (room) {
                System.out.println("User1 locked Room");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (payment) {
                    System.out.println("User1 locked Payment");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (payment) {
                System.out.println("User2 locked Payment");
                try { Thread.sleep(100); } catch (Exception ignored) {}
                synchronized (room) {
                    System.out.println("User2 locked Room");
                }
            }
        });
        t1.start();
        t2.start();
    }
    public static void deadlockSolved() {
        Thread t1 = new Thread(() -> {
            synchronized (room) {
                System.out.println("User1 locked Room");
                synchronized (payment) {
                    System.out.println("User1 locked Payment");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (room) {
                System.out.println("User2 locked Room");
                synchronized (payment) {
                    System.out.println("User2 locked Payment");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
