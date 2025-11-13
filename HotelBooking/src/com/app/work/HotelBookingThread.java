package com.app.work;

class Resource {
    String name;

    public Resource(String name) {
        this.name = name;
    }
}

class BookingTask implements Runnable {
    private Resource room;
    private Resource payment;

    public BookingTask(Resource room, Resource payment) {
        this.room = room;
        this.payment = payment;
    }

    public void run() {
        String user = Thread.currentThread().getName();

        synchronized (room) {  // Lock room first
            System.out.println(user + " locked room");

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (payment) { // Then payment
                System.out.println(user + " locked payment gateway");
                System.out.println("✅ " + user + " booking successful!");
            }
        }
    }
}

public class HotelBookingThread {
    public static void main(String[] args) {

        Resource room = new Resource("Room");
        Resource payment = new Resource("Payment");

        Thread t1 = new Thread(new BookingTask(room, payment), "User-1");
        Thread t2 = new Thread(new BookingTask(room, payment), "User-2");

        t1.start();
        t2.start();
    }
}
