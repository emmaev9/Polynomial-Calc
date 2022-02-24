public class Monomial {
    private int exp;
    private double coef;

    public Monomial(int exp, double coef) {
        this.exp = exp;
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }
}
