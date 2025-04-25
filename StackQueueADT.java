// Plan Tikcet Booking SYstem with Waiting list
// Use a stack to manage the booked seats (last-in-first-out)
// Use a queue to manage the waiting list (first-in-first-out)
// Todo if a customer cancel a booking, the first customer in the waiting list will be moved to the booked seats

import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueueADT {
    private int MAX_CAPACITY = 10;

    // Stack to manage the booked seats
    private Stack<Integer> bookedSeats = new Stack<Integer>();
    // Queue to manage the waiting list
    private Queue<String> waitingList = new LinkedList<>();

    // Functions
    // Book a seat
    // Join the waiting list if the seat is not available
    // Cancel a booking
    
    // First we book a seat
    public void bookSeat(String customerName, int seat) {
        // 0 is not allowed
        if (seat == 0) {
            throw new IllegalArgumentException("Seat number cannot be 0");
        }

        if (bookedSeats.size() < MAX_CAPACITY) {
            bookedSeats.push(seat);
        } else {
            waitingList.add(customerName + ":" + seat);
        }
    }

    // Cancel a booking
    // First person in the waiting list will be moved to the booked seats
    // Then parse the string and split the name and seat and parse the seat to an integer
    public void cancelBooking(Integer seat) {
        // Check if the customer is in the booked seats and search for the seat
        int seatno = 0;
        for (int i = 0; i < bookedSeats.size(); i++) {
            if (bookedSeats.get(i) == seat) {
                seatno = bookedSeats.get(i);
            }
        }

        // Remove the seat from the booked seats
        bookedSeats.remove(seatno);

        // We then move the first person in the waiting list to the booked seats
        if (!waitingList.isEmpty()) {
            String[] customer = waitingList.poll().split(":");
            bookedSeats.push(Integer.parseInt(customer[1]));
        }
    }

    // Display the booked and waiting list
    public void displayStatus() {
        System.out.println("Booked Seats: " + bookedSeats);
        System.out.println("Waiting List: " + waitingList);
    }

    public static void main(String[] args){
        StackQueueADT bookingSystem = new StackQueueADT();
        bookingSystem.bookSeat("Kat Larssen", 983);
        bookingSystem.bookSeat("Lidia Holloway", 2818);
        bookingSystem.bookSeat("Lynne Robins", 1932);
        bookingSystem.bookSeat("Megan Bowen", 421);
        bookingSystem.bookSeat("Linda Sherman", 1452);


        bookingSystem.displayStatus();

        System.out.println("=====================================");
        bookingSystem.cancelBooking(983);
        bookingSystem.displayStatus();
    }
}
