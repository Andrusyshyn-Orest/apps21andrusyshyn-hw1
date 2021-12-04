package ua.edu.ucu.tempseries;

import java.util.Arrays;

import static java.lang.Math.*;

public class TemperatureSeriesAnalysis {
    private double [] temperatureSeries;
    private int length;
    private int size;
    static final double ABS_ZERO = -273;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[] {};
        this.length = 0;
        this.size = 0;
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (!this.validateTemps(temperatureSeries)){
            throw new IllegalArgumentException();
        }
        this.length = temperatureSeries.length;
        this.size = length;
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, this.length);
    }
    
    private boolean validateTemps(double [] temperatureSeries){
        for (double temperature:temperatureSeries) {
            if (temperature < this.ABS_ZERO) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmpty(){
        if (this.length == 0){
            return true;
        }
        return false;
    }

    public double average() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (double temperature: this.temperatureSeries) {
            sum += temperature;
        }

        return sum/this.length;
    }

    public double deviation() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }
        double mean = this.average();
        double sumOfSquares = 0;
        for (double temperature: this.temperatureSeries) {
            sumOfSquares += pow((temperature - mean), 2);
        }
        double variance = sumOfSquares/this.length;

        return sqrt(variance);
    }

    public double min() {
        return findTempClosestToValue(this.ABS_ZERO);
    }

    public double max() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }
        double maxTemp = this.temperatureSeries[0];
        for (double temperature: this.temperatureSeries) {
            if (temperature > maxTemp){
                maxTemp = temperature;
            }
        }
        return maxTemp;
    }

    public double findTempClosestToZero() {
        return this.findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }
        double closestTemp = this.temperatureSeries[0];
        double minDistance = abs(closestTemp - tempValue);
        for (int i = 1; i < this.length; i++) {
            double currTemp = this.temperatureSeries[i];
            double diff = abs(currTemp - tempValue);
            if ((diff == minDistance) && (closestTemp < 0) && (currTemp > 0)){
                minDistance = diff;
                closestTemp = currTemp;
            }
            else if (diff < minDistance){
                minDistance = diff;
                closestTemp = currTemp;
            }
            else{
                continue;
            }
        }
        return closestTemp;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (this.isEmpty()) {
            return new double[0];
        }
        boolean [] boolArr = new boolean[this.length];
        int boolArrTrueLen = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.temperatureSeries[i] < tempValue){
                boolArr[i] = true;
                boolArrTrueLen++;
            }
            else{
                boolArr[i] = false;
            }
        }

        if (boolArrTrueLen == 0){
            return new double[0];
        }

        double [] lessTemps = new double[boolArrTrueLen];
        int counter = 0;
        for (int i = 0; i < this.length; i++) {
            if (boolArr[i]){
                lessTemps[counter] = this.temperatureSeries[i];
                counter++;
            }
        }
        return lessTemps;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (this.isEmpty()) {
            return new double[0];
        }
        boolean [] boolArr = new boolean[this.length];
        int boolArrTrueLen = 0;
        for (int i = 0; i < this.length; i++) {
            if (this.temperatureSeries[i] >= tempValue){
                boolArr[i] = true;
                boolArrTrueLen++;
            }
            else{
                boolArr[i] = false;
            }
        }

        if (boolArrTrueLen == 0){
            return new double[0];
        }

        double [] lessTemps = new double[boolArrTrueLen];
        int counter = 0;
        for (int i = 0; i < this.length; i++) {
            if (boolArr[i]){
                lessTemps[counter] = this.temperatureSeries[i];
                counter++;
            }
        }
        return lessTemps;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }
        double avgTemp = this.average();
        double devTemp = this.deviation();
        double minTemp = this.min();
        double maxTemp = this.max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps) {
        if ((temps.length != 0) && (this.length == 0)){
            this.expandTempList(1);
        }

        for (double temperature: temps) {
            if (this.size == this.length){
                this.expandTempList(2*this.length);
            }
            this.temperatureSeries[this.size] = temperature;
            this.size++;
        }
        return 0;
    }

    private boolean expandTempList(int newLength){
        if (newLength < this.length){
            throw new IllegalArgumentException();
        }
        double [] expandedArr = new double[newLength];
        for (int i = 0; i < this.size; i++) {
            expandedArr[i] = this.temperatureSeries[i];
        }
        this.length = newLength;
        this.temperatureSeries = expandedArr;
        return true;
    }

    public double[] getTemperatureSeries() {
        return temperatureSeries;
    }

    public int getLength() {
        return length;
    }

    public int getSize() {
        return size;
    }
}
