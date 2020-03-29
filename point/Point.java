package horstmann2chapter.point;

public class Point {
    private double x = 0.0;
    private double y = 0.0;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point translate(double deltaX, double deltaY) {
        return (new Point(this.x + deltaX,this.y + deltaY));
    }

    public Point scale(double coefficient) {
        return (new Point(this.x * coefficient, this.y * coefficient));
    }
}
