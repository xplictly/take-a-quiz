import java.util.*;

/**
 * QuizRepository: A developer-friendly class to manage pre-built quizzes.
 * Makes it easy for developers to create and manage multiple quizzes.
 */
public class QuizRepository {

    /**
     * Creates a sample programming concepts quiz.
     * Great for testing the application!
     *
     * @param scanner The Scanner to use for input
     * @return QuizEngine populated with programming questions
     */
    public static QuizEngine createProgrammingQuiz(Scanner scanner) {
        QuizEngine quiz = new QuizEngine(scanner);

        // Question 1: Loops
        Question q1 = new Question(
                "Which loop is best used when the number of iterations is known in advance?",
                Arrays.asList("while loop", "for loop", "do-while loop", "switch loop"),
                1, // Correct answer: for loop (index 1)
                "The 'for' loop is ideal when you know exactly how many times you need to iterate."
        );

        // Question 2: Conditionals
        Question q2 = new Question(
                "What is the output of: if (5 > 3) System.out.println(\"Yes\"); else System.out.println(\"No\");",
                Arrays.asList("No", "Yes", "Error", "Null"),
                1, // Correct answer: Yes (index 1)
                "Since 5 is greater than 3, the condition is true, so 'Yes' is printed."
        );

        // Question 3: Collections
        Question q3 = new Question(
                "Which collection maintains insertion order and allows duplicates?",
                Arrays.asList("HashSet", "ArrayList", "HashMap", "TreeSet"),
                1, // Correct answer: ArrayList (index 1)
                "ArrayList is an ordered collection that allows duplicates. HashSet doesn't maintain order."
        );

        // Question 4: Loops with Collections
        Question q4 = new Question(
                "What's the best way to iterate through a List in Java?",
                Arrays.asList("Traditional for loop", "Enhanced for loop", "Iterator", "All of the above"),
                3, // Correct answer: All of the above (index 3)
                "All three methods work! Enhanced for loop is the most concise, Iterator is useful for removal."
        );

        // Question 5: Conditionals and Logic
        Question q5 = new Question(
                "Which condition is true if x = 10 and y = 20?",
                Arrays.asList("x > y && x == 10", "x > y || y > x", "!(x == 10)", "x < y && y < 30"),
                3, // Correct answer: x < y && y < 30 (index 3)
                "10 < 20 is true AND 20 < 30 is true, so the entire condition is true."
        );

        // Question 6: Array Collection
        Question q6 = new Question(
                "How do you create an ArrayList of Strings in Java?",
                Arrays.asList(
                        "List<String> list = new ArrayList<>();",
                        "ArrayList list = new ArrayList();",
                        "String[] list = new ArrayList();",
                        "Vector<String> list = new ArrayList<>();"
                ),
                0, // Correct answer: List<String> list = new ArrayList<>(); (index 0)
                "This is the proper generic syntax for creating a type-safe ArrayList."
        );

        // Question 7: Loop Control
        Question q7 = new Question(
                "What does the 'break' statement do in a loop?",
                Arrays.asList(
                        "Pauses the loop temporarily",
                        "Exits the loop immediately",
                        "Skips the current iteration",
                        "Restarts the loop"
                ),
                1, // Correct answer: Exits the loop immediately (index 1)
                "'break' terminates the loop and execution continues after it. 'continue' skips an iteration."
        );

        // Question 8: Conditional Logic
        Question q8 = new Question(
                "What is the result of: (true && false) || true?",
                Arrays.asList("true", "false", "undefined", "error"),
                0, // Correct answer: true (index 0)
                "true && false = false, then false || true = true. OR operator returns true if at least one operand is true."
        );

        // Add all questions to the quiz
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);
        quiz.addQuestion(q4);
        quiz.addQuestion(q5);
        quiz.addQuestion(q6);
        quiz.addQuestion(q7);
        quiz.addQuestion(q8);

        return quiz;
    }

    /**
     * Creates a beginner-level Java basics quiz.
     *
     * @param scanner The Scanner to use for input
     * @return QuizEngine with beginner questions
     */
    public static QuizEngine createBeginnerQuiz(Scanner scanner) {
        QuizEngine quiz = new QuizEngine(scanner);

        Question q1 = new Question(
                "What is the correct way to declare a variable?",
                Arrays.asList("int x;", "declare x;", "x = int;", "define x as int"),
                0,
                "The correct syntax is 'type variableName;' (e.g., int x;)"
        );

        Question q2 = new Question(
                "What does println stand for?",
                Arrays.asList("print line new", "print line number", "print line", "program line new"),
                2,
                "'println' prints a line and adds a newline character at the end."
        );

        Question q3 = new Question(
                "Which keyword is used to create a loop that runs at least once?",
                Arrays.asList("while", "for", "do-while", "repeat"),
                2,
                "The do-while loop executes its body at least once before checking the condition."
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);

        return quiz;
    }

    /**
     * Creates an advanced Java concepts quiz.
     *
     * @param scanner The Scanner to use for input
     * @return QuizEngine with advanced questions
     */
    public static QuizEngine createAdvancedQuiz(Scanner scanner) {
        QuizEngine quiz = new QuizEngine(scanner);

        Question q1 = new Question(
                "What is the time complexity of adding an element to an ArrayList?",
                Arrays.asList("O(1) amortized", "O(n)", "O(log n)", "O(n²)"),
                0,
                "Adding to the end of an ArrayList is O(1) amortized time complexity."
        );

        Question q2 = new Question(
                "Which collection uses a hash table for O(1) lookups?",
                Arrays.asList("LinkedList", "HashMap", "TreeMap", "PriorityQueue"),
                1,
                "HashMap provides O(1) average-case time complexity for get and put operations."
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        return quiz;
    }

    /**
     * Creates an Object-Oriented Programming (OOP) concepts quiz based on VTU syllabus.
     * Covers classes, objects, inheritance, polymorphism, encapsulation, and abstraction.
     *
     * @param scanner The Scanner to use for input
     * @return QuizEngine with OOP questions
     */
    public static QuizEngine createOOPQuiz(Scanner scanner) {
        QuizEngine quiz = new QuizEngine(scanner);

        // Question 1: Classes and Objects
        Question q1 = new Question(
                "What is an object in Java?",
                Arrays.asList(
                        "A template for creating instances",
                        "An instance of a class with state and behavior",
                        "A method inside a class",
                        "A type of variable"
                ),
                1,
                "An object is an instance of a class. It has attributes (state) and methods (behavior)."
        );

        // Question 2: Class vs Object
        Question q2 = new Question(
                "Which of the following is true about classes?",
                Arrays.asList(
                        "A class is an instance of an object",
                        "A class is a logical entity that occupies memory",
                        "A class is a blueprint/template for creating objects",
                        "A class cannot have constructors"
                ),
                2,
                "A class is a blueprint or template that defines the structure and behavior for objects."
        );

        // Question 3: Encapsulation
        Question q3 = new Question(
                "What is encapsulation in OOP?",
                Arrays.asList(
                        "Wrapping data and methods together and hiding internal details",
                        "Creating multiple objects of a class",
                        "Inheriting properties from parent class",
                        "Creating abstract methods"
                ),
                0,
                "Encapsulation is binding data (variables) and methods together while hiding implementation details through access modifiers (private, public, protected)."
        );

        // Question 4: Inheritance
        Question q4 = new Question(
                "What is inheritance in Java?",
                Arrays.asList(
                        "A mechanism to create new classes based on existing classes",
                        "A way to store data in objects",
                        "A method to create multiple objects",
                        "A technique to hide data"
                ),
                0,
                "Inheritance allows a class (subclass) to inherit properties and methods from another class (superclass) using the 'extends' keyword."
        );

        // Question 5: Polymorphism
        Question q5 = new Question(
                "What does polymorphism mean in Java?",
                Arrays.asList(
                        "One object can have many forms or behaviors",
                        "Creating multiple classes",
                        "Hiding data from outside world",
                        "Creating abstract classes only"
                ),
                0,
                "Polymorphism means 'many forms'. It allows objects to take on multiple forms - achieved through method overriding (runtime polymorphism) and method overloading (compile-time polymorphism)."
        );

        // Question 6: Access Modifiers
        Question q6 = new Question(
                "Which access modifier allows access only within the same class?",
                Arrays.asList("public", "protected", "private", "default"),
                2,
                "The 'private' modifier restricts access to only within the same class. This is the most restrictive access level."
        );

        // Question 7: Constructor
        Question q7 = new Question(
                "What is the purpose of a constructor in Java?",
                Arrays.asList(
                        "To create methods for the class",
                        "To initialize an object and set initial values to its variables",
                        "To delete objects from memory",
                        "To perform calculations"
                ),
                1,
                "A constructor is a special method that is called when an object is created. It is used to initialize the object's state."
        );

        // Question 8: this keyword
        Question q8 = new Question(
                "What does the 'this' keyword refer to?",
                Arrays.asList(
                        "The current class definition",
                        "The current object instance",
                        "The parent class",
                        "The method name"
                ),
                1,
                "The 'this' keyword refers to the current object instance. It is used to refer to instance variables and methods of the current object."
        );

        // Question 9: super keyword
        Question q9 = new Question(
                "What is the 'super' keyword used for?",
                Arrays.asList(
                        "To refer to the current object",
                        "To refer to the parent/superclass",
                        "To create new objects",
                        "To declare variables"
                ),
                1,
                "The 'super' keyword is used to refer to the superclass. It is used to call parent class methods and constructors."
        );

        // Question 10: Method Overriding
        Question q10 = new Question(
                "What is method overriding?",
                Arrays.asList(
                        "Creating a method with the same name in the same class",
                        "Creating a method with the same name and signature in a subclass",
                        "Calling a method multiple times",
                        "Deleting a parent class method"
                ),
                1,
                "Method overriding is when a subclass provides its own implementation of a method that is already defined in the superclass. This is runtime polymorphism."
        );

        // Question 11: Method Overloading
        Question q11 = new Question(
                "Which of the following is a requirement for method overloading?",
                Arrays.asList(
                        "Same method name and same parameters",
                        "Different method name",
                        "Same method name but different parameter types or number",
                        "Same return type"
                ),
                2,
                "Method overloading allows multiple methods with the same name but different parameters (type, number, or order). This is compile-time polymorphism."
        );

        // Question 12: Static keyword
        Question q12 = new Question(
                "What does the 'static' keyword signify?",
                Arrays.asList(
                        "The variable/method belongs to the instance",
                        "The variable/method belongs to the class, not to instances",
                        "The variable cannot be modified",
                        "The method must be overridden"
                ),
                1,
                "Static members (variables or methods) belong to the class itself, not to individual objects. They are shared by all instances of the class."
        );

        // Question 13: Abstraction
        Question q13 = new Question(
                "What is abstraction in OOP?",
                Arrays.asList(
                        "Hiding complexity and showing only essential features",
                        "Creating multiple objects",
                        "Inheriting from multiple classes",
                        "Making all methods public"
                ),
                0,
                "Abstraction is hiding complex implementation details and showing only the essential features. It can be achieved using abstract classes and interfaces."
        );

        // Question 14: Abstract Class
        Question q14 = new Question(
                "Can an abstract class have concrete methods?",
                Arrays.asList(
                        "No, it cannot",
                        "Yes, it can have both abstract and concrete methods",
                        "Only if it extends another abstract class",
                        "Only static methods can be concrete"
                ),
                1,
                "An abstract class can have both abstract methods (without implementation) and concrete methods (with implementation). It cannot be instantiated directly."
        );

        // Question 15: Interface
        Question q15 = new Question(
                "What is an interface in Java?",
                Arrays.asList(
                        "A class with abstract methods only",
                        "A contract that specifies what methods a class must implement",
                        "A variable declaration",
                        "A type of constructor"
                ),
                1,
                "An interface is a blueprint of a class that contains abstract methods. It specifies what a class should do but not how to do it. Classes implement interfaces using the 'implements' keyword."
        );

        // Question 16: instanceof operator
        Question q16 = new Question(
                "What does the 'instanceof' operator do?",
                Arrays.asList(
                        "Creates a new instance of a class",
                        "Checks if an object is an instance of a class or interface",
                        "Compares two objects",
                        "Deletes an object"
                ),
                1,
                "The 'instanceof' operator is used to check if an object is an instance of a specific class or interface. It returns a boolean value."
        );

        // Question 17: Coupling and Cohesion
        Question q17 = new Question(
                "What is loose coupling in OOP?",
                Arrays.asList(
                        "Classes are highly dependent on each other",
                        "Classes have minimal dependencies and can work independently",
                        "All classes inherit from one parent",
                        "Methods call each other frequently"
                ),
                1,
                "Loose coupling means classes are independent and have minimal dependencies. This promotes code reusability and maintainability."
        );

        // Question 18: Constructor Overloading
        Question q18 = new Question(
                "Can constructors be overloaded in Java?",
                Arrays.asList(
                        "No, each class can have only one constructor",
                        "Yes, constructors can be overloaded with different parameters",
                        "Only if the class extends another class",
                        "Only with static constructors"
                ),
                1,
                "Constructors can be overloaded just like methods. Multiple constructors with different parameter lists can exist in a class."
        );

        // Question 19: final keyword
        Question q19 = new Question(
                "What does the 'final' keyword do?",
                Arrays.asList(
                        "Makes a variable, method, or class unchangeable/non-overridable",
                        "Makes a class abstract",
                        "Initializes variables",
                        "Ends a method execution"
                ),
                0,
                "The 'final' keyword prevents modification. A final variable cannot be reassigned, a final method cannot be overridden, and a final class cannot be extended."
        );

        // Question 20: Object class
        Question q20 = new Question(
                "In Java, all classes implicitly extend which class?",
                Arrays.asList("Comparable", "Serializable", "Object", "Class"),
                2,
                "All classes in Java inherit from the Object class either directly or indirectly. Object is the root of the class hierarchy and provides methods like equals(), toString(), and hashCode()."
        );

        // Add all questions to the quiz
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);
        quiz.addQuestion(q4);
        quiz.addQuestion(q5);
        quiz.addQuestion(q6);
        quiz.addQuestion(q7);
        quiz.addQuestion(q8);
        quiz.addQuestion(q9);
        quiz.addQuestion(q10);
        quiz.addQuestion(q11);
        quiz.addQuestion(q12);
        quiz.addQuestion(q13);
        quiz.addQuestion(q14);
        quiz.addQuestion(q15);
        quiz.addQuestion(q16);
        quiz.addQuestion(q17);
        quiz.addQuestion(q18);
        quiz.addQuestion(q19);
        quiz.addQuestion(q20);

        return quiz;
    }
}
