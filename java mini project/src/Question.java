import java.util.ArrayList;
import java.util.List;

/**
 * Represents a single multiple-choice question in the quiz.
 * Contains the question text, options, and the correct answer.
 */
public class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;
    private String explanation;

    /**
     * Constructor for creating a new question.
     *
     * @param questionText The text of the question
     * @param options List of possible answers (A, B, C, D, etc.)
     * @param correctAnswerIndex Index of the correct answer (0-based)
     * @param explanation Explanation for the correct answer
     */
    public Question(String questionText, List<String> options, int correctAnswerIndex, String explanation) {
        this.questionText = questionText;
        this.options = new ArrayList<>(options);
        this.correctAnswerIndex = correctAnswerIndex;
        this.explanation = explanation;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return new ArrayList<>(options);
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getNumberOfOptions() {
        return options.size();
    }

    /**
     * Checks if the given answer index is correct.
     *
     * @param answerIndex The index of the user's answer (0-based)
     * @return true if the answer is correct, false otherwise
     */
    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    /**
     * Returns the correct answer text.
     *
     * @return The correct answer as a string
     */
    public String getCorrectAnswer() {
        return options.get(correctAnswerIndex);
    }

    /**
     * Returns the user's answer text.
     *
     * @param answerIndex The index of the user's answer
     * @return The user's answer as a string
     */
    public String getUserAnswer(int answerIndex) {
        if (answerIndex < 0 || answerIndex >= options.size()) {
            return "Invalid";
        }
        return options.get(answerIndex);
    }
}
