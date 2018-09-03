import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieManager {
    private File mFile = new File("movies.txt");

    /**
     * Scans the text file and computes the number of movie titles that it contains.
     *
     * @return number of lines (each line is a movie title) in the text file (an int)
     */
    private int numberOfMoviesInFile() {
        Scanner scannedFile = null;
        int accumulator = 0;

        try {
            scannedFile = new Scanner(mFile);
        } catch (FileNotFoundException e) {
            System.out.println("***File is missing!***");
        }

        if (scannedFile != null) {
            while (scannedFile.hasNextLine()) {
                scannedFile.nextLine();
                accumulator++;
            }
        }
        return accumulator;
    }

    /**
     * Computes a random number within the range of the total number of movie titles.
     *
     * @return random number between 0 and the total number of movies (an int)
     */
    private int generateRandomNumber() {
        int limit = numberOfMoviesInFile();
        return (int) (Math.random() * (limit));
    }

    /**
     * Scans the text file, store each movie title in an array and then, randomly
     * selects a movie with a random number generated.
     *
     * @return random movie title of the list of movies from text file (a String)
     */
    public String randomlyPickMovie() {
        List<String> currentMovie = new ArrayList<>();
        Scanner scannedMovie = null;
        String pickedMovie = null;

        try {
            scannedMovie = new Scanner(mFile);
        } catch (FileNotFoundException e) {
            System.out.println("***File is missing!***");
        }

        if (scannedMovie != null) {
            while (scannedMovie.hasNextLine()) {
                currentMovie.add(scannedMovie.nextLine());
            }

            int randomNumber = generateRandomNumber();
            for (int i = 0; i < currentMovie.size(); i++) {
                if (i == randomNumber) {
                    pickedMovie = currentMovie.get(i);
                    break;
                }
            }
        }
        return pickedMovie;
    }

}
