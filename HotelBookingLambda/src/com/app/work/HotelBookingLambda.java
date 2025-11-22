package com.app.work;

class Resource {
    String name;
    Resource(String name) { this.name = name; }
}

public class HotelBookingLambda {
    public static void main(String[] args) {

        Resource room = new Resource("Room");
        Resource payment = new Resource("Payment Gateway");

        Runnable bookingTask = () -> {
            String user = Thread.currentThread().getName();

            synchronized (room) {  // Always lock room first
                System.out.println(user + " locked Room for booking");

                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (payment) { // Always lock payment next
                    System.out.println(user + " locked Payment for booking");
                    System.out.println(user + "  Booking successful (Room + Payment done)");
                }
            }
        };

        Thread t1 = new Thread(bookingTask, "User-1");
        Thread t2 = new Thread(bookingTask, "User-2");

        t1.start();
        t2.start();
    }
}
