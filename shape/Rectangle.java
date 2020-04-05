package horstmann4chapter.shape;

import horstmann4chapter.point.Point2;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(Point2 topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point2 getCenter() {
        return super.point;
    }

    public Rectangle clone() {
        return new Rectangle(super.point,width,height);
    }
}
