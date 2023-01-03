import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

public class KeypadTest {
    JLabel questionLabel = new JLabel();
    JTextField answerField = new JTextField();
    JLabel counterLabel = new JLabel();
    int question = 0;
    int correctCount = 0;
    int wrongCount = 0;
    int questionCount = 25;
    boolean tryAgain = false;
    public KeypadTest() {
        JFrame frame = new JFrame("Learn the Keypad");
        JPanel panel = new JPanel();
        JButton startButton = new JButton("Start");

        startButton.addActionListener( e -> startTest());

        questionLabel.setFont(new Font("Sarif", Font.BOLD, 75));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        questionLabel.setVisible(false);

        counterLabel.setFont(new Font("Sarif", Font.BOLD, 25));
        counterLabel.setForeground(Color.green);
        counterLabel.setText(correctCount + "/" + questionCount);

        answerField.setFont(new Font("Sarif", Font.BOLD, 75));
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        answerField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    nextQuestion();
                }
            }
        });
        answerField.setVisible(false);

        panel.setLayout(new GridLayout(3,1));

        panel.add(startButton);
        panel.add(questionLabel);
        panel.add(answerField);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(420,420);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new KeypadTest();
    }

    public void nextQuestion(){
        if(answerField.getText().equals(questionLabel.getText())){
            tryAgain = false;
            correctCount++;
        }else{
            tryAgain = true;
            wrongCount++;
        }

        question = ThreadLocalRandom.current().nextInt(1000);
        questionLabel.setText(String.valueOf(question));
        questionLabel.setForeground(Color.BLACK);
        answerField.setText("");
        counterLabel.setText(correctCount + "/" + questionCount);
    }

    public void startTest(){
        questionLabel.setVisible(true);
        answerField.setVisible(true);
        nextQuestion();

/*        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(2);

        float percentage = ((float)(correctCount - wrongCount) / questionCount );
        System.out.println();
        System.out.println("Your Score is: " + nf.format(percentage));
        System.out.println("----------Well Done!---------");
        System.out.println();*/

    }
}
