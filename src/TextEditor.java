import java.util.Stack;

public class TextEditor {
    private String teksSaatIni;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        teksSaatIni = "";
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    // Menambahkan teks baru, menyimpan versi sebelumnya ke undoStack
    public void tambahTeks(String teksBaru) {
        undoStack.push(teksSaatIni);
        teksSaatIni = teksBaru;
        redoStack.clear();
    }

    // Mengembalikan ke kondisi teks sebelum perubahan terakhir
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Tidak ada histori untuk di-undo.");
            return;
        }
        redoStack.push(teksSaatIni);
        teksSaatIni = undoStack.pop();
    }

    // Mengembalikan perubahan yang telah di-undo
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Tidak ada histori untuk di-redo.");
            return;
        }
        undoStack.push(teksSaatIni);
        teksSaatIni = redoStack.pop();
    }

    // Menampilkan teks yang sedang aktif saat ini
    public void tampilkanTeksSaatIni() {
        System.out.println("Teks saat ini: \"" + teksSaatIni + "\"");
    }
}
