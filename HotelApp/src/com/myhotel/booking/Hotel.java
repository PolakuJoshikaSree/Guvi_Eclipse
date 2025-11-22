package com.myhotel.booking;

class Hotel {
    String name;
    int totalRooms;
    int availableRooms;

    Hotel(String name, int totalRooms) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
    }

    boolean bookRoom() {
        if (availableRooms > 0) {
            availableRooms--;
            return true;
        }
        return false;
    }

    void displayInfo() {
        System.out.println(name + " — Available Rooms: " + availableRooms + "/" + totalRooms);
    }
}
