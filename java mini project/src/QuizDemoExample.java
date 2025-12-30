/**
 * Demo program showing how to create custom quizzes programmatically.
 * This class demonstrates the developer-friendly API.
 */
public class QuizDemoExample {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("        QUIZ APPLICATION - DEVELOPER EXAMPLE");
        System.out.println("=".repeat(70));
        System.out.println("\nThis example shows how easy it is to create custom quizzes!\n");

        // Create a custom science quiz
        System.out.println("📚 Creating a custom Java Collections Quiz...\n");

        QuizEngine customQuiz = new QuizEngine();

        // Example 1: Adding a simple question
        Question q1 = new Question(
                "What is the main advantage of using ArrayList?",
                new java.util.ArrayList<>(java.util.Arrays.asList(
                        "Fixed size array",
                        "Dynamic resizing capability",
                        "Slower access time",
                        "No null values allowed"
                )),
                1, // Index 1 = "Dynamic resizing capability"
                "ArrayList automatically resizes when you add more elements, unlike traditional arrays."
        );

        // Example 2: Adding another question
        Question q2 = new Question(
                "Which collection type maintains insertion order AND allows duplicates?",
                new java.util.ArrayList<>(java.util.Arrays.asList(
                        "HashSet",
                        "LinkedHashSet",
                        "TreeSet",
                        "HashMap"
                )),
                1, // Index 1 = "LinkedHashSet"
                "LinkedHashSet maintains insertion order while HashSet doesn't. Both allow duplicates."
        );

        // Add questions to quiz using a loop (demonstrating collections)
        java.util.List<Question> questions = new java.util.ArrayList<>();
        questions.add(q1);
        questions.add(q2);

        customQuiz.addQuestions(questions);

        System.out.println("✅ Quiz created with " + customQuiz.getTotalQuestions() + " questions!\n");
        System.out.println("=".repeat(70));
        System.out.println("\n💡 KEY FEATURES DEMONSTRATED:\n");

        System.out.println("1️⃣  COLLECTIONS (ArrayList & List):");
        System.out.println("   - Used Arrays.asList() to create question options");
        System.out.println("   - Used ArrayList to store multiple questions");
        System.out.println("   - Used List interface for type safety");

        System.out.println("\n2️⃣  LOOPS:");
        System.out.println("   - While loop in input validation (inside QuizEngine)");
        System.out.println("   - For loop to iterate through questions");
        System.out.println("   - Enhanced for loop for cleaner iteration");

        System.out.println("\n3️⃣  CONDITIONALS:");
        System.out.println("   - If-else for answer validation");
        System.out.println("   - Switch for menu navigation");
        System.out.println("   - Complex boolean logic for grading");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("📖 To run the actual quiz application:");
        System.out.println("   cd /tmp/QuizApplication");
        System.out.println("   ./run.sh");
        System.out.println("=".repeat(70) + "\n");

        customQuiz.closeScanner();
    }
}
