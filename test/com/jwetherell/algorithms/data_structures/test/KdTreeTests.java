package com.jwetherell.algorithms.data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.KdTree;
import com.jwetherell.algorithms.data_structures.KdTree.XYZPoint;
import com.jwetherell.algorithms.CoverageMeasurer;

public class KdTreeTests {

    

    @Test
    public void testKdTree() {
        CoverageMeasurer.setup(15);

        List<XYZPoint> points = new ArrayList<XYZPoint>();
        XYZPoint p1 = new XYZPoint(2, 3);
        points.add(p1);
        XYZPoint p2 = new XYZPoint(5, 4);
        points.add(p2);
        XYZPoint p3 = new XYZPoint(9, 6);
        points.add(p3);
        XYZPoint p4 = new XYZPoint(4, 7);
        points.add(p4);
        XYZPoint p5 = new XYZPoint(8, 1);
        points.add(p5);
        XYZPoint p6 = new XYZPoint(7, 2);
        points.add(p6);
        KdTree<XYZPoint> kdTree = new KdTree<XYZPoint>(points);

        Collection<XYZPoint> result = kdTree.nearestNeighbourSearch(1, p3);
        assertTrue("K-D Tree query error. query=(k=1, p=(9, 6)) returned="+result, result.contains(p3));

        XYZPoint search = new XYZPoint(1, 4);
        result = kdTree.nearestNeighbourSearch(4, search);
        assertTrue("K-D Tree query error. query=(k=4, p=(1, 4)) returned="+result, (result.contains(p1) &&
                                                                                    result.contains(p2) &&
                                                                                    result.contains(p4) &&
                                                                                    result.contains(p6))
        );

        //NEW TESTCASE 1
        search = new XYZPoint(7, 5);
        result = kdTree.nearestNeighbourSearch(1, search);
        assertTrue("K-D Tree query error. query=(k=1, p=(7, 5)) returned="+result, result.contains(p2) &&
                                                                                   result.contains(p3));

        //NEW TESTCASE 2
        XYZPoint p7 = new XYZPoint(10, 10);
        points.add(p7);
        XYZPoint p8 = new XYZPoint(12, 12);
        points.add(p8);
        XYZPoint p9 = new XYZPoint(20, 22);
        points.add(p9);
        XYZPoint p10 = new XYZPoint(71, 28);
        points.add(p10);
        KdTree<XYZPoint> kdTree2 = new KdTree<XYZPoint>(points);

        search = new XYZPoint(80, 30);
        result = kdTree2.nearestNeighbourSearch(1, search);
        assertTrue("K-D Tree query error. query=(k=1, p=(7, 5)) returned="+result, result.contains(p10));

        kdTree.remove(p6);
        kdTree.remove(p4);
        kdTree.remove(p3);
        kdTree.remove(p5);
        kdTree.remove(p1);
        kdTree.remove(p2);

        kdTree2.remove(p6);
        kdTree2.remove(p4);
        kdTree2.remove(p3);
        kdTree2.remove(p5);
        kdTree2.remove(p1);
        kdTree2.remove(p2);
        kdTree2.remove(p8);
        kdTree2.remove(p9);
        kdTree2.remove(p7);
        kdTree2.remove(p10);
                                             
        System.out.printf("%s%% of branches are covered in KDTree.%n", CoverageMeasurer.getCoverage()* 100);
        CoverageMeasurer.teardown();

    }

    @Test
    public void testKdTree_as_iterable() {
        List<XYZPoint> points = new ArrayList<XYZPoint>();
        XYZPoint p1 = new XYZPoint(2, 3);
        points.add(p1);
        XYZPoint p2 = new XYZPoint(5, 4);
        points.add(p2);
        XYZPoint p3 = new XYZPoint(9, 6);
        points.add(p3);
        XYZPoint p4 = new XYZPoint(4, 7);
        points.add(p4);
        XYZPoint p5 = new XYZPoint(8, 1);
        points.add(p5);
        XYZPoint p6 = new XYZPoint(7, 2);
        points.add(p6);
        KdTree<XYZPoint> kdTree = new KdTree<XYZPoint>(points);

        for (final XYZPoint p : kdTree)
           assertTrue(kdTree.contains(p));
    }
}
