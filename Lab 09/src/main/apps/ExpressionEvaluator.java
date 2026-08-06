package apps;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 
 * @author Frederick Adongo
 * @version 4th March, 2025
 */
public class ExpressionEvaluator 
{
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    public static String toPostfix(String expression)
    {
        Scanner input = new Scanner(expression);
        Stack<Character> stack = new Stack<Character>();
        String result = "";

        while(input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                result += input.findInLine(UNSIGNED_DOUBLE) + " ";
            }
            else
            {
                String next = input.findInLine(CHARACTER);
                char operator = next.charAt(0);

                switch (operator)
                {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!stack.isEmpty() && higherPrecedence(operator, stack.peek()))
                        {
                            result += stack.pop() + " ";
                        }
                        stack.push(operator);
                        break;
                    case '(':
                        stack.push(operator);
                        break;
                    case ')':
                        while (!stack.isEmpty() && stack.peek() != '(')
                        {
                            result += stack.pop() + " ";
                        }
                        if (stack.isEmpty())
                        {
                            return null;
                        }
                        stack.pop();
                        break;
                    default:
                        return null;
                }
            }
        }

        while (!stack.isEmpty())
        {
            if (stack.peek() == '(')
            {
                return null;
            }
            result += stack.pop() + " ";
        }

        input.close();

        return result;
    }

    public static double evaluate(String postfixExpression)
    {
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operation;
        double answer = Double.NaN;
        Stack<Double> stack = new Stack<>();

        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                stack.push(Double.parseDouble(next));
                //postfixExpression += next + " ";
            }
            else
            {
                next = input.findInLine(CHARACTER);
                operation = next.charAt(0);
                
                double operand2 = 0.0;
                double operand1 = 0.0;
                 
                switch(operation)
                {
                    case '*':
                        operand1 = stack.pop();
                        operand2 = stack.pop();
                        stack.push((operand1 * operand2));
                        break;
                    case '/':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        stack.push((operand1 / operand2));
                        break;
                    case '+': 
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        stack.push((operand1 + operand2));
                        break;
                    case '-':
                        operand2 = stack.pop();
                        operand1 = stack.pop();
                        stack.push((operand1 - operand2));
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal operation.");
                }
                    
            }
            
        }

        answer = stack.pop();
        input.close();
        return answer;
    }

    private static boolean higherPrecedence(char current, char top)
    {
        return (top == '*' || top == '/') || (top == '+' || top == '-') && (current == '+' || current == '-');
    }
}
