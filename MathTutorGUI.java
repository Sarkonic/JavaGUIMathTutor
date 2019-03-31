package homework3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.lang.Integer.parseInt;

public class MathTutorGUI extends JFrame implements ActionListener {

    private JTextField text;    //where the user enters their answer
    private JLabel label;       //the label to display the math problem
    private JLabel identifier;  //"identifies" if correct or incorrect
    private JButton mBtn;       //button to check answer
    private JPanel answerPanel; //container for identifier. Changes colors based on actions.
    private MathRandomizer rand = new MathRandomizer(); //class for making random numbers
    private static int counter = 0;  //counter for keeping track of how many tries the user takes

    public MathTutorGUI() {
        super("Math Tutor");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        text = new JTextField();
        mBtn = new JButton("Click to start");
        mBtn.addActionListener(this);   //this is referring to the actionPerformed object of the class
        label = new JLabel("Solve: ");
        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(Color.GRAY);
        answerPanel = new JPanel();
        identifier = new JLabel("");
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 1));    //grid of 4 rows and 1 cols

        add(labelPanel);
        add(text);
        add(mBtn);
        add(answerPanel);
        answerPanel.add(identifier);
        labelPanel.add(label);
    }

    public void actionPerformed(ActionEvent e) {

        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Click to start")) {   //first operation will be plus when user clicks to start
            rand.setfNum(rand.makeRandomNum());
            rand.setsNum(rand.makeRandomNum());
            mBtn.setText("Check Answer");
            label.setText("Solve: " + rand.getfNum() + rand.operationChoice() + rand.getsNum());
        } else if (actionCommand.equals("Check Answer")) {  //TODO exception handle parseInt when sending empty string
            try {
                if (parseInt(text.getText()) == (rand.getsNum() + rand.getfNum()) && rand.getOperation().equals(" plus ")) {
                    identifier.setText("Correct! Tries: " + MathTutorGUI.counter);
                    rand.setfNum(rand.makeRandomNum());
                    rand.setsNum(rand.makeRandomNum());
                    label.setText("Solve: " + rand.getfNum() + rand.operationChoice() + rand.getsNum());
                    answerPanel.setBackground(Color.green);
                    text.setText("");
                    MathTutorGUI.counter = 0;

                } else if (parseInt(text.getText()) == (rand.getfNum() - rand.getsNum())) {
                    identifier.setText("Correct! Tries: " + MathTutorGUI.counter);
                    rand.setfNum(rand.makeRandomNum());
                    rand.setsNum(rand.makeRandomNum());
                    label.setText("Solve: " + rand.getfNum() + rand.operationChoice() + rand.getsNum());
                    answerPanel.setBackground(Color.green);
                    text.setText("");
                    MathTutorGUI.counter = 0;
                } else if (parseInt(text.getText()) == (rand.getfNum() * rand.getsNum())) {
                    identifier.setText("Correct! Tries: " + MathTutorGUI.counter);
                    rand.setfNum(rand.makeRandomNum());
                    rand.setsNum(rand.makeRandomNum());
                    label.setText("Solve: " + rand.getfNum() + rand.operationChoice() + rand.getsNum());
                    answerPanel.setBackground(Color.green);
                    text.setText("");
                    MathTutorGUI.counter = 0;
                } else {
                    identifier.setText("Nope! Keep Trying! :)");
                    text.setText("");
                    answerPanel.setBackground(Color.red);
                    MathTutorGUI.counter++;
                }
            }
            catch(NumberFormatException e1) //if user sends empty string, catch exception and tell them to try again
            {
                identifier.setText("Please type in your answer :)");
                text.setText("");
                answerPanel.setBackground(Color.magenta);
            }
        }
    }
}
