
/**
 * GameUI: Provides terminal game-like UI with animations, colors, and effects.
 * Makes the quiz application feel like a proper interactive game.
 */
public class GameUI {
    // ANSI Color codes
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    
    // Background colors
    private static final String BG_BLUE = "\u001B[44m";
    private static final String BG_GREEN = "\u001B[42m";
    private static final String BG_RED = "\u001B[41m";

    /**
     * Displays an animated game splash screen on startup.
     */
    public static void displaySplash() {
        clearScreen();
        
        System.out.println("\n\n");
        printAnimatedText("╔════════════════════════════════════════════════════════╗");
        printAnimatedText("║                                                        ║");
        printAnimatedText("║          " + BOLD + CYAN + "⚡ Q U I Z   C H A M P I O N ⚡" + RESET + "           ║");
        printAnimatedText("║                   " + YELLOW + "Your Quest Awaits!" + RESET + "              ║");
        printAnimatedText("║                                                        ║");
        printAnimatedText("╚════════════════════════════════════════════════════════╝");
        
        printLine();
        System.out.println("\n  " + CYAN + "Loading Quest Data..." + RESET);
        
        for (int i = 0; i < 3; i++) {
            System.out.print("  ");
            for (int j = 0; j <= 10; j++) {
                System.out.print("█");
                try { Thread.sleep(30); } catch (InterruptedException e) {}
            }
            System.out.print(" " + (i + 1) + "/3\n");
        }
        
        pause(500);
        System.out.println("\n  " + GREEN + "✓ Ready to begin your adventure!" + RESET);
        printLine();
        pause(1000);
    }

    /**
     * Displays the main menu with animated styling.
     */
    public static void displayMainMenu() {
        clearScreen();
        System.out.println("\n");
        
        printBox(new String[]{
            BOLD + CYAN + "═══════════════════════════════════════════════════════" + RESET,
            "                    " + YELLOW + "⚔️  MAIN QUEST MENU  ⚔️" + RESET,
            BOLD + CYAN + "═══════════════════════════════════════════════════════" + RESET
        });
        
        System.out.println("\n");
        printMenuOption(1, "🎯 START QUEST", "Begin a new quiz challenge");
        printMenuOption(2, "🏆 VIEW ACHIEVEMENTS", "Review your past victories");
        printMenuOption(3, "📖 CODEX", "Learn about this adventure");
        printMenuOption(4, "🚪 EXIT GAME", "Leave the arena");
        
        System.out.println("\n");
        printBox(new String[]{
            BOLD + CYAN + "═══════════════════════════════════════════════════════" + RESET
        });
    }

    /**
     * Displays available quests with descriptions.
     */
    public static void displayQuestSelection() {
        clearScreen();
        System.out.println("\n");
        
        printBox(new String[]{
            BOLD + MAGENTA + "╔═══════════════════════════════════════════════════════╗" + RESET,
            BOLD + MAGENTA + "║         🗺️  CHOOSE YOUR QUEST DIFFICULTY  🗺️         ║" + RESET,
            BOLD + MAGENTA + "╚═══════════════════════════════════════════════════════╝" + RESET
        });
        
        System.out.println("\n");
        printQuestCard(1, "NOVICE QUEST", 3, "Perfect for beginners", GREEN);
        System.out.println();
        printQuestCard(2, "WARRIOR'S GAUNTLET", 8, "Test your Java mastery", YELLOW);
        System.out.println();
        printQuestCard(3, "ELITE CHALLENGE", 2, "Only for true champions", RED);
        System.out.println();
        printQuestCard(4, "OOP MASTERY QUEST", 20, "Master Object-Oriented Programming", MAGENTA);
        System.out.println();
        printQuestCard(5, "BACK", 0, "Return to main menu", CYAN);
        
        System.out.println("\n");
    }

    /**
     * Displays a question in game-like format with visual feedback.
     */
    public static void displayQuestion(String text, int currentQuestion, int totalQuestions) {
        System.out.println("\n");
        
        // Health bar style progress
        int progress = (currentQuestion * 100) / totalQuestions;
        System.out.print("  " + CYAN + "Progress: [");
        int filled = progress / 5;
        for (int i = 0; i < 20; i++) {
            System.out.print(i < filled ? "█" : "░");
        }
        System.out.println("] " + progress + "%" + RESET);
        
        System.out.println();
        System.out.println("  " + BOLD + YELLOW + "Question " + currentQuestion + " of " + totalQuestions + RESET);
        System.out.println();
        
        // Question box
        String[] lines = text.split("\n");
        System.out.println("  " + MAGENTA + "┌" + "─".repeat(54) + "┐" + RESET);
        for (String line : lines) {
            System.out.println("  " + MAGENTA + "│ " + RESET + BOLD + line + " ".repeat(Math.max(0, 52 - line.length())) + MAGENTA + "│" + RESET);
        }
        System.out.println("  " + MAGENTA + "└" + "─".repeat(54) + "┘" + RESET);
        System.out.println();
    }

    /**
     * Displays answer options with selection styling.
     */
    public static void displayAnswerOptions(java.util.List<String> options) {
        System.out.println("  " + CYAN + BOLD + "Choose wisely:" + RESET + "\n");
        for (int i = 0; i < options.size(); i++) {
            String option = options.get(i);
            String color = switch (i) {
                case 0 -> BLUE;
                case 1 -> GREEN;
                case 2 -> YELLOW;
                default -> RED;
            };
            
            System.out.println("    " + BOLD + color + (i + 1) + ")" + RESET + "  " + option);
        }
        System.out.println();
    }

    /**
     * Shows correct answer feedback with animation.
     */
    public static void showCorrectAnswer() {
        System.out.print("  ");
        String[] frames = {"⭐", "✨", "⭐", "✨"};
        for (String frame : frames) {
            System.out.print("\b\b" + frame + " ");
            try { Thread.sleep(150); } catch (InterruptedException e) {}
        }
        System.out.println(GREEN + BOLD + "CORRECT! +10 Points!" + RESET);
        System.out.println();
    }

    /**
     * Shows incorrect answer feedback with animation.
     */
    public static void showIncorrectAnswer() {
        System.out.println("  " + RED + BOLD + "❌ WRONG! But don't give up!" + RESET);
        System.out.println();
    }

    /**
     * Displays a result card with grade and stats.
     */
    public static void displayResultCard(String playerName, int correct, int total, double percentage, String grade, long timeTaken) {
        clearScreen();
        System.out.println("\n");
        
        // Determine color based on grade
        String gradeColor = switch (grade) {
            case "A" -> GREEN;
            case "B" -> CYAN;
            case "C" -> YELLOW;
            case "D" -> YELLOW;
            default -> RED;
        };
        
        System.out.println("  " + MAGENTA + BOLD + "╔════════════════════════════════════════════════════════╗" + RESET);
        System.out.println("  " + MAGENTA + BOLD + "║" + RESET + "         " + YELLOW + BOLD + "⚔️  QUEST COMPLETE!  ⚔️" + RESET + "             " + MAGENTA + BOLD + "║" + RESET);
        System.out.println("  " + MAGENTA + BOLD + "╚════════════════════════════════════════════════════════╝" + RESET);
        
        System.out.println();
        System.out.println("  " + CYAN + "Adventurer: " + RESET + BOLD + playerName + RESET);
        System.out.println("  " + CYAN + "Questions Conquered: " + RESET + BOLD + correct + "/" + total + RESET);
        System.out.println("  " + CYAN + "Victory Rate: " + RESET + BOLD + String.format("%.1f%%", percentage) + RESET);
        System.out.println("  " + CYAN + "Time in Arena: " + RESET + BOLD + timeTaken + " seconds" + RESET);
        System.out.println();
        
        // Grade with special styling
        System.out.print("  " + CYAN + "Final Grade: " + RESET);
        if (percentage >= 90) {
            System.out.println(GREEN + BOLD + "🏅 " + grade + " (Legendary!)" + RESET);
        } else if (percentage >= 80) {
            System.out.println(CYAN + BOLD + "⭐ " + grade + " (Excellent!)" + RESET);
        } else if (percentage >= 70) {
            System.out.println(YELLOW + BOLD + "✨ " + grade + " (Good!)" + RESET);
        } else if (percentage >= 60) {
            System.out.println(YELLOW + BOLD + "💫 " + grade + " (Keep trying!)" + RESET);
        } else {
            System.out.println(RED + BOLD + "⚠️  " + grade + " (Don't give up!)" + RESET);
        }
        
        System.out.println();
        System.out.println("  " + MAGENTA + BOLD + "════════════════════════════════════════════════════════" + RESET);
        System.out.println();
    }

    /**
     * Shows victory animation and statistics.
     */
    public static void showVictoryAnimation() {
        System.out.println();
        String[] victoryLines = {
            "                    ╰(◡´◕ ¯ palms are sweaty ¯◕´◡)╯",
            "",
            "          " + BOLD + YELLOW + "🎊 YOU'VE CONQUERED THIS CHALLENGE! 🎊" + RESET
        };
        
        for (String line : victoryLines) {
            System.out.println(line);
            pause(300);
        }
    }

    /**
     * Displays statistics with visual bars.
     */
    public static void displayStatistics(int totalQuizzes, int totalCorrect, int totalQuestions, double averagePercentage) {
        clearScreen();
        System.out.println("\n");
        
        printBox(new String[]{
            BOLD + CYAN + "╔════════════════════════════════════════════════════════╗" + RESET,
            BOLD + CYAN + "║         📊 YOUR LEGENDARY ACHIEVEMENTS 📊             ║" + RESET,
            BOLD + CYAN + "╚════════════════════════════════════════════════════════╝" + RESET
        });
        
        System.out.println("\n");
        System.out.println("  " + YELLOW + BOLD + "Quests Completed: " + RESET + CYAN + totalQuizzes + RESET);
        System.out.println("  " + YELLOW + BOLD + "Total Questions Answered: " + RESET + CYAN + totalQuestions + RESET);
        System.out.println("  " + YELLOW + BOLD + "Correct Answers: " + RESET + GREEN + totalCorrect + RESET);
        System.out.println("  " + YELLOW + BOLD + "Average Victory Rate: " + RESET + BLUE + String.format("%.1f%%", averagePercentage) + RESET);
        
        // Visual bar
        System.out.println();
        System.out.print("  " + CYAN + "Overall Progress: [" + RESET);
        int barLength = (int) (averagePercentage / 5);
        for (int i = 0; i < 20; i++) {
            System.out.print(i < barLength ? GREEN + "█" : "░");
        }
        System.out.println(RESET + "] " + String.format("%.1f%%", averagePercentage));
        
        System.out.println("\n");
    }

    /**
     * Display about/codex information.
     */
    public static void displayCodex() {
        clearScreen();
        System.out.println("\n");
        
        printBox(new String[]{
            BOLD + MAGENTA + "╔════════════════════════════════════════════════════════╗" + RESET,
            BOLD + MAGENTA + "║           📖 THE CODEX - GAME INFORMATION 📖          ║" + RESET,
            BOLD + MAGENTA + "╚════════════════════════════════════════════════════════╝" + RESET
        });
        
        System.out.println("\n" + CYAN + BOLD + "🎮 GAME MECHANICS:" + RESET);
        System.out.println("  • Answer multiple-choice questions to gain XP");
        System.out.println("  • Each correct answer awards you 10 points");
        System.out.println("  • Build your achievement history");
        System.out.println("  • Track your overall victory rate\n");
        
        System.out.println(CYAN + BOLD + "⚡ DIFFICULTY LEVELS:" + RESET);
        System.out.println("  🟢 Novice Quest - Start here! (3 questions)");
        System.out.println("  🟡 Warrior's Gauntlet - Prove your skills! (8 questions)");
        System.out.println("  🔴 Elite Challenge - For champions only! (2 questions)\n");
        
        System.out.println(CYAN + BOLD + "🏆 GRADING SYSTEM:" + RESET);
        System.out.println("  🏅 A (90-100%) - Legendary!");
        System.out.println("  ⭐ B (80-89%)  - Excellent!");
        System.out.println("  ✨ C (70-79%)  - Good!");
        System.out.println("  💫 D (60-69%)  - Keep trying!");
        System.out.println("  ⚠️  F (<60%)   - Don't give up!\n");
        
        System.out.println(CYAN + BOLD + "📚 CONCEPTS COVERED:" + RESET);
        System.out.println("  • Java Loops (for, while, do-while)");
        System.out.println("  • Conditionals (if-else, switch)");
        System.out.println("  • Collections (ArrayList, List, Set, Map)\n");
        
        System.out.println("  " + MAGENTA + "════════════════════════════════════════════════════════\n");
    }

    /**
     * Displays exit screen with final stats.
     */
    public static void displayExitScreen() {
        clearScreen();
        System.out.println("\n\n");
        System.out.println("  " + YELLOW + BOLD + "Thanks for playing Quest Champion!" + RESET);
        System.out.println("  " + CYAN + "May your code always compile on the first try! 🚀" + RESET);
        System.out.println("\n");
    }

    // ==================== HELPER METHODS ====================

    /**
     * Prints animated text character by character.
     */
    private static void printAnimatedText(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(20); } catch (InterruptedException e) {}
        }
        System.out.println();
    }

    /**
     * Prints a menu option with number and description.
     */
    private static void printMenuOption(int number, String title, String description) {
        System.out.println("  " + BOLD + BLUE + number + "." + RESET + "  " + BOLD + title + RESET);
        System.out.println("     " + CYAN + description + RESET);
    }

    /**
     * Prints a quest card with difficulty info.
     */
    private static void printQuestCard(int number, String name, int questions, String description, String color) {
        System.out.print("  " + BOLD + BLUE + number + "." + RESET + "  ");
        System.out.print(color + BOLD + "┌─ " + name);
        if (questions > 0) {
            System.out.print(" (" + questions + "Q)");
        }
        System.out.println(" ─┐" + RESET);
        System.out.println("     " + color + "└─ " + description + " ─┘" + RESET);
    }

    /**
     * Prints a decorative box.
     */
    private static void printBox(String[] lines) {
        for (String line : lines) {
            System.out.println("  " + line);
        }
    }

    /**
     * Prints a decorative line.
     */
    private static void printLine() {
        System.out.println("  " + CYAN + "════════════════════════════════════════════════════════" + RESET);
    }

    /**
     * Clears the screen (works on most terminals).
     */
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    /**
     * Pauses execution for a given milliseconds.
     */
    public static void pause(int milliseconds) {
        try { Thread.sleep(milliseconds); } catch (InterruptedException e) {}
    }
}
