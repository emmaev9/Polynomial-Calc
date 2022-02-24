import java.util.List;

public class Polynomial {
    private List<Monomial> m;

    public Polynomial(List<Monomial> m) {
        this.m = m;
    }

    public List<Monomial> getM() {
        return m;
    }

    public void setM(List<Monomial> m) {
        this.m = m;
    }
}
