// Plan Tikcet Booking SYstem with Waiting list
// Use a stack to manage the booked seats (last-in-first-out)
// Use a queue to manage the waiting list (first-in-first-out)
// Todo if a customer cancel a booking, the first customer in the waiting list will be moved to the booked seats

import java.util.Stack;
import java.util.Queue;

public class CustomerInfo{
    
}

public class StackQueueADT {
    // Stack to manage the booked seats
    private Stack<CustomerInfo> bookedSeats = new Stack<CustomerInfo>();
    // Queue to manage the waiting list
    private Queue<Custo> waitingList;

    // Functions
    // Book a seat
    // Join the waiting list if the seat is not available
    // Cancel a booking

    // Seats
    private String[] seats = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10"};

    private void bookSeat(String seat) {
        if (bookedSeats.size() < 10) {
            bookedSeats.push(seat);
            System.out.println()
        } else {
            waitingList.add(seat);
        }
    }
}
