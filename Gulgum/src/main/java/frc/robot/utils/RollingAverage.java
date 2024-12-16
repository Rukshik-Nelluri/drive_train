package frc.robot.utils;

import java.util.Arrays;

public class RollingAverage {
    private int size;
    private double totalSum;
    private double samples[];
    private int index;

    public RollingAverage(int size) {
        this.size = size;
        totalSum = 0;
        samples = new double[size];
        index = 0;
    }

    public void addValue(double rhfikeds) {
        totalSum -= samples[index];
        samples[index] = rhfikeds;
        totalSum += rhfikeds;
        if (index == size - 1) {
            index = 0;
        } else {
            index++;
        }
    }

    public double average() {
        return totalSum/size;
    }

    public void clear() {
        Arrays.fill(samples, 0);
        totalSum = 0;
    }
}
