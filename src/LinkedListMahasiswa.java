public class LinkedListMahasiswa {
    private Node head;

    public LinkedListMahasiswa() {
        head = null;
    }

    // Menambahkan mahasiswa baru di akhir list
    public void tambahMahasiswa(String nim, String nama, int nilai) {
        Node baru = new Node(nim, nama, nilai);
        if (head == null) {
            head = baru;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(baru);
    }

    // Menghapus mahasiswa berdasarkan NIM
    public boolean hapusMahasiswa(String nim) {
        if (head == null) {
            return false;
        }
        if (head.getNim().equals(nim)) {
            head = head.getNext();
            return true;
        }
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getNim().equals(nim)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Mengupdate nilai mahasiswa berdasarkan NIM
    public boolean updateNilai(String nim, int nilaiBaru) {
        Node current = head;
        while (current != null) {
            if (current.getNim().equals(nim)) {
                current.setNilai(nilaiBaru);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Menampilkan seluruh daftar mahasiswa
    public void tampilkanMahasiswa() {
        if (head == null) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }
        System.out.println("Daftar Mahasiswa:");
        Node current = head;
        int nomor = 1;
        while (current != null) {
            System.out.println(nomor + ". NIM: " + current.getNim() + ", Nama: " + current.getNama() + ", Nilai: " + current.getNilai());
            current = current.getNext();
            nomor++;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
