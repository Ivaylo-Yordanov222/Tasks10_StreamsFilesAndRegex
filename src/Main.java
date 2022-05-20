import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directoryName = sc.nextLine();
        List<String> allFiles = GetAllFilesInAllDirectories(directoryName,directoryName, new ArrayList<>());
        allFiles.forEach(System.out::println);
    }
    public static List<String> GetAllFilesInAllDirectories(String directoryName,String mainDirectoryName, List<String> relativePaths) {
        File mainDirectory = new File(mainDirectoryName);
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        if (fList != null){
            for (File file : fList) {
                URI fileURI = file.toURI();
                URI mainDirectoryURI = mainDirectory.toURI();
                URI relativePathURI = mainDirectoryURI.relativize(fileURI);
                String relativePath = relativePathURI.getPath();
                if (file.isFile()) {
                    relativePaths.add(relativePath);
                } else if (file.isDirectory()) {
                    relativePaths.add(relativePath);
                    GetAllFilesInAllDirectories(file.getAbsolutePath(),mainDirectoryName, relativePaths);
                }
            }
        }
        return  relativePaths;
    }
}