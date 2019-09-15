import java.io.File;

public class Main {
    private static long folderSize(File folder) {
        long folderSize = 0;
        if (folder.isDirectory()) {
            for (File file: folder.listFiles()) {
                if (file.isFile()) {
                    folderSize += file.length();
                } else {
                    folderSize += folderSize(file);
                }
            }
        }
        return folderSize;
    }

    public static String getFolderSizeBytes(File folder) {
        return folderSize(folder) + " bytes";
    }

    public static String getFolderSizeKiloBytes(File folder) {
        return String.format("%.2f", (double) folderSize(folder) / 1024) + " kb";
    }

    public static String getFolderSizeMegaBytes(File folder) {
        return String.format("%.2f", (double) folderSize(folder) / (1024 * 1024)) + " mb";
    }

    public static String getFolderSizeGigaBytes(File folder) {
        return String.format("%.2f", (double) folderSize(folder) / (1024 * 1024 * 1024)) + " gb";
    }

    public static void main(String[] args) {
        File folder = new File("out");
        System.out.println(getFolderSizeBytes(folder));
        System.out.println(getFolderSizeKiloBytes(folder));
        System.out.println(getFolderSizeMegaBytes(folder));
        System.out.println(getFolderSizeGigaBytes(folder));
    }
}
