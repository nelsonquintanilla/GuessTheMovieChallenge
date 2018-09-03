import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangManHelper {

    private MovieManager mMovieManager = new MovieManager();
    private List<Character> mMovieLettersInCharacterList = new ArrayList<>();
    private List<Character> mMovieInUnderscores = new ArrayList<>();
    private List<Character> mAccumulatorOfGuesses = new ArrayList<>();
    private String mMovieString;
    private List<Character> mWrongGuesses = new ArrayList<>();
    private boolean mMovieTitleIsComplete = false;

    public boolean isMovieTitleIsComplete() {
        return mMovieTitleIsComplete;
    }

    public void setMovieInUnderscores(List<Character> movieInUnderscores) {
        this.mMovieInUnderscores = movieInUnderscores;
    }

    public List<Character> getMovieInUnderscores() {
        return mMovieInUnderscores;
    }

    public String getMovieString() {
        return mMovieString;
    }

    public List<Character> getAccumulatorOfGuesses() {
        return mAccumulatorOfGuesses;
    }

    public List<Character> getWrongGuesses() {
        return mWrongGuesses;
    }

    /**
     * Adds each letter of the movie title randomly selected as an element in an array.
     *
     * @return array in which each element is a letter from the movie title (a List<Character>)
     */
    private List<Character> lettersOfMovieIntoArrayList() {
        mMovieString = mMovieManager.randomlyPickMovie();
        char[] letter = mMovieString.toCharArray();
        for (char aLetter : letter) {
            mMovieLettersInCharacterList.add(aLetter);
        }
        return mMovieLettersInCharacterList;
    }

    /**
     * Loops over each letter of the movie title and substitutes them for underscores.
     *
     * @return array of underscores substituting the letters of the movie title (a List<Character>)
     */
    public List<Character> movieTitleFormatted() {
        mMovieLettersInCharacterList = lettersOfMovieIntoArrayList();
        for (Character character : mMovieLettersInCharacterList) {
            if (character == ' ') {
                mMovieInUnderscores.add(' ');
            } else {
                mMovieInUnderscores.add('_');
            }
        }
        return mMovieInUnderscores;
    }

    /**
     * Takes a character as an user's input and converts it to lower case.
     *
     * @return character in lower case (a char)
     */
    private char singleGuess() {
        Scanner input = new Scanner(System.in);
        String guessString = input.next();
        return guessString.toLowerCase().charAt(0);
    }

    /**
     * Loops over each letter of the movie title in the mMovieLettersInCharacterList array and compares it with
     * the user's guess. If the guess matches with any of the letters in the title it will remove the underscore
     * and display the letter in it's place in the mMovieInUnderscores array.
     *
     * It also adds the guess in the mWrongGuesses array if the guess doesn't match any letter with the movie title,
     * but if it matches and the user hasn't entered the same guess previously, it will add the guess in the
     * mAccumulatorOfGuesses array.
     *
     * @return updated array with underscores where the user hasn't guessed letters yet (a List<Character>)
     */
    public List<Character> comparator() {
        char guessChar = singleGuess();
        boolean checker = false;
        for (int i = 0; i < mMovieLettersInCharacterList.size(); i++) {
            if (mMovieLettersInCharacterList.get(i) == guessChar) {
                mMovieInUnderscores.remove(i);
                mMovieInUnderscores.add(i, guessChar);
                checker = true;
            }
        }
        if (!checker) {
            mWrongGuesses.add(guessChar);
        }
        if (checker && !mAccumulatorOfGuesses.contains(guessChar)) {
            mAccumulatorOfGuesses.add(guessChar);
        }
        return mMovieInUnderscores;
    }

    /**
     * Loops over each letter in the mMovieLettersInCharacterList array and compares it with the corresponding
     * elements in the mMovieInUnderscores array. If all the elements in both arrays match, it means that the user
     * has guessed all the letters in the movie title.
     *
     * @return true or false (a boolean)
     */
    public boolean conditionToLoop1() {
        for (int i = 0; i < mMovieLettersInCharacterList.size(); i++) {
            if (mMovieLettersInCharacterList.get(i) != mMovieInUnderscores.get(i)) {
                return false;
            }
        }
        mMovieTitleIsComplete = true;
        return true;
    }

}
