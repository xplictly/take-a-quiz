/**
 * Represents the result of a single quiz attempt.
 * Stores information about user performance on the quiz.
 */
public class QuizResult {
    private String playerName;
    private int totalQuestions;
    private int correctAnswers;
    private int incorrectAnswers;
    private long timeTaken; // in seconds

    /**
     * Constructor for creating a quiz result.
     *
     * @param playerName Name of the player who took the quiz
     * @param totalQuestions Total number of questions in the quiz
     * @param correctAnswers Number of correct answers
     * @param timeTaken Time taken to complete the quiz in seconds
     */
    public QuizResult(String playerName, int totalQuestions, int correctAnswers, long timeTaken) {
        this.playerName = playerName;
        this.totalQuestions = totalQuestions;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = totalQuestions - correctAnswers;
        this.timeTaken = timeTaken;
    }

    // Getters
    public String getPlayerName() {
        return playerName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    /**
     * Calculates the percentage score.
     *
     * @return Percentage score (0-100)
     */
    public double getPercentageScore() {
        if (totalQuestions == 0) {
            return 0;
        }
        return (correctAnswers * 100.0) / totalQuestions;
    }

    /**
     * Calculates the letter grade based on percentage score.
     *
     * @return Letter grade (A, B, C, D, F)
     */
    public String getLetterGrade() {
        double percentage = getPercentageScore();
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Returns a formatted string representation of the quiz result.
     *
     * @return Formatted result string
     */
    @Override
    public String toString() {
        return String.format(
                "╔══════════════════════════════════════╗\n" +
                "║        QUIZ RESULT SUMMARY            ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ Player:       %-24s║\n" +
                "║ Correct:      %2d/%d                    ║\n" +
                "║ Incorrect:    %2d/%d                    ║\n" +
                "║ Percentage:   %.2f%%                 ║\n" +
                "║ Grade:        %s                     ║\n" +
                "║ Time Taken:   %d seconds              ║\n" +
                "╚══════════════════════════════════════╝",
                playerName, correctAnswers, totalQuestions,
                incorrectAnswers, totalQuestions,
                getPercentageScore(), getLetterGrade(), timeTaken
        );
    }
}
