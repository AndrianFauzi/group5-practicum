import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueSystem {

    private Queue<Customer> queue = new LinkedList<>();

    public void enqueue(Customer customer) {
        queue.offer(customer);
        System.out.println(customer.getNama() + " masuk antrean.");
    }

    public Customer dequeue() {
        if(queue.isEmpty()) {
            System.out.println("Antrean kosong.");
            return null;
        }

        Customer customer = queue.poll();
        System.out.println(customer.getNama() + " telah dilayani.");
        return customer;
    }

    public void displayQueue() {
        if(queue.isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }

        System.out.println("===Daftar Antrean===");
        

        for(Customer c  : queue) {
            System.out.println(c);
        }
    }

    public boolean isEmpty()  {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public Customer peek() {
        return queue.peek();
    }
}
