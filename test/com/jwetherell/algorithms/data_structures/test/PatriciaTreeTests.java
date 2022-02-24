package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import com.jwetherell.algorithms.CoverageMeasurer;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.PatriciaTrie;
import com.jwetherell.algorithms.data_structures.test.common.JavaCollectionTest;
import com.jwetherell.algorithms.data_structures.test.common.TreeTest;
import com.jwetherell.algorithms.data_structures.test.common.Utils;
import com.jwetherell.algorithms.data_structures.test.common.Utils.TestData;

public class PatriciaTreeTests {

    @Test
    public void testPatriciaTrie() {
        TestData data = Utils.generateTestData(1000);

        CoverageMeasurer.setup(26);
        String bstName = "PatriciaTrie";
        PatriciaTrie<String> bst = new PatriciaTrie<String>();
        Collection<String> bstCollection = bst.toCollection();



        assertTrue(TreeTest.testTree(bst, String.class, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, String.class, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
        System.out.printf("%s%% of branches are covered in PatriciaTrie.%n", CoverageMeasurer.getCoverage()* 100);

        CoverageMeasurer.teardown();
    }
}
