package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.*;

import com.jwetherell.algorithms.data_structures.PatriciaTrie;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.TreeTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class PatriciaTreeTests {
    private static PatriciaTreeTests testClass = null;

    /**
     * Setup function with conditional to only run when the test class is instantiated.
     * This is done to let us see how the branch coverage is affected by the entire test class.
     */
    @Before
    public void setUp() {
        if (testClass == null) {
            testClass = this;
            // perform all the setup code
            CoverageMeasurer.setup(26);
        }
    }

    @Test
    public void testPatriciaTrie() {
        TestData data = Utils.generateTestData(1000);
//        System.out.println(data.string);

        String bstName = "PatriciaTrie";
        PatriciaTrie<String> bst = new PatriciaTrie<String>();
        Collection<String> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, String.class, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, String.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
    }

    /**
     * Add duplicates to the PatriciaTrie
     * The .add() method of the PatriciaTrie class calls .addSequence(),
     * which will return null in case of duplicate to .add(), which in turn will return
     * false to the caller.
     * Will increase the branch coverage by covering 22.
     */
    @Test
    public void testPatriciaTrieAddDuplicates() {
        System.out.println("Adding duplicates...");
        PatriciaTrie<String> duplicateTree = new PatriciaTrie<>();
        duplicateTree.add("Add");
        Assert.assertFalse(duplicateTree.add("Add"));
    }

    /**
     * Runs between every test case to see how coverage improves.
     */
    @After
    public void branchUpdateBetweenTestCases() {
        System.out.printf("%.1f%% of branches are covered. \n", CoverageMeasurer.getCoverage() * 100);
        System.out.println("The branches _not_ covered by the test class are: ");
        System.out.printf("%s \n", Arrays.toString(CoverageMeasurer.getUnvisitedBranchInfo()));
    }

    /**
     * Teardown function to reset the test class after finishing.
     */
    @AfterClass
    public static void tearDown() {
        // perform all the teardown work
        CoverageMeasurer.teardown();

        testClass = null;
    }
}
