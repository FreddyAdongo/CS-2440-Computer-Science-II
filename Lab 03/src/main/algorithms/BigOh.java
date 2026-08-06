package algorithms;

import java.util.Random;

/**
 * 
 * @author Frederick Adongo
 * @version 30th January, 2025
 * 
 */

public class BigOh 
{
    private static final double MILLISECONDS_PER_SECOND = 1000;
    private static final int NUM_TRIALS = 5;
    private Random rand;

    /**
     * No-arg constructor.
     * 
     */
    public BigOh() 
    {
        rand = new Random();
    }

    /**
     * 
     * @param rand
     */
    public BigOh(Random rand) 
    {
        this.rand = rand;
    }

    /**
     * 
     * @param choice
     * @param numElements
     * @return result int
     */
    public int runAlgorithm(int choice, int numElements) 
    {

        int result = -1;

        switch (choice) {
            case 1:
                result = MysteryAlgorithms.alg1(numElements, rand);
                break;
            case 2:
                result = MysteryAlgorithms.alg2(numElements, rand);
                break;
            case 3:
                result = MysteryAlgorithms.alg3(numElements, rand);
                break;
            case 4:
                result = MysteryAlgorithms.alg4(numElements, rand);
                break;
            case 5:
                result = MysteryAlgorithms.alg5(numElements, rand);
                break;
            case 6:
                result = MysteryAlgorithms.alg6(numElements, rand);
                break;
            default:
                break;
        }

        return result;
    }

    /**
     * 
     * @param choice
     * @param n
     * @return
     */
    public double bigOhFunc(int choice, double n) 
    {

        double result = -1;

        switch(choice) {
            case 1:
                result = n;
                break;
            case 2:
                result = Math.pow(n, 3);
                break;
            case 3:
                result = Math.pow(n, 2);
                break;
            case 4:
                result = Math.pow(n, 2);
                break;
            case 5:
                result = Math.pow(n, 5);
                break;
            case 6:
                result = Math.pow(n, 4);
                break;
            default:
                break;
        }

        return result;
    }

    /**
     * 
     * @param choice
     * @param n
     * @return
     */
    public double timeAlgorithm(int choice, int n) 
    {
        // Run garbage collector
        System.gc();

        // Save timestamp
        double current = System.currentTimeMillis();

        switch(choice)
        {
            case 1:
                MysteryAlgorithms.alg1(n, rand);
                current = System.currentTimeMillis() - current;
                break;
            case 2:
                MysteryAlgorithms.alg2(n, rand);
                current = System.currentTimeMillis() - current;
                break;
            case 3:
                MysteryAlgorithms.alg3(n, rand);
                current = System.currentTimeMillis() - current;
                break;
            case 4:
                MysteryAlgorithms.alg4(n, rand);
                current = System.currentTimeMillis() - current;
                break;
            case 5:
                MysteryAlgorithms.alg5(n, rand);
                current = System.currentTimeMillis() - current;
                break;
            case 6:
                MysteryAlgorithms.alg6(n, rand);
                current = System.currentTimeMillis() - current;
                break;
            default:
                break;
        }
        
        return current / MILLISECONDS_PER_SECOND;
    }

    /**
     * 
     * @param choice
     * @param n
     * @return
     */
    public double robustTimeAlgorithm(int choice, int n) 
    {
        double time;
        double smallestTime;

        time = timeAlgorithm(choice, n);
        smallestTime = timeAlgorithm(choice, n);

        for (int i = 0; i < NUM_TRIALS; i++)
        {
            if (time < smallestTime)
            {
                smallestTime = time;
            }
        }
        return smallestTime;
    }

    /**
     * 
     * @param choice
     * @param n1
     * @param t1
     * @param n2
     * @return
     */
    public double estimateTiming(int choice, int n1, double t1, int n2) 
    {
        
        double choice1 = bigOhFunc(choice, n1);
        double choice2 = bigOhFunc(choice, n2);


        double expectedTime;

        expectedTime = t1 * (choice2 / choice1);

        return expectedTime;
    }

    /**
     * 
     * @param correct
     * @param estimate
     * @return
     */
    public double percentError(double correct, double estimate) 
    {

        double percentError = (estimate - correct) / correct;

        return percentError;
    }

    /**
     * 
     * @param choice
     * @param n1
     * @param n2
     * @return
     */
    public double computePercentError(int choice, int n1, int n2) 
    {

        double size1 = robustTimeAlgorithm(choice, n1);
        double size2 = robustTimeAlgorithm(choice, n2);

        double estimate = estimateTiming(choice, n1, size1, n2);

        double error = percentError(size2, estimate);


        return error;
    }
}