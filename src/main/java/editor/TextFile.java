package editor;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class TextFile {
    @Getter
    Path path;
    Backup getBackup() throws IOException {
        return new Backup(getText());
    }
    void loadBackup(Backup backup) throws IOException {
        setText(backup.getText());
    }
    public void setText(String text) throws IOException {
        Files.writeString(path, text);
        System.out.println("// TextFile: File has been modified:");
        System.out.println(text);
    }
    public String getText() throws IOException {
        return Files.readString(path);
    }
    public TextFile(Path path){
        this.path = path;
    }
}
