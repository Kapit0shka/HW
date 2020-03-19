package com.company;

import java.lang.reflect.Type;
import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;


    public  MyTriangle(int x1, int y1,int x2, int y2,int x3, int y3){
        v1 = new MyPoint(x1,y1);
        v2 = new MyPoint(x2,y2);
        v3 = new MyPoint(x3,y3);
    }

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public String toString() {
        return "MyTriangle[" +
                "v1=(" + v1.getX() + ','+ v1.getY() +
                "), v2=(" + v2.getX() + ','+ v2.getY() +
                "), v3=(" + v3.getX() + ','+ v3.getY() +
                ")]";
    }

    public enum TypeOfTriangle{
        SCALENE("Scalene"),
        ISOSCELES("Isosceles"),
        EQUILATERAL("Equilateral");

        private  String type;
        TypeOfTriangle(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public double getPerimeter() {
        return (v1.distance(v2)+v2.distance(v3)+v3.distance(v1));
    }

    public String getType() {
        final double threshold = 0.00001;
        if (Math.abs(v1.distance(v2)-v2.distance(v3)) > threshold) {
            if (Math.abs(v2.distance()-v3.distance(v1)) > threshold & Math.abs(v1.distance(v2)-v3.distance(v1)) > threshold){
                return TypeOfTriangle.SCALENE.getType();
            }
            else {
                return TypeOfTriangle.ISOSCELES.getType();
            }
        }
        else {
            return TypeOfTriangle.EQUILATERAL.getType();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) &&
                Objects.equals(v2, that.v2) &&
                Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }
}
