package ua.edu.ucu.tempseries;

import static java.lang.Math.sqrt;
import static org.junit.Assert.*;
import org.junit.Test;

public class TemperatureSeriesAnalysisTest {


    @Test(expected = IllegalArgumentException.class)
    public void testNotValidTemps() {
        double[] temperatureSeries = {-1.0, -274.73 , 30.0};
        // expect exception here
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArrayDefaultConstructor() {
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis();

        // expect exception here
        seriesAnalysis2.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = sqrt(14);

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.min();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.max();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testFindClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindClosestToZero() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.2, 0.2, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;
        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();
        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(-3.0);
    }

    @Test
    public void testFindClosestToValue() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.35, 0.1, 0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.1;
        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToValue(-0.1);
        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testFindTempsLessThenEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expResult = {};
        // call tested method
        double [] actualResult = seriesAnalysis.findTempsLessThen(0.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenEmptyReturnArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.3, 0.1, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expResult = {};
        // call tested method
        double [] actualResult = seriesAnalysis.findTempsLessThen(-273.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThen() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.3, 0.1, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expResult = {-0.3, -0.2};
        // call tested method
        double [] actualResult = seriesAnalysis.findTempsLessThen(0.1);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenEmptyArray() {
        // setup input data and expected result
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expResult = {};
        // call tested method
        double [] actualResult = seriesAnalysis.findTempsGreaterThen(0.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenEmptyReturnArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.3, 0.1, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expResult = {};
        // call tested method
        double [] actualResult = seriesAnalysis.findTempsGreaterThen(273.0);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen() {
        // setup input data and expected result
        double[] temperatureSeries = {-0.3, 0.1, -0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double [] expResult = {0.1, -0.2};
        // call tested method
        double [] actualResult = seriesAnalysis.findTempsGreaterThen(-0.2);
        // compare expected result with actual result
        assertArrayEquals(expResult, actualResult, 0.00001);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expAverage = 1.0;
        double expDeviation = sqrt(14);
        double expMin = -5.0;
        double expMax = 5.0;

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        double actualAverage = actualResult.getAvgTemp();
        double actualDeviation = actualResult.getDevTemp();
        double actualMin = actualResult.getMinTemp();
        double actualMax = actualResult.getMaxTemp();

        assertEquals(expAverage, actualAverage, 0.00001);
        assertEquals(expDeviation, actualDeviation, 0.00001);
        assertEquals(expMin, actualMin, 0.00001);
        assertEquals(expMax, actualMax, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.addTemps(1.0, 2.0 ,3.0, 4.0, 5.0, 6.0, 7.0);
        double [] expArr = new double[8];
        expArr[0] = 1.0;
        expArr[1] = 2.0;
        expArr[2] = 3.0;
        expArr[3] = 4.0;
        expArr[4] = 5.0;
        expArr[5] = 6.0;
        expArr[6] = 7.0;

        double [] actualArr  = seriesAnalysis.getTemperatureSeries();

        int expLength = 8;
        int expSize = 7;

        int actualLength = seriesAnalysis.getLength();
        int actualSize = seriesAnalysis.getSize();

        assertArrayEquals(expArr, actualArr, 0.00001);
        assertEquals(expLength, actualLength, 0.00001);
        assertEquals(expSize, actualSize, 0.00001);

    }
}
