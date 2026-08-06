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
 * @author Frederick Adongo
 * @version 13th February, 2025
 * 
 */
public class Calculator
{
    // Fields
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String NAME = "Arithmetic Calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;

    /**
     * 
     * One-arg constructor
     */
    public Calculator()
    {
        // Builds outer frame 
        createFrame();

        // Builds calculator compoents & puts into frame
        initializeComponents();

        // Make calculator appear
        displayFrame();
    }

    /**
     * 
     * @return
     */
    public JFrame getFrame()
    {
        return frame;
    }

    /**
     * 
     */
    private void createFrame()
    {
        this.frame = new JFrame();
        this.frame.setLocation(X_LOC, Y_LOC);
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setTitle(NAME);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * 
     */
    private void initializeComponents()
    {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    /**
     * 
     */
    private void displayFrame()
    {
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * 
     */
    private void initializeInputs()
    {
        JPanel inputPanel = new JPanel();
        
        //Set text fields, sizes and panels
        leftOpField = new JTextField(10);
        leftOpField.setName("leftOperand");
        inputPanel.add(leftOpField);

        rightOpField = new JTextField(10);
        rightOpField.setName("rightOperand");
        inputPanel.add(rightOpField);
        
        //Add panel to frame
        frame.add(inputPanel, BorderLayout.NORTH);
    }

    /**
     * 
     */
    private void initializeResults()
    {
        JPanel resultPanel = new JPanel();
        
        resultLabel = new JLabel(RESULT_PREAMBLE);

        resultLabel.setName("resultLabel");

        resultPanel.add(resultLabel, BorderLayout.CENTER);

        frame.add(resultPanel, BorderLayout.LINE_START);
    }

    /**
    * 
    */
    private void initializeButtons()
    {
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("ADD");
        JButton subButton = new JButton("SUB");
        JButton multButton = new JButton("MULT");
        JButton divButton = new JButton("DIV");

        addButton.setName("addButton");
        subButton.setName("subButton");
        multButton.setName("multButton");
        divButton.setName("divButton");

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(multButton);
        buttonPanel.add(divButton);

        addButton.addActionListener(new ActionListener() 
        {
            // Addition
            public void actionPerformed(ActionEvent e)
            {
                double x = getLeftNum();
                double y = getRightNum();

                double sum = x + y;
               
                updateResult(sum);
            }
        });

        // Subtraction
        subButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double x = getLeftNum();
                double y = getRightNum();

                double sub = x - y;

                updateResult(sub);
            }
        });

        // Multiplication
        multButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double x = getLeftNum();
                double y = getRightNum();

                double mult = x * y;

                updateResult(mult);
            }
        });

        // Division
        divButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                double x = getLeftNum();
                double y = getRightNum();

                if (y == 0)
                {
                    updateResult(Double.NaN);
                }
                else
                {
                    double div = x / y;
                    updateResult(div);
                }
            }
        });

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * 
     * @return
     */
    private double getLeftNum()
    {
        try 
        {
            String left = leftOpField.getText();

            double leftNum = Double.parseDouble(left);
            
            if (left.isEmpty())
            {
                //If value does not exist & not a double, return NaN
                return Double.NaN;
            }
            else
            {
                return leftNum;
            }
            
        } 
        catch (NumberFormatException e) 
        {
            //If value does not exist & not a double, return NaN
            return Double.NaN;
        }
    }

    /**
     * 
     * @return
     */
    private double getRightNum()
    {
        try 
        {
            String right = rightOpField.getText();

            double rightNum = Double.parseDouble(right);
            
            if (right.isEmpty())
            {
                //If value does not exist & not a double, return NaN
                return Double.NaN;
            }
            else
            {
                return rightNum;
            }
            
        } 
        catch (NumberFormatException e) 
        {
            //If value does not exist & not a double, return NaN
            return Double.NaN;
        }
    }

    /**
     * 
     * @param result
     */
    private void updateResult(double result)
    {
        if (Double.isNaN(result))
        {
            resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
        }
        else
        {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }
}