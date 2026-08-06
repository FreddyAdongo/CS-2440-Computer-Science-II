package apps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Frederick Adongo
 * @version 4th March, 2025
 */
public class Calculator
{
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String NAME = "Arithmetic Calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;
    private JTextField infixExpression;
    private JLabel resultLabel;

    public Calculator()
    {
        /**
         * infxExpression should have the name "infxExpression"
           resultLabel should have the name "resultLabel"
           calculateButton should have the name "calculateButton"
           clearButton should have the name "clearButton"
         */
        createFrame();
        initializeComponents();
        displayFrame();
    }

    public JFrame getFrame()
    {
        return frame;
    }

    private void createFrame()
    {
        this.frame = new JFrame();
        this.frame.setLocation(X_LOC, Y_LOC);
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setTitle(NAME);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents()
    {
        initializeInput();
        initializeResult();
        initializeButtons();
    }

    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }

    private void initializeInput()
    {
        JPanel inputPanel = new JPanel();

        infixExpression = new JTextField(12);
        infixExpression.setName("infixExpression");
        inputPanel.add(infixExpression);

        frame.add(inputPanel, BorderLayout.NORTH);
    }

    private void initializeResult()
    {
        JPanel resultPanel = new JPanel();
        resultLabel = new JLabel(RESULT_PREAMBLE);
        resultLabel.setName("resultLabel");
        resultPanel.add(resultLabel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.CENTER);
    }

    private void initializeButtons()
    {
        JPanel buttonPanel = new JPanel();

        JButton calculate = new JButton("Calculate");
        calculate.setName("calculateButton");
        calculate.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                String result = calculate();
                updateResult(result);
                // ExpressionEvaluator obj;
                // obj = new ExpressionEvaluator();

                // double postfix = obj.evaluate(obj.toPostfix(infixExpression.getText()));

                // String result = obj.toPostfix(infixExpression.getText());

                    // if(postfix != Double.NaN)
                    // {

                    //     //resultLabel.setText(RESULT_PREAMBLE + postfixEx);
                    //     updateResult(result);
                            
                    // }
                    // else
                    // {
                    //     //resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
                    //     updateResult(result);
                    // }
            }   
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setName("clearButton");
        clearButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                infixExpression.setText("");
                resultLabel.setText(RESULT_PREAMBLE);
            }    
        });

        buttonPanel.add(calculate);
        buttonPanel.add(clearButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private String calculate()
    {
        String postFix = ExpressionEvaluator.toPostfix(infixExpression.getText());
       
        if (postFix == null)
        {
            //resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
            //updateResult(postFix);
            return RESULT_PREAMBLE + ERROR_MESSAGE;
        }
       
        Double result = ExpressionEvaluator.evaluate(postFix);
        
        if (Double.isNaN(result))
        {
            //resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
            //updateResult(postFix);
            return RESULT_PREAMBLE + ERROR_MESSAGE;
        }

        //return result.toString();

        return RESULT_PREAMBLE + result;
    }

    private void updateResult(String result)
    {
        // if ("NaN".equals(result))
        // {
        //     resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
        // }
        // else
        // {
        //     resultLabel.setText(RESULT_PREAMBLE + result);
        // }
        resultLabel.setText(result);
        
    }
}