/**
 * 
 */
package org.hamster.project_euler.util;

import java.math.BigInteger;

/**
 * for fraction calculation
 * 
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class Fraction {
    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        verify();
    }

    /**
     * add operation
     * 
     * @param n
     * @param d
     * @return
     */
    public Fraction add(BigInteger n, BigInteger d) {
        numerator = numerator.multiply(d).add((denominator.multiply(n)));
        denominator = denominator.multiply(d);
        verify();
        divideGcd();
        return this;
    }

    /**
     * add operation
     * 
     * @param other
     * @return
     */
    public Fraction add(Fraction other) {
        return add(other.numerator, other.denominator);
    }

    /**
     * multiply operation
     * 
     * @param n
     * @param d
     * @return
     */
    public Fraction multiply(BigInteger n, BigInteger d) {
        numerator = numerator.multiply(n);
        denominator = denominator.multiply(d);
        verify();
        divideGcd();
        return this;
    }

    /**
     * multiply operation
     * 
     * @param other
     * @return
     */
    public Fraction multiply(Fraction other) {
        return multiply(other.numerator, other.denominator);
    }

    private void divideGcd() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    private void verify() {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("denominator is zero");
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * @return the numberator
     */
    public BigInteger getNumerator() {
        return numerator;
    }

    /**
     * @return the denominator
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * @param numberator
     *            the numberator to set
     */
    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    /**
     * @param denominator
     *            the denominator to set
     */
    public void setDenominator(BigInteger denominator) {
        this.denominator = denominator;
    }

}
