public class Monomial {
    private int exp;
    private double coef;
    private boolean foundMonomial;

    public Monomial(int exp, double coef) {
        this.exp = exp;
        this.coef = coef;
    }
    public boolean isFoundMonomial() {
        return foundMonomial;
    }

    public void setFoundMonomial(boolean foundMonomial) {
        this.foundMonomial = foundMonomial;
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

    @Override
    public String toString( ) {
        if( coef == 0 )
            return "";
        else if(coef ==0 && exp == 0)
            return  "";
        else if( exp == 0 && coef > 0 )
            return "+" + coef;
        else if( exp == 0 && coef < 0 )
            return  coef + "";
        else if(coef == 1 && exp > 1){
            return "+X^" + exp;
        }
        else if( coef == 1 && exp == 1 )
            return "+X";
        else if( exp > 0 && coef > 0 )
            return "+" + coef + "*X^" + exp;
        else
            return coef + "*X^" + exp;
    }
}
