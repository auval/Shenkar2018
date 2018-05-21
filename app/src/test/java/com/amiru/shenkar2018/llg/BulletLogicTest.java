package com.amiru.shenkar2018.llg;

import android.graphics.PointF;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BulletLogicTest {

    BulletLogic bl;
    PointF pt;

    @Before
    public void setUp() throws Exception {

        bl = new BulletLogic();
        pt = new PointF();
    }

    @Test
    public void calculateBulletLocation0() {
        bl.calculateBulletLocation(pt, 0, 0, 0, 0);
        // the delta param is needed to compare double or float
        assertEquals(pt.x, 0.0d, 0.001);
        assertEquals(pt.y, 0.0d, 0.001);
    }

    @Test
    public void calculateBulletLocation1() {

        bl.calculateBulletLocation(pt, 100, 0, 0, 5000);
        assertEquals(pt.x, 2500.0d, 0.001);
        assertEquals(pt.y, 3062.5d, 0.001);
    }

}