package com.jwetherell.algorithms;

public class CoverageMeasurer {

    public static boolean[] branches = new boolean[4];

    public static void setBranches(int numberOfBranches) {
        branches = new boolean[numberOfBranches];
    }

    public static boolean[] getCoverage() {
        return branches;
    }

}
