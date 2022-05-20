import java.io.*;

public class Main {
    public static void main(String[] args) {
        String title = "Game of thrones";
        String director = "David Benioff";
        String[] actors = {"Emilia Clarke","Kit Harington","Sophie Turner","Maisie Williams","Sean Bean","Lena Headey","Peter Dinklage","Nikolaj Coster-Waldau"};

        Movie gameOfThrones = new Movie(title, director, actors);
        System.out.println("Movie from RAM: ");
        System.out.println(gameOfThrones);
        System.out.println();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("movie.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write objects to file
            objectOutputStream.writeObject(gameOfThrones);

            objectOutputStream.close();
            fileOutputStream.close();

           FileInputStream fileInputStream = new FileInputStream("movie.txt");
           ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Read objects
           Movie gameOfThronesFromFile = (Movie) objectInputStream.readObject();

           System.out.println("Movie from file to RAM: ");
           System.out.println(gameOfThronesFromFile.toString());

            objectInputStream.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");

        } catch (ClassNotFoundException e) {
            System.out.println("The class is not found");
        }
    }
}