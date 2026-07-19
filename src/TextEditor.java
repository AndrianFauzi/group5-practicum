import java.util.Stack;

/**
 * TextEditor - simulasi editor teks sederhana dengan fitur Undo/Redo.
 * Menggunakan dua Stack<String>: satu untuk menyimpan histori (undo),
 * satu lagi untuk menyimpan perubahan yang di-undo (redo).
 */
public class TextEditor {

    private String currentText;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    // Constructor: inisialisasi editor dengan teks kosong dan stack kosong
    public TextEditor() {
        this.currentText = "";
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    /**
     * Menambahkan teks baru ke teks yang sedang aktif.
     * Sebelum berubah, simpan kondisi lama ke undoStack.
     * redoStack dikosongkan karena histori redo jadi tidak valid
     * begitu ada perubahan baru.
     */
    public void tambahTeks(String teks) {
        undoStack.push(currentText);
        currentText = currentText + teks;
        redoStack.clear();
    }

    /**
     * Undo: mengembalikan teks ke kondisi sebelum perubahan terakhir.
     * Kondisi saat ini disimpan ke redoStack supaya bisa di-redo nanti.
     */
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada histori untuk di-undo.");
            return;
        }
        redoStack.push(currentText);
        currentText = undoStack.pop();
    }

    /**
     * Redo: mengembalikan perubahan yang sebelumnya di-undo.
     * Kondisi saat ini disimpan ke undoStack supaya masih bisa di-undo lagi.
     */
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada histori untuk di-redo.");
            return;
        }
        undoStack.push(currentText);
        currentText = redoStack.pop();
    }

    // Menampilkan teks yang sedang aktif saat ini
    public void tampilkanTeksSaatIni() {
        System.out.println("Teks saat ini: \"" + currentText + "\"");
    }

    // Getter untuk keperluan integrasi/testing tambahan jika diperlukan
    public String getCurrentText() {
        return currentText;
    }
}
