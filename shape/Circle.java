package horstmann4chapter.shape;

import horstmann4chapter.point.Point2;

public class Circle extends Shape {
    private double radius;

    public Circle(Point2 center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point2 getCenter() {
        return super.point;
    }

    public Circle clone() {
        return new Circle(super.point,radius);
    }
}
