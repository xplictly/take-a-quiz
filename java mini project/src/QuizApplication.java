import java.util.*;

/**
 * Main application entry point for the Quiz Application.
 * Provides an interactive menu for users to select and take quizzes.
 * Demonstrates interactive design for both users and developers.
 */
public class QuizApplication {
    private final Scanner scanner;
    private final List<QuizResult> allResults;

    /**
     * Constructor to initialize the application.
     */
    public QuizApplication() {
        this.scanner = new Scanner(System.in);
        this.allResults = new ArrayList<>();
    }

    /**
     * Starts the main application loop.
     */
    public void run() {
        GameUI.displaySplash();

        boolean running = true;
        while (running) {
            GameUI.displayMainMenu();
            int choice = getMenuChoice(1, 4);

            switch (choice) {
                case 1:
                    selectAndTakeQuiz();
                    break;
                case 2:
                    viewAllResults();
                    break;
                case 3:
                    GameUI.displayCodex();
                    pause();
                    break;
                case 4:
                    running = false;
                    GameUI.displayExitScreen();
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Pauses execution and waits for user input.
     */
    private void pause() {
        System.out.print("\n  Press ENTER to continue...");
        scanner.nextLine();
    }

    /**
     * Displays available quizzes and lets the user select one.
     */
    private void selectAndTakeQuiz() {
        GameUI.displayQuestSelection();
        int quizChoice = getMenuChoice(1, 5);
        QuizEngine selectedQuiz = null;

        switch (quizChoice) {
            case 1 -> selectedQuiz = QuizRepository.createBeginnerQuiz(scanner);
            case 2 -> selectedQuiz = QuizRepository.createProgrammingQuiz(scanner);
            case 3 -> selectedQuiz = QuizRepository.createAdvancedQuiz(scanner);
            case 4 -> selectedQuiz = QuizRepository.createOOPQuiz(scanner);
            case 5 -> { return; }
        }

        if (selectedQuiz != null) {
            takeQuiz(selectedQuiz);
        }
    }

    /**
     * Handles the quiz-taking flow.
     *
     * @param quiz The QuizEngine instance to run
     */
    private void takeQuiz(QuizEngine quiz) {
        System.out.print("\n📝 Enter your name: ");
        String playerName = "Anonymous Adventurer";
        try {
            playerName = scanner.nextLine().trim();
            if (playerName.isEmpty()) {
                playerName = "Anonymous Adventurer";
            }
        } catch (NoSuchElementException e) {
            // Input ended - use default name
        }

        // Start the quiz
        quiz.startQuiz();

        // Calculate and display results
        QuizResult result = quiz.calculateResults(playerName);
        allResults.add(result);

        quiz.displayResults(result);

        System.out.print("\n🔄 Would you like to try another quest? (yes/no): ");
        String response = "no";
        try {
            response = scanner.nextLine().trim().toLowerCase();
        } catch (NoSuchElementException e) {
            response = "no"; // Exit if input ends
        }
        
        if (response.equals("yes") || response.equals("y")) {
            selectAndTakeQuiz();
        }
    }

    /**
     * Displays all quiz results taken in this session.
     */
    private void viewAllResults() {
        if (allResults.isEmpty()) {
            GameUI.clearScreen();
            System.out.println("\n  ❌ No quest victories yet. Complete a quest to see your achievements!");
            pause();
            return;
        }
        
        int totalQuizzes = allResults.size();
        int totalCorrect = 0;
        int totalQuestions = 0;
        double totalPercentage = 0;

        for (QuizResult result : allResults) {
            totalCorrect += result.getCorrectAnswers();
            totalQuestions += result.getTotalQuestions();
            totalPercentage += result.getPercentageScore();
        }

        double averagePercentage = totalQuizzes > 0 ? totalPercentage / totalQuizzes : 0;

        GameUI.displayStatistics(totalQuizzes, totalCorrect, totalQuestions, averagePercentage);
        pause();
    }

    /**
     * Displays information about the application.
     */
    private void showAbout() {
        GameUI.displayCodex();
        pause();
    }

    /**
     * Gets valid menu choice from the user.
     *
     * @param min Minimum valid choice
     * @param max Maximum valid choice
     * @return User's menu choice
     */
    private int getMenuChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            try {
                System.out.print("  Enter your choice (" + min + "-" + max + "): ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("  ⚠️  Please enter a valid number.");
                    continue;
                }

                choice = Integer.parseInt(input);
                if (choice < min || choice > max) {
                    System.out.println("  ⚠️  Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("  ⚠️  Invalid input! Please enter a number.");
            } catch (NoSuchElementException e) {
                return min; // Default to first option on EOF
            }
        }
        return choice;
    }

    /**
     * Main method - entry point of the application.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        QuizApplication app = new QuizApplication();
        app.run();
    }
}
