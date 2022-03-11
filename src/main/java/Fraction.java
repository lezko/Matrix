public class Fraction {
    private long numerator;
    private long denomerator;
    
    public Fraction(long numerator, long denomerator) throws Exception {
        if (denomerator == 0) {
            throw new Exception("Null denomerator");
        }
        this.numerator = numerator;
        this.denomerator = denomerator;
        shorten();
    }
    
    public Fraction(long number) throws Exception {
        this(number, 1);
    }
    
    public Fraction() throws Exception {
        this(0, 1);
    }
    
    public void reInit(long numerator, long denomerator) throws Exception {
        if (denomerator == 0) {
            throw new Exception("Null denomerator");
        }
        this.numerator = numerator;
        this.denomerator = denomerator;
        shorten();
    }
    
    public void reInit(long numerator) {
        this.numerator = numerator;
        this.denomerator = 1;
    }
    
    public double toDouble() {
        return (double) numerator / (double) denomerator;
    }

    public void add(Fraction fraction) {
        numerator = numerator * fraction.getDenomerator() + fraction.getNumerator() * denomerator;
        denomerator = denomerator * fraction.getDenomerator();
        shorten();
    }
    
    public static Fraction add(Fraction fraction1, Fraction fraction2) throws Exception {
        Fraction result = fraction1.copy();
        result.add(fraction2);
        return result;
    }
    
    public void sub(Fraction fraction) throws Exception {
        this.add(new Fraction(-fraction.getNumerator(), fraction.getDenomerator()));
    }
    
    public static Fraction sub(Fraction fraction1, Fraction fraction2) throws Exception {
        Fraction result = new Fraction(fraction1.getNumerator(), fraction1.getDenomerator());
        result.sub(fraction2);
        return result;
    }
    
    public void mult(Fraction fraction){
        this.numerator *= fraction.getNumerator();
        this.denomerator *= fraction.getDenomerator();
        shorten();
    }
    
    public static Fraction mult(Fraction fraction1, Fraction fraction2) throws Exception {
        Fraction result = new Fraction(fraction1.getNumerator(), fraction1.getDenomerator());
        result.mult(fraction2);
        return result;
    }
    
    public void div(Fraction fraction) throws Exception {
        this.mult(new Fraction((fraction.getNumerator() < 0 ? -1 : 1) * fraction.getDenomerator(),
        (fraction.getNumerator() < 0 ? -1 : 1) * fraction.getNumerator()));
    }
    
    public static Fraction div(Fraction fraction1, Fraction fraction2) throws Exception {
        Fraction result = fraction1.copy();
        result.div(fraction2);
        return result;
    }
    
    public void mod(Fraction fraction) throws Exception {
        Fraction dividedFraction = this.copy();
        dividedFraction.div(fraction);
        numerator = dividedFraction.getNumerator() % dividedFraction.getDenomerator();
        denomerator = dividedFraction.denomerator;
    }
    
    public static Fraction mod(Fraction fraction1, Fraction fraction2) throws Exception {
        Fraction result = fraction1.copy();
        result.mod(fraction2);
        return result;
    }
    
    public int equals(Fraction fraction) {
        return Long.compare(numerator * fraction.getDenomerator(), denomerator * fraction.getNumerator());
    }
    
    public int equals(long k) {
        return Long.compare(numerator, denomerator * k);
    }
    
    public Fraction copy() throws Exception {
        return new Fraction(numerator, denomerator);
    }
    
    public long getNumerator() {
        return numerator;
    }
    
    public long getDenomerator() {
        return denomerator;
    }
    
    private void shorten() {
        for (long i = denomerator; i > 1; i--) {
            if (numerator % i == 0 && denomerator % i == 0) {
                numerator /= i;
                denomerator /= i;
            }
        }
    }
}
