import java.util.Comparator;

public class SortByExpDesc implements Comparator<Monomial> {
    @Override
    public int compare(Monomial o1, Monomial o2) {
        return o2.getExp()- o1.getExp();
    }
}