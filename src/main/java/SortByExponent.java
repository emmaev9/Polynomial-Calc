import java.util.Comparator;

public class SortByExponent implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        return o1.getExp()- o2.getExp();
    }
}
