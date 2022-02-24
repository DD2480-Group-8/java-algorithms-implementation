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
//        System.out.println("-----------\nTesting with random data...\n-----------");
        TestData data = Utils.generateTestData(1000);

        String bstName = "PatriciaTrie";
        PatriciaTrie<String> bst = new PatriciaTrie<String>();
        Collection<String> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, String.class, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, String.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
    }

    /**
     * This test will always cover branch 23, the most frequent node _not_ to be covered
     * by the randomly generated test data.
     */
    @Test
    public void testPatriciaTrieAddExistingBlack() {
//        System.out.println("-----------\nAdding existing black...\n-----------");
        PatriciaTrie<String> p = new PatriciaTrie<>();
        p.add("Add");
        p.add("Ask");
        Assert.assertFalse(p.contains("A")); // if A is black, it is not stored in the Trie.
        p.add("A");
        Assert.assertTrue(p.contains("A"));
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
//        System.out.println("-----------\nAdding duplicates...\n-----------");
        PatriciaTrie<String> duplicateTree = new PatriciaTrie<>();
        duplicateTree.add("Add");

        // add method should return false if char sequence already in trie.
        Assert.assertFalse(duplicateTree.add("Add"));
    }

    /**
//     * Runs between every test case to see how coverage improves.
//     */
//    @After
//    public void branchUpdateBetweenTestCases() {
//        System.out.printf("%.1f%% of branches are covered. \n", CoverageMeasurer.getCoverage() * 100);
//        System.out.println("The branches _not_ covered by the test class are: ");
//        System.out.printf("%s \n", Arrays.toString(CoverageMeasurer.getUnvisitedBranchInfo()));
//    }

    /**
     * Teardown function to reset the test class after finishing.
     */
    @AfterClass
    public static void tearDown() {
        // perform all the teardown work
        System.out.printf("%.1f%% of branches are covered in PatriciaTrie. \n", CoverageMeasurer.getCoverage() * 100);
        CoverageMeasurer.teardown();

        testClass = null;
    }
}
