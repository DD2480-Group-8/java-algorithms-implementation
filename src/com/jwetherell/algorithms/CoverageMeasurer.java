package com.jwetherell.algorithms;

import java.util.Arrays;
import java.util.stream.Stream;

public class CoverageMeasurer {

    // just instantiate to 100 to prevent index error if function is used in other tests.
    private static boolean[] branches = new boolean[100];

    /**
     * Setup function used to specify the number of branches, and other
     * data that might be important for the tool.
     * @param numberOfBranches - the number of branches in the function to be tested.
     */
    public static void setup(int numberOfBranches) {
        setBranches(numberOfBranches);
    }

    /**
     * Teardown function used after each function has been tested,
     * to reset the coverage measurement.
     */
    public static void teardown() {
        setBranches(100);
    }

    /**
     * Used in setup function to set the number of branches.
     * @param numberOfBranches - the number of branches in the function to be tested.
     */
    private static void setBranches(int numberOfBranches) {
        branches = new boolean[numberOfBranches];
    }

    /**
     * used to set a specific branch as visited.
     * @param branchNumber - the branch that is visited.
     */
    public static void visitedBranch(int branchNumber) {
        branches[branchNumber] = true;
    }

    /**
     * calculates how many of the branches have been visited
     * @return a double specifying the ratio of visited-possible branches.
     * to get a percentage, multiply this value by 100.
     */
    public static double getCoverage() {
        double numberOfBranches = branches.length;
        double numberOfVisitedBranches = 0;
        for (boolean b: branches) {
            if (b)
                numberOfVisitedBranches++;
        }

        return numberOfVisitedBranches / numberOfBranches;
    }

    public static double getNumBranches() {
        double numberOfVisitedBranches = 0;
        for (boolean b: branches) {
            if (b)
                numberOfVisitedBranches++;
        }

        return numberOfVisitedBranches;
    }

}
