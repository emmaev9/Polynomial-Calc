import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public Regex() {}
    public Polynomial result(String s) {
        Polynomial poly = new Polynomial();
        List<Monomial> monomials = new ArrayList<>();

        String monomialFormat = "([+-]?[\\d\\.]*[a-zA-Z]?\\^?\\d*)";
        String monomialPartsFormat = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";
        Pattern pattern = Pattern.compile(monomialFormat);
        Matcher matcher = pattern.matcher(s);
        while(!matcher.hitEnd()) {
            matcher.find();
            Pattern patern2 = Pattern.compile(monomialPartsFormat);
            Matcher matcher2 = patern2.matcher(matcher.group());
            int exp = 0;
            double coef = 0;
            if (matcher2.find()) {
                try {
                        coef = Double.valueOf(matcher2.group(1));
                }catch(NumberFormatException e){
                    coef = 1;
                    if(matcher2.group(0).contains("-"))
                        coef = -coef;
                }
                try {
                    if(numeric(matcher2.group(3))){
                        exp = Integer.valueOf(matcher2.group(3));
                    }
                    else {
                        if(matcher2.group(2).equals("X"))
                            exp = 1;
                        else
                            exp = 0;
                    }
                }catch(NumberFormatException e){
                    exp =1;
                }
            }
            Monomial m = new Monomial(exp, coef);
            monomials.add(m);
        }
        poly.setM(monomials);
        return poly;

    }
    public static boolean numeric(String str) {
        return str.matches("[+-]*\\d*\\.?\\d+");
    }
}
