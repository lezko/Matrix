import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    Fraction fraction = new Fraction();
    Fraction fraction2 = new Fraction();
    Fraction fraction3 = new Fraction();
    
    FractionTest() throws Exception {
    }
    
    @Test
    void test01() {
        fraction.reInit(5);
        assertEquals(5.0, fraction.toDouble());
    }
    
    @Test
    void test02() throws Exception {
        fraction.reInit(2, 3);
        assertEquals(2.0 / 3.0, fraction.toDouble());
    }
    
    @Test
    void test03() throws Exception {
        fraction.reInit(10, 5);
        assertEquals(2.0, fraction.toDouble());
    }
    
    @Test
    void test04() throws Exception {
        fraction.reInit(2, 3);
        fraction2.reInit(4, 7);
        fraction.add(fraction2);
        assertEquals(26.0 / 21.0, fraction.toDouble());
    }
    
    
    
    
    
    @Test
    void test05() throws Exception {
        fraction.reInit(6, 4);
        assertEquals(3.0, fraction.getNumerator());
    }
    
    @Test
    void test06() throws Exception {
        fraction.reInit(6, 4);
        assertEquals(2.0, fraction.getDenomerator());
    }
    
    
    @Test
    void test07() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(-2, 4);
        fraction.add(fraction2);
        assertEquals(1.0, fraction.toDouble());
    }
    
    @Test
    void test08() throws Exception {
        fraction.reInit(6, 4);
        fraction.sub(new Fraction(2, 4));
        assertEquals(1.0, fraction.toDouble());
    }
    
    @Test
    void test09() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(-2, 4);
        fraction.mult(fraction2);
        assertEquals(-12.0 / 16, fraction.toDouble());
    }
    
    @Test
    void test10() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(2, 4);
        fraction.div(fraction2);
        assertEquals(3, fraction.toDouble());
    }
    
    @Test
    void test11() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(-2, 4);
        fraction.div(fraction2);
        assertEquals(-3, fraction.toDouble());
    }
    
    @Test
    void test12() throws Exception {
        fraction.reInit(7, 4);
        fraction2.reInit(-3, 10);
        fraction.div(fraction2);
        assertEquals(-35.0 / 6.0, fraction.toDouble());
    }
    
    @Test
    void test13() throws Exception {
        fraction.reInit(7, 4);
        fraction2.reInit(3, 10);
        fraction3 = Fraction.mod(fraction, fraction2);
        assertEquals(5.0 / 6.0, fraction3.toDouble());
    }
    
    @Test
    void test14() throws Exception {
        fraction.reInit(7, 4);
        fraction2.reInit(-3, 10);
        fraction3 = Fraction.mod(fraction, fraction2);
        assertEquals(-5.0 / 6.0, fraction3.toDouble());
    }
    
    @Test
    void test15() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(-2, 4);
        
        assertEquals(1, fraction.equals(fraction2));
    }
    
    @Test
    void test16() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(-2, 4);

        assertEquals(-1,fraction.equals(2));
    }
    
    @Test
    void test17() throws Exception {
        fraction.reInit(6, 4);
        fraction2.reInit(2, 4);
        fraction.mod(fraction2);
        assertEquals(0, fraction.toDouble());
    }
    
    @Test
    void test18() throws Exception {
        fraction.reInit(7, 4);
        fraction2.reInit(3, 10);
        fraction.mod(fraction2);
        assertEquals(5.0 / 6.0, fraction.toDouble());
    }
}