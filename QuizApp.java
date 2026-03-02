import java.util.*;

public class QuizApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Add Questions
        questions.add(new Question(
                "Which keyword is used to inherit a class in Java?",
                Arrays.asList("this", "super", "extends", "implements"),
                3));

        questions.add(new Question(
                "Which collection allows dynamic resizing?",
                Arrays.asList("Array", "ArrayList", "Map", "Set"),
                2));

        questions.add(new Question(
                "Which loop executes at least once?",
                Arrays.asList("for", "while", "do-while", "foreach"),
                3));

        questions.add(new Question(
                "Which method is used to sort a list?",
                Arrays.asList("Collections.sort()", "Arrays.sort()", "sortList()", "order()"),
                1));

        questions.add(new Question(
                "Which interface stores key-value pairs?",
                Arrays.asList("List", "Set", "Map", "Queue"),
                3));

        // Shuffle questions
        Collections.shuffle(questions);

        int score = 0;
        int questionNumber = 1;

        System.out.println("===== ONLINE QUIZ APP =====\n");

        // Enhanced for-loop
        for (Question q : questions) {

            System.out.println("Q" + questionNumber + ": " + q.getQuestionText());

            int i = 1;
            for (String option : q.getOptions()) {
                System.out.println(i + ". " + option);
                i++;
            }

            System.out.print("Enter your answer (1-4): ");
            int userChoice = sc.nextInt();

            if (q.isCorrect(userChoice)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }

            questionNumber++;
        }

        // Result
        System.out.println("===== QUIZ COMPLETED =====");
        System.out.println("Your Score: " + score + "/" + questions.size());

        double percentage = (score * 100.0) / questions.size();

        if (percentage >= 70)
            System.out.println("Result: PASS");
        else
            System.out.println("Result: TRY AGAIN");

        sc.close();
    }
}