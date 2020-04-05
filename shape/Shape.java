package horstmann4chapter.shape;

import horstmann4chapter.point.Point2;

public abstract class Shape {
    protected Point2 point;

    public Shape(Point2 point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point = new Point2(point.getX()+dx,point.getY()+dy);
    }

    abstract public Point2 getCenter();
}
