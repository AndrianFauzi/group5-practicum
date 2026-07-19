import java.util.LinkedList;
import java.util.Queue;

public class QueueSystem {
    private Queue<Customer> antrean;

    public QueueSystem() {
        antrean = new LinkedList<>();
    }

    // Tambah pelanggan baru ke antrean (enqueue)
    public void tambahPelanggan(Customer pelanggan) {
        antrean.add(pelanggan);
    }

    // Layani pelanggan paling depan (dequeue)
    public Customer layaniPelanggan() {
        return antrean.poll();
    }

    // Tampilkan seluruh pelanggan yang masih dalam antrean
    public void tampilkanAntrean() {
        if (antrean.isEmpty()) {
            System.out.println("Antrean kosong.");
            return;
        }
        System.out.println("Pelanggan dalam antrean:");
        int nomor = 1;
        for (Customer pelanggan : antrean) {
            System.out.println(nomor + ". " + pelanggan.getNama());
            nomor++;
        }
    }

    public boolean isEmpty() {
        return antrean.isEmpty();
    }
}
