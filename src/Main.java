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

    // ========================= QUEUE =========================

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

                    long startEnqueue = System.nanoTime();
                    queueSystem.tambahPelanggan(new Customer(nama));
                    long endEnqueue = System.nanoTime();

                    System.out.println(nama + " ditambahkan ke antrean.");
                    System.out.println("Waktu Enqueue : " + (endEnqueue - startEnqueue) + " ns\n");
                    break;

                case 2:
                    long startDequeue = System.nanoTime();
                    Customer dilayani = queueSystem.layaniPelanggan();
                    long endDequeue = System.nanoTime();

                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan: " + dilayani.getNama());
                    } else {
                        System.out.println("Antrean kosong.");
                    }

                    System.out.println("Waktu Dequeue : " + (endDequeue - startDequeue) + " ns\n");
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

    // ========================= STACK =========================

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

                    long startPush = System.nanoTime();
                    textEditor.tambahTeks(teks);
                    long endPush = System.nanoTime();

                    System.out.println("Teks berhasil ditambahkan.");
                    System.out.println("Waktu Push : " + (endPush - startPush) + " ns\n");
                    break;

                case 2:
                    long startUndo = System.nanoTime();
                    textEditor.undo();
                    long endUndo = System.nanoTime();

                    System.out.println("Waktu Undo : " + (endUndo - startUndo) + " ns\n");
                    break;

                case 3:
                    long startRedo = System.nanoTime();
                    textEditor.redo();
                    long endRedo = System.nanoTime();

                    System.out.println("Waktu Redo : " + (endRedo - startRedo) + " ns\n");
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

    // ====================== LINKED LIST ======================

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

                    long startInsert = System.nanoTime();
                    listMahasiswa.tambahMahasiswa(nim1, nama, nilai);
                    long endInsert = System.nanoTime();

                    System.out.println("Mahasiswa berhasil ditambahkan.");
                    System.out.println("Waktu Insert : " + (endInsert - startInsert) + " ns\n");
                    break;

                case 2:
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String nim2 = scanner.nextLine().trim();

                    long startDelete = System.nanoTime();
                    boolean berhasilHapus = listMahasiswa.hapusMahasiswa(nim2);
                    long endDelete = System.nanoTime();

                    if (berhasilHapus) {
                        System.out.println("Mahasiswa berhasil dihapus.");
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }

                    System.out.println("Waktu Delete : " + (endDelete - startDelete) + " ns\n");
                    break;

                case 3:
                    System.out.print("Masukkan NIM yang akan diupdate: ");
                    String nim3 = scanner.nextLine().trim();

                    System.out.print("Masukkan nilai baru: ");
                    int nilaiBaru = bacaAngka();

                    long startUpdate = System.nanoTime();
                    boolean berhasilUpdate = listMahasiswa.updateNilai(nim3, nilaiBaru);
                    long endUpdate = System.nanoTime();

                    if (berhasilUpdate) {
                        System.out.println("Nilai berhasil diupdate.");
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }

                    System.out.println("Waktu Update : " + (endUpdate - startUpdate) + " ns\n");
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