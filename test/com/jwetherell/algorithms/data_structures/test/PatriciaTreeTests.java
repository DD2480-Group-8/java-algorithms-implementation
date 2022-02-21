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

    // @BeforeAll not available in junit 4.
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

        String bstName = "PatriciaTrie";
        PatriciaTrie<String> bst = new PatriciaTrie<String>();
        Collection<String> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, String.class, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, String.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
    }

    @AfterClass
    public static void tearDown() {
        // perform all the teardown work
        System.out.printf("%.1f%% of branches are covered. \n", CoverageMeasurer.getCoverage() * 100);
        System.out.println("The branches _not_ covered by the test class are: ");
        System.out.printf("%s \n", Arrays.toString(CoverageMeasurer.getUnvisitedBranchInfo()));
        CoverageMeasurer.teardown();

        testClass = null;
    }
}
