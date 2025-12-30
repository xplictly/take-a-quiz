import java.time.Instant;
import java.util.*;

/**
 * Main Quiz Engine that handles quiz logic, question management, and score calculation.
 * Provides an interactive interface for users to take quizzes.
 */
public class QuizEngine {
    private List<Question> questions;
    private List<Integer> userAnswers;
    private int currentQuestionIndex;
    private boolean quizInProgress;
    private long startTime;
    private Scanner scanner;

    /**
     * Constructor to initialize the quiz engine.
     */
    public QuizEngine() {
        this.questions = new ArrayList<>();
        this.userAnswers = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.quizInProgress = false;
        this.scanner = null; // Will use System.in directly through a shared scanner
    }

    /**
     * Constructor to initialize the quiz engine with an external scanner.
     * 
     * @param scanner The Scanner to use for input
     */
    public QuizEngine(Scanner scanner) {
        this.questions = new ArrayList<>();
        this.userAnswers = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.quizInProgress = false;
        this.scanner = scanner;
    }

    /**
     * Adds a question to the quiz.
     * Developer-friendly method for creating quizzes.
     *
     * @param question The Question object to add
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Adds multiple questions at once.
     *
     * @param questions List of Question objects
     */
    public void addQuestions(List<Question> questions) {
        this.questions.addAll(questions);
    }

    /**
     * Starts the quiz and begins asking questions.
     */
    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("\n❌ Error: No questions available. Please add questions to the quiz.");
            return;
        }

        quizInProgress = true;
        currentQuestionIndex = 0;
        userAnswers.clear();
        startTime = Instant.now().getEpochSecond();

        while (quizInProgress && currentQuestionIndex < questions.size()) {
            askQuestion(questions.get(currentQuestionIndex));
            currentQuestionIndex++;
        }

        quizInProgress = false;
    }

    /**
     * Displays a question and gets the user's answer.
     *
     * @param question The Question to display
     */
    private void askQuestion(Question question) {
        GameUI.displayQuestion(question.getQuestionText(), currentQuestionIndex + 1, questions.size());
        
        List<String> options = question.getOptions();
        GameUI.displayAnswerOptions(options);

        int userAnswer = getUserInput(question.getNumberOfOptions());
        userAnswers.add(userAnswer - 1); // Convert to 0-based index

        // Display immediate feedback with game UI
        if (question.isCorrect(userAnswer - 1)) {
            GameUI.showCorrectAnswer();
        } else {
            GameUI.showIncorrectAnswer();
            System.out.println("  " + "Correct Answer: " + question.getCorrectAnswer());
        }
        System.out.println("  " + "💡 " + question.getExplanation());
        
        GameUI.pause(1500);
    }

    /**
     * Gets valid user input for answer selection.
     *
     * @param maxOptions Maximum valid option number
     * @return The user's selected option number (1-based)
     */
    private int getUserInput(int maxOptions) {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        
        int choice = -1;
        while (choice < 1 || choice > maxOptions) {
            try {
                System.out.print("Your answer (1-" + maxOptions + "): ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("⚠️  Please enter a valid number.");
                    continue;
                }

                choice = Integer.parseInt(input);
                if (choice < 1 || choice > maxOptions) {
                    System.out.println("⚠️  Please enter a number between 1 and " + maxOptions + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Invalid input! Please enter a number.");
            } catch (NoSuchElementException e) {
                System.out.println("⚠️  Input ended unexpectedly. Using default answer.");
                choice = 1; // Default to first option
            }
        }
        return choice;
    }

    /**
     * Calculates and returns the quiz result.
     *
     * @param playerName Name of the player
     * @return QuizResult object containing the player's performance
     */
    public QuizResult calculateResults(String playerName) {
        int correctCount = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (questions.get(i).isCorrect(userAnswers.get(i))) {
                correctCount++;
            }
        }

        long endTime = Instant.now().getEpochSecond();
        long timeTaken = endTime - startTime;

        return new QuizResult(playerName, questions.size(), correctCount, timeTaken);
    }

    /**
     * Displays the detailed results of the quiz.
     *
     * @param result The QuizResult to display
     */
    public void displayResults(QuizResult result) {
        GameUI.showVictoryAnimation();
        GameUI.displayResultCard(
            result.getPlayerName(),
            result.getCorrectAnswers(),
            result.getTotalQuestions(),
            result.getPercentageScore(),
            result.getLetterGrade(),
            result.getTimeTaken()
        );
        displayDetailedAnswers();
    }

    /**
     * Displays a detailed breakdown of each answer.
     */
    private void displayDetailedAnswers() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     DETAILED ANSWER BREAKDOWN        ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        for (int i = 0; i < userAnswers.size(); i++) {
            Question question = questions.get(i);
            int userAnswer = userAnswers.get(i);
            boolean isCorrect = question.isCorrect(userAnswer);

            System.out.printf("Q%d: %s%n", i + 1, question.getQuestionText());
            System.out.printf("   Your answer: %s %s%n",
                    question.getUserAnswer(userAnswer),
                    isCorrect ? "✅" : "❌");

            if (!isCorrect) {
                System.out.printf("   Correct answer: %s%n", question.getCorrectAnswer());
            }
            System.out.println();
        }
    }

    /**
     * Returns the total number of questions in the quiz.
     *
     * @return Number of questions
     */
    public int getTotalQuestions() {
        return questions.size();
    }

    /**
     * Gets the maximum number of options across all questions.
     *
     * @return Maximum number of options
     */
    private int getMaxOptions() {
        if (questions.isEmpty()) {
            return 4;
        }
        return questions.stream()
                .mapToInt(Question::getNumberOfOptions)
                .max()
                .orElse(4);
    }

    /**
     * Clears the quiz and resets for a new attempt.
     */
    public void resetQuiz() {
        userAnswers.clear();
        currentQuestionIndex = 0;
        quizInProgress = false;
    }

    /**
     * Closes the scanner resource (only if it was created internally).
     */
    public void closeScanner() {
        // Don't close scanner if it was provided externally
        // This prevents closing System.in shared by main application
    }
}
