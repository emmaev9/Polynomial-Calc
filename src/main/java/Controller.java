import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
    private View view;
    private Model model;
    public Controller(View v, Model m){
        this.view = v;
        this.model = m;
        this.view.setPolynomialAddActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actions("Add");
            }
        });

        this.view.setPolynomialSubtractActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actions("Subtract");
            }
        });

        this.view.setPolynomialDivideActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               actions("Divide");
            }
        });

        this.view.setPolynomialMultiplyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               actions("Multiply");
            }
        });

        this.view.setPolynomialIntegrateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               actions("Integrate");
            }
        });

        this.view.setPolynomialDeriveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               actions("Derive");
            }
        });
    }
    public void actions(String operation){
        String input1 = view.getTextFeild1Value();
        String input2 = view.getTextFeild2Value();
        String r = model.getResult(input1, input2, operation);
        if(r == ""){
            view.textFieldResult.setText("0");
        }
        else
            view.textFieldResult.setText(r);
    }
}
