import java.util.ArrayList;
import java.util.List;

public class Operations {

    public Polynomial add(Polynomial P, Polynomial Q){
        List<Monomial> monRez = new ArrayList<>();
        Monomial m;
        Polynomial polRes = new Polynomial();
        for (Monomial mon1: P.getM()) {
            for(Monomial mon2:Q.getM()){
                if(mon1.getExp() == mon2.getExp()){
                    mon1.setFoundMonomial(true);
                    mon2.setFoundMonomial(true);
                     m = new Monomial(mon1.getExp(), mon1.getCoef()+mon2.getCoef());
                     monRez.add(m);
                }
             }
        }
        for(Monomial mon1: P.getM()){
            if(!mon1.isFoundMonomial()){
                m = new Monomial(mon1.getExp(), mon1.getCoef());
                monRez.add(m);
            }
        }
        for(Monomial mon2: Q.getM()){
            if(!mon2.isFoundMonomial()){
                m = new Monomial(mon2.getExp(), mon2.getCoef());
                monRez.add(m);
            }
        }
        polRes.setM(monRez);
        deleteZero(polRes);
        return  polRes;
    }
    public Polynomial subtract(Polynomial P, Polynomial Q){
        List<Monomial> monRez = new ArrayList<>();
        Monomial m;
        Polynomial polRes = new Polynomial();
        for (Monomial mon1: P.getM()) {
            for(Monomial mon2:Q.getM()) {
                if (mon1.getExp() == mon2.getExp()) {
                    mon1.setFoundMonomial(true);
                    mon2.setFoundMonomial(true);
                    m = new Monomial(mon1.getExp(), mon1.getCoef() - mon2.getCoef());
                    monRez.add(m);
                }
            }
        }
        for(Monomial mon1: P.getM()){
            if(!mon1.isFoundMonomial()){
                m = new Monomial(mon1.getExp(), mon1.getCoef());
                monRez.add(m);
            }
        }
        for(Monomial mon2: Q.getM()){
            if(!mon2.isFoundMonomial()){
                m = new Monomial(mon2.getExp(), 0-mon2.getCoef());
                monRez.add(m);
            }
        }
        polRes.setM(monRez);
        deleteZero(polRes);
        return  polRes;
    }

    public Polynomial multiply(Polynomial P, Polynomial Q) {
        List<Monomial> monRez = new ArrayList<>();
        Monomial m;
        for (Monomial mon1: P.getM()) {
            for(Monomial mon2:Q.getM()){
                if(mon1.getCoef()!= 0 && mon2.getCoef()!= 0){
                    mon1.setFoundMonomial(true);
                    mon2.setFoundMonomial(true);
                    m = new Monomial(mon1.getExp() + mon2.getExp(), mon1.getCoef()*mon2.getCoef());
                    monRez.add(m);
                }
            }
        }
        Polynomial polRez = new Polynomial(monRez);
        polRez.sortMonomial(monRez);
        List<Monomial> monRez2 = polRez.getM();

        for(int i=0;i<monRez2.size()-1;i++){
           for(int j=i+1;j<monRez2.size();j++){
               if(monRez2.get(i).getExp() == monRez2.get(j).getExp()){
                   monRez2.get(i).setCoef(monRez2.get(i).getCoef() + monRez2.get(j).getCoef());
                   monRez2.remove(monRez2.get(j));
               }
           }
        }
        addMonoms(monRez2);
        polRez.setM(monRez2);

        deleteZero(polRez);
        return polRez;
    }

    public void addMonoms(List<Monomial> mon){
        List<Monomial> result = new ArrayList<>();
        for(int i=0;i<mon.size()-1;i++){
            for(int j=i+1;j<mon.size();j++){
                if(mon.get(i).getExp() == mon.get(j).getExp()){
                    mon.get(i).setCoef(mon.get(i).getCoef() + mon.get(j).getCoef());
                    mon.remove(mon.get(j));
                }
            }
        }
    }
    public Polynomial derivate(Polynomial P){
        List<Monomial> monRez = new ArrayList<>();
        Monomial m;
        for(Monomial mon: P.getM()){
            if(mon.getExp() != 0 && mon.getCoef()!=0){
                m = new Monomial(mon.getExp()-1, mon.getCoef()*(mon.getExp()));
                monRez.add(m);
            }
        }
        Polynomial poly = new Polynomial(monRez);
        deleteZero(poly);
        return poly;
    }

    public Polynomial integrate(Polynomial P){
        List<Monomial> monRez = new ArrayList<>();
        Monomial m;
        for(Monomial mon: P.getM()){
            if(mon.getCoef()!=0){
                m = new Monomial(mon.getExp()+1, mon.getCoef()*(1.0/(mon.getExp()+1)));
                monRez.add(m);
            }
        }
        Polynomial poly = new Polynomial(monRez);
        deleteZero(poly);
        return poly;
    }

    public List<Polynomial> division(Polynomial P, Polynomial Q){
        P.sortExponentsDesc(P.getM());
        Q.sortExponentsDesc(Q.getM());
        List<Monomial> qList = new ArrayList<>();
        Polynomial quotient = new Polynomial(qList);
        Polynomial reminder;
        List<Monomial> multiplicationList = new ArrayList<>();
        Polynomial resultOfMultiplication = new Polynomial(multiplicationList);
        List<Monomial> ltlist = new ArrayList<>();
        Polynomial leadingTerm = new Polynomial(ltlist);
        Polynomial r;
        if(P.getM().get(0).getExp() < Q.getM().get(0).getExp()){
            qList.add(new Monomial(0,0));
            quotient.setM(qList);
            reminder = Q;
        }
        else {
            reminder = P;
            while (reminder.getM().size()!=0&& reminder.getM().get(0).getExp() >= Q.getM().get(0).getExp() ) {
                reminder.sortExponentsDesc(reminder.getM());
                Monomial m = new Monomial(reminder.getM().get(0).getExp() - Q.getM().get(0).getExp(), reminder.getM().get(0).getCoef() / Q.getM().get(0).getCoef());
                ltlist.add(m);
                leadingTerm.setM(ltlist);
                quotient = add(quotient,leadingTerm);
                resultOfMultiplication=multiply(Q,leadingTerm);
                reminder = subtract(reminder,resultOfMultiplication);
                reminder.sortExponentsDesc(reminder.getM());
                multiplicationList.clear();
                ltlist.clear();
            }
        }
        List<Polynomial> res = new ArrayList<>();
        res.add(quotient);
        res.add(reminder);
        return res;
    }


    void deleteZero(Polynomial p){
        List<Monomial> toDel = new ArrayList<>();
        for(Monomial mon: p.getM()){
            if(mon.getCoef() == 0){
                toDel.add(mon);
            }
        }
        p.getM().removeAll(toDel);
    }
}
