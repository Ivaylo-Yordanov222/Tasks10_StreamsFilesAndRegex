import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directoryName = sc.nextLine();
        List<File> allFiles = GetAllFilesInAllDirectories(directoryName, new ArrayList<>());
        allFiles.forEach(System.out::println);
    }
    public static List<File> GetAllFilesInAllDirectories(String directoryName, List<File> files) {
        File directory = new File(directoryName);

        // Get all files from a directory.
        File[] fList = directory.listFiles();
        if (fList != null){
            for (File file : fList) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    GetAllFilesInAllDirectories(file.getAbsolutePath(), files);
                }
            }
        }
        return  files;
    }
}