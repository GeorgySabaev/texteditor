package editor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        // Файл file.txt дважды редактируется, сохраняясь перед каждым изменением
        // А затем дважды откатывает состояние на одно сохранение назад.
        Path path = Paths.get("file.txt");
        TextFile file = new TextFile(path);
        BackupStack backupStack = new BackupStack();
        file.setText("This is the original text of this file."); // Исходный текст.
        backupStack.save(file);
        file.setText("This is the modified text of this file.");
        backupStack.save(file);
        file.setText("This is the final text of this file.");
        backupStack.load(file);
        backupStack.load(file);
    }
}
