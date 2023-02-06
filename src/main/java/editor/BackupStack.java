package editor;

import java.io.IOException;
import java.util.Stack;

public class BackupStack {
    Stack<Backup> backups = new Stack<>();

    public void save(TextFile file) throws IOException {
        System.out.println("// BackupStack: backup saved.");
        backups.push(file.getBackup());
    }

    public void load(TextFile file) throws IOException {
        System.out.println("// BackupStack: backup loaded.");
        file.loadBackup(backups.peek());
        backups.pop();
    }
}
