package com.company;

import java.util.Arrays;

public class MyPolynomial {
    private double coeffs[];

    public MyPolynomial(double[] coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String polynomial = "";
        for(int i = coeffs.length-1; i>=2;i--){
            if (coeffs[i]==0.0){
                continue;
            }
            polynomial += Double.toString(coeffs[i]) + "x^" + i + '+';
        }
        polynomial += Double.toString(coeffs[1]) + 'x' + Double.toString(coeffs[0]);
        return polynomial;
    }

    public MyPolynomial add(MyPolynomial right) {
        if (right.coeffs.length < this.coeffs.length) {
            MyPolynomial newPolynomial = new MyPolynomial(this.coeffs);
            for (int i = 0; i<right.coeffs.length;i++){
                newPolynomial.coeffs[i] += right.coeffs[i];
            }
            return newPolynomial;
        }
        else {
            MyPolynomial newPolynomial = new MyPolynomial(right.coeffs);
            for (int i = 0; i < this.coeffs.length; i++) {
                newPolynomial.coeffs[i] += this.coeffs[i];
            }
            return newPolynomial;
        }
    }

    public MyPolynomial multiply(MyPolynomial right) {

        double newCoeffs[] = new double[this.coeffs.length + right.coeffs.length];

        for (int i = 0;i < this.coeffs.length; i++){
            for (int j =0; j < right.coeffs.length; j++){
                newCoeffs[i+j] += this.coeffs[i]*right.coeffs[j];
            }
        }
        MyPolynomial newPolynomial = new MyPolynomial(newCoeffs);
        return newPolynomial;
    }
}
