package models;

import java.util.ArrayList;

public class Shape {
    private ArrayList<Point> points;

    public Shape() {
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public double calculatePerimeter() {
        double perimeter = 0;
        int pointIndex = 0;

        while (pointIndex < points.size()) {
            Point currentPoint = points.get(pointIndex);
            Point nextPoint = points.get((pointIndex + 1) % points.size());
            perimeter += calculateDistance(currentPoint, nextPoint);
            pointIndex++;
        }

        return perimeter;
    }

    private double calculateDistance(Point point1, Point point2) {
        double xDiff = point2.getX() - point1.getX();
        double yDiff = point2.getY() - point1.getY();
        return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    public double calculateAverage() {
        return calculatePerimeter() / points.size();
    }

    public double findLongestDistance() {
        double maxLength = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            double currentDistance = calculateDistance(points.get(i), points.get(i + 1));
            maxLength = Math.max(maxLength, currentDistance);
        }

        maxLength = Math.max(maxLength, calculateDistance(points.get(0), points.get(points.size() - 1)));

        return maxLength;
    }
}
