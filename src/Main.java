
public class Main {

    public static void main(String[] args) {

        HangManHelper hangManHelper = new HangManHelper();
        hangManHelper.setMovieInUnderscores(hangManHelper.movieTitleFormatted());
        System.out.println("--- H A N G M A N - Guess the Movie Game ---");
        System.out.println("***Answer: " + hangManHelper.getMovieString() + " ***\n");

        while (!hangManHelper.conditionToLoop1() && (hangManHelper.getWrongGuesses().size() < 10)) {
            System.out.println("You are guessing: " + hangManHelper.getMovieInUnderscores().toString().replace(",", "").replace("[", "").replace("]", ""));
            System.out.println("You have guessed (" + hangManHelper.getAccumulatorOfGuesses().size() + ")" + " Wrong letters: " + hangManHelper.getWrongGuesses().toString().replace(",", "").replace("[", "").replace("]", ""));
            System.out.println("Guess a letter: ");
            hangManHelper.comparator();
            System.out.println("\n");
        }

        if (hangManHelper.isMovieTitleIsComplete()) {
            System.out.println("You Win!\n You have guessed '" + hangManHelper.getMovieString() + "' correctly.");
        }

        if (hangManHelper.getWrongGuesses().size() == 10) {
            System.out.println("GAME OVER\n You've ran out of tries.");
        }

    }

}
