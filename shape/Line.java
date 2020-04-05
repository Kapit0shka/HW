package horstmann4chapter.shape;

import horstmann4chapter.point.Point2;

public class Line extends Shape{
    private Point2 to;

    public Line(Point2 from, Point2 to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point2 getCenter() {
        return super.point;
    }

    public Line clone() {
        return new Line(super.point, to);
    }
}
