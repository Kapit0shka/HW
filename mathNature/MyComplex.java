package mathNature;

import java.util.Objects;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex() {

    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "("
                 + real +
                " + " + imag +
                "i)";
    }

    public boolean isReal(){
        if(real != 0){
            return  true;
        }
        else {
            return false;
        }
    }

    public  boolean isImaginary() {
        if(imag != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean equals(double real, double imag) {
        if (this.real == real & this.imag == imag){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean equals(MyComplex another) {
        if (this.real == another.real & this.imag == another.imag){
            return true;
        }
        else {
            return false;
        }
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(real,2)+Math.pow(imag,2));
    }

    public  double argumet() {
        if(isReal() & !isImaginary()) {
            return(Math.asin(real/magnitude()));        //Math.asin(1);
        }
        if (!isReal() & isImaginary()) {
            return(Math.acos(imag/magnitude()));        //Math.acos(1);
        }
        if (isReal() & isImaginary()){
            return(Math.atan(imag/real));
        }
        else {
            System.out.println("argument value is undefined");
            return 0.0;
        }
    }

    public MyComplex add(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        return (new MyComplex(this.real + right.real,this.imag + right.imag));
    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        return (new MyComplex(this.real - right.real,this.imag - right.imag));
    }

    public MyComplex multiply(MyComplex right){
        this.real = -(this.imag * right.imag) + this.real * right.real;
        this.imag = this.imag * right.real + this.real * right.imag;
        return this;
    }

    public MyComplex divide(MyComplex right) {
        this.multiply(right);
        right.multiply(right);
        this.imag /= right.imag;
        this.real /= right.real;
        return this;
    }
    public MyComplex conjugate() {
        return (new MyComplex(real,-imag));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }
}
