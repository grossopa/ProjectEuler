/**
 * 
 */
package org.hamster.project_euler.test.base;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @since 1.0
 */
public class TestResult {
    private double input = 0D;
    private Number result = 0D;
    
    private TestResult(double input, Number result) {
        this.input = input;
        this.result = result;
    }
    
    /**
     * @return the input
     */
    public double getInput() {
        return input;
    }
    /**
     * @return the result
     */
    public Number getResult() {
        return result;
    }
    
    public static final TestResult create(double input, Number result) {
        return new TestResult(input, result);
    }
}
