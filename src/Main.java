import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static QueueSystem queueSystem = new QueueSystem();
    private static TextEditor textEditor = new TextEditor();
    private static LinkedListMahasiswa listMahasiswa = new LinkedListMahasiswa();

    public static void main(String[] args) {
        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenuUtama();
            int pilihan = bacaPilihan();
            switch (pilihan) {
                case 1:
                    menuAntrean();
                    break;
                case 2:
                    menuEditorTeks();
                    break;
                case 3:
                    menuDataMahasiswa();
                    break;
                case 0:
                    berjalan = false;
                    System.out.println("Program selesai. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
                    break;
            }
        }
        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("=== MENU UTAMA ===");
        System.out.println("1. Sistem Manajemen Antrean (Queue)");
        System.out.println("2. Fitur Undo/Redo Editor Teks (Stack)");
        System.out.println("3. Manajemen Data Mahasiswa (Linked List)");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static int bacaPilihan() {
        try {
            int pilihan = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();
            return pilihan;
        } catch (NumberFormatException e) {
            System.out.println();
            return -1;
        }
    }

    private static void menuAntrean() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("--- Sistem Manajemen Antrean (Queue) ---");
            System.out.println("1. Tambah pelanggan");
            System.out.println("2. Layani pelanggan");
            System.out.println("3. Tampilkan antrean");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("Pilih menu: ");
            int pilihan = bacaPilihan();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine().trim();
                    queueSystem.tambahPelanggan(new Customer(nama));
                    System.out.println(nama + " ditambahkan ke antrean.\n");
                    break;
                case 2:
                    Customer dilayani = queueSystem.layaniPelanggan();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan: " + dilayani.getNama() + "\n");
                    } else {
                        System.out.println("Antrean kosong.\n");
                    }
                    break;
                case 3:
                    queueSystem.tampilkanAntrean();
                    System.out.println();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
                    break;
            }
        }
    }

    private static void menuEditorTeks() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("--- Fitur Undo/Redo Editor Teks (Stack) ---");
            System.out.println("1. Tambah teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan teks saat ini");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("Pilih menu: ");
            int pilihan = bacaPilihan();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks baru: ");
                    String teks = scanner.nextLine();
                    textEditor.tambahTeks(teks);
                    System.out.println("Teks berhasil ditambahkan.\n");
                    break;
                case 2:
                    textEditor.undo();
                    System.out.println();
                    break;
                case 3:
                    textEditor.redo();
                    System.out.println();
                    break;
                case 4:
                    textEditor.tampilkanTeksSaatIni();
                    System.out.println();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
                    break;
            }
        }
    }

    private static void menuDataMahasiswa() {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("--- Manajemen Data Mahasiswa (Linked List) ---");
            System.out.println("1. Tambah mahasiswa");
            System.out.println("2. Hapus mahasiswa");
            System.out.println("3. Update nilai mahasiswa");
            System.out.println("4. Tampilkan daftar mahasiswa");
            System.out.println("0. Kembali ke menu utama");
            System.out.print("Pilih menu: ");
            int pilihan = bacaPilihan();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim1 = scanner.nextLine().trim();
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine().trim();
                    System.out.print("Masukkan nilai: ");
                    int nilai = bacaAngka();
                    listMahasiswa.tambahMahasiswa(nim1, nama, nilai);
                    System.out.println("Mahasiswa berhasil ditambahkan.\n");
                    break;
                case 2:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nim2 = scanner.nextLine().trim();
                    boolean berhasilHapus = listMahasiswa.hapusMahasiswa(nim2);
                    System.out.println(berhasilHapus ? "Mahasiswa berhasil dihapus.\n" : "NIM tidak ditemukan.\n");
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang akan diupdate: ");
                    String nim3 = scanner.nextLine().trim();
                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = bacaAngka();
                    boolean berhasilUpdate = listMahasiswa.updateNilai(nim3, nilaiBaru);
                    System.out.println(berhasilUpdate ? "Nilai berhasil diupdate.\n" : "NIM tidak ditemukan.\n");
                    break;
                case 4:
                    listMahasiswa.tampilkanMahasiswa();
                    System.out.println();
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.\n");
                    break;
            }
        }
    }

    private static int bacaAngka() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Input tidak valid, dianggap 0.");
            return 0;
        }
    }
}
