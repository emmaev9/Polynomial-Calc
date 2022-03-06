import java.util.ArrayList;
import java.util.List;

public class Model {
    public String result;
    List<Polynomial> resultat = new ArrayList<>();
    public Model(){
        reset();
    }
    public void reset(){
        result="";
    }

    Polynomial stringToPolynomial(String s){
        Polynomial newPoly = new Polynomial();
        Regex text = new Regex();
        newPoly = text.result(s);
        return newPoly;
    }

    String getResult(String pol1, String pol2, String operation){
        Operations operations = new Operations();
        Polynomial p1 = stringToPolynomial(pol1);
        Polynomial p2 = stringToPolynomial(pol2);
        Polynomial res = new Polynomial();
        final StringBuilder builder = new StringBuilder();
        if(operation.equals("Add"))   {
            res = operations.add(p1,p2);
        }
        if(operation.equals("Subtract")){
            res = operations.subtract(p1,p2);
        }
        if(operation.equals("Multiply")){
            res = operations.multiply(p1,p2);
        }
        if(operation.equals("Integrate")){
            res = operations.integrate(p1);
        }
        if(operation.equals("Derive")){
            res = operations.derivate(p1);
        }
        if(operation.equals("Divide")){
            resultat = operations.division(p1,p2);
        }

        if(operation.equals("Divide")){
            resultat.get(0).sortExponentsDesc(resultat.get(0).getM());
            resultat.get(1).sortExponentsDesc(resultat.get(1).getM());
            for (Monomial mon : resultat.get(0).getM()) {
                builder.append(mon.toString());
            }
            builder.append("  Rest: ");
            if(resultat.get(1).getM().size() == 0){
                builder.append("0");
            }
            else {
                for (Monomial mon : resultat.get(1).getM()) {
                    builder.append(mon.toString());
                }
            }
        }
        else {
            res.sortExponentsDesc(res.getM());
            for (Monomial mon : res.getM()) {
                builder.append(mon.toString());
            }
        }
        this.result = builder.toString();
        return result;
    }

}
