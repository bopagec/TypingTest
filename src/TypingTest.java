import java.text.NumberFormat;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TypingTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            boolean tryAgain = false;
            int question = 0;
            int correctCount = 0;
            int wrongCount = 0;

            int questionCount = 10;
            for (int i = 0; i < questionCount; i++) {
                if (!tryAgain) {
                    question = ThreadLocalRandom.current().nextInt(1000);
                }

                System.out.println(question);
                int answer = scanner.nextInt();

                if (question != answer) {
                    tryAgain = true;
                    System.out.println("try again.");
                    wrongCount++;
                    i--;
                } else {
                    correctCount++;
                    tryAgain = false;
                }
            }

            NumberFormat nf = NumberFormat.getPercentInstance();
            nf.setMinimumFractionDigits(2);

            float percentage = ((float)(correctCount - wrongCount) / questionCount );
            System.out.println();
            System.out.println("Your Score is: " + nf.format(percentage));
            System.out.println("----------Well Done!---------");
            System.out.println();
        }
    }
}
