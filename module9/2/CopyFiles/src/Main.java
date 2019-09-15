import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    private static void copyFolder(File source, File target) throws IOException {
        if (source.isDirectory()) {
            File folder = new File(target, source.getName());
            File[] sourceFiles = source.listFiles();
            if (folder.mkdir() && sourceFiles != null) {
                for (File file: sourceFiles) {
                    if (file.isFile()) {
                        Files.copy(file.toPath(), new File(folder, file.getName()).toPath());
                    } else {
                        copyFolder(file, folder);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        File folderToCopy = new File("out");
        File newFolder = new File("data");
        copyFolder(folderToCopy, newFolder);
        System.out.println("Copying is completed");
    }
}
