import java.util.Collections;
import java.util.List;

public class Polynomial {
    private List<Monomial> polinom;

    public Polynomial(List<Monomial> m) {
        this.polinom = m;
    }
    public Polynomial(){}

    public List<Monomial> getM() {
        return polinom;
    }

    public void setM(List<Monomial> m) {
        this.polinom = m;
    }

    void sortMonomial(List<Monomial> monomials){
        Collections.sort(monomials, new SortByExponent());
    }

    void sortExponentsDesc(List<Monomial> monomials){
        Collections.sort(monomials, new SortByExpDesc());
    }
}
