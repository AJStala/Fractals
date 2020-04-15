
package com.eonsahead.fractalset;


public class Complex {
    private final double real;
    private final double imag;
    
    public Complex( double real, double imag ) {
        this.real = real;
        this.imag = imag;
    } // Complex()
    
    public Complex add( Complex z ) {
        double r = this.real + z.real;
        double i = this.imag + z.imag;
        return new Complex( r, i );
    } // add( Complex )
    
    public Complex multiply( Complex z ) {
        // u = (a + bi)
        // v = (c + di)
        // u * v = (a + bi)(c + di)
        //       = ac + bi * di + adi + cbi
        //       = (ac - bd) + (ad + cb)i
        
        double r = this.real * z.real - this.imag * z.imag;
        double i = this.real * z.imag + this.imag * z.real;
        
        return new Complex( r, i);
    } // multiply( Complex )
    
    public double magnitudeSquared() {
        double rSquared = this.real * this.real;
        double iSquared = this.imag * this.imag;
        
        return rSquared + iSquared;
    } // magnitudeSquared()
    
} // Complex
