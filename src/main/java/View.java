import java.util.LinkedList; //import linked list library
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View {
    JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn;
    JButton sixBtn,sevenBtn, eightBtn, nineBtn, zeroBtn;
    JButton addBtn, subtractBtn, multiplyBtn, divideBtn, powBtn;
    JButton delBtn, equalsBtn, xBtn;
    JButton multiplicateOp, substractOp, divideOp, derivateOp, addOp, integrateOp;
    JTextField textFieldPol1, textFieldPol2, textFieldResult;

    JFrame frame;

    JPanel numbersPanel, signsPanel, operationsPanel, inputPanel;

    JLabel pol1, pol2, name, res;

    View()
    {
        frame = new JFrame("Polynomial Calculator");
        frame.setSize(450,450);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel inputPanel = new JPanel();
        JPanel numbersPanel = new JPanel();
        JPanel signsPanel = new JPanel();
        JPanel operationsPanel = new JPanel();

        inputPanel = inputPan(inputPanel);
        numbersPanel = numberPan(numbersPanel);
        signsPanel = signPan(signsPanel);
        operationsPanel = operationPan(operationsPanel);

        frame.setBackground(new java.awt.Color(147,100, 255));
        frame.add(inputPanel, BorderLayout.BEFORE_FIRST_LINE);
        frame.add(operationsPanel, BorderLayout.SOUTH);
        frame.add(numbersPanel, BorderLayout.CENTER);
        frame.add(signsPanel, BorderLayout.WEST);

        frame.setResizable(false);
        frame.setVisible(true);
    }

    //returns a matrix of buttons to represent the numbers
    //on the calculator
    JPanel inputPan(JPanel panel){
        Font  f3  = new Font(Font.SANS_SERIF,  Font.BOLD, 15);
        name = new JLabel("Polynomial Calculator");
        name.setBounds(10,20,40,50);
        name.setBorder(BorderFactory.createEmptyBorder(10,110,10,0));
        name.setFont(f3);

        pol1 = new JLabel("First Polynomial = ");
        textFieldPol1 = new JTextField(10);

        pol2 = new JLabel("Second Polynomial = ");
        textFieldPol2 = new JTextField(10);

        res = new JLabel("Result = ");
        textFieldResult = new JTextField(10);

        panel.add(name,BorderLayout.CENTER);
        panel.add(pol1);
        panel.add(textFieldPol1);
        panel.add(pol2);
        panel.add(textFieldPol2);
        panel.add(res);
        panel.add(textFieldResult);
        //panel.setAlignmentX(30);
        //panel.setAlignmentY(30);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setBackground(new java.awt.Color(147,150, 205, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        return panel;
    }
    JPanel operationPan(JPanel panel){
        multiplicateOp = new JButton("Multiplicate");
        //multiplicateOp.setBackground(new java.awt.Color(147,150, 205, 230));
        multiplicateOp.setForeground(new Color(127,10,255));
        substractOp = new JButton("Subtract");
        substractOp.setForeground(new Color(127,10,255));
        divideOp = new JButton("Divide");
        divideOp.setForeground(new Color(127,10,255));
        addOp = new JButton("Add");
        addOp.setForeground(new Color(127,10,255));
        derivateOp = new JButton("Derive");
        derivateOp.setForeground(new Color(127,10,255));
        integrateOp = new JButton("Integrate");
        integrateOp.setForeground(new Color(127,10,255));
        panel.setLayout(new GridLayout(3,3));

        panel.add(multiplicateOp);
        panel.add(substractOp);
        panel.add(divideOp);
        panel.add(addOp);
        panel.add(derivateOp);
        panel.add(integrateOp);

        panel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        panel.setBackground(new java.awt.Color(147,150, 205, 230));
        panel.setLayout(new GridLayout(3,3));

        return panel;
    }

    JPanel numberPan(JPanel panel)
    {
        oneBtn = new JButton("1");
        twoBtn = new JButton("2");
        threeBtn = new JButton("3");
        fourBtn= new JButton("4");
        fiveBtn= new JButton("5");
        sixBtn= new JButton("6");
        sevenBtn= new JButton("7");
        eightBtn= new JButton("8");
        nineBtn= new JButton("9");

        panel.add(oneBtn);
        panel.add(twoBtn);
        panel.add(threeBtn);
        panel.add(fourBtn);
        panel.add(fiveBtn);
        panel.add(sixBtn);
        panel.add(sevenBtn);
        panel.add(eightBtn);
        panel.add(nineBtn);
        //panel.add(zeroBtn);

        //panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setLayout(new GridLayout(3,3));
        panel.setBackground(new java.awt.Color(147,150, 205, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        return panel;
    }

    //return a horizontal pattern of buttons to represent
    //the mathematical signs of the calculator
    JPanel signPan(JPanel panel)
    {
        zeroBtn = new JButton("0");
        addBtn= new JButton("+");
        addBtn.setPreferredSize(new Dimension(10,10));
        subtractBtn= new JButton("-");
        multiplyBtn= new JButton("*");
        divideBtn= new JButton("/");
        powBtn = new JButton("^");
        delBtn= new JButton("del");
        equalsBtn= new JButton("=");
        xBtn = new JButton("x");

        panel.add(delBtn);
        panel.add(addBtn);
        panel.add(subtractBtn);
        panel.add(multiplyBtn);
        panel.add(divideBtn);
        panel.add(equalsBtn);
        panel.add(xBtn);
        panel.add(powBtn);
        panel.add(zeroBtn);

        panel.setLayout(new GridLayout(3,3));
        panel.setBackground(new java.awt.Color(147,150, 205, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(25,15,15,25));
        return panel;
    }

    void setTextValue1(int value)
    {
        //sets textField to String value
        textFieldPol1.setText(Integer.toString(value));
    }
    void setTextValue2(int value)
    {
        //sets textField to String value
        textFieldPol2.setText(Integer.toString(value));
    }


    //returns number currently in TextBox
    int getTextFeildValue()
    {
        int value = Integer.parseInt(textFieldPol1.getText());
        return value;
    }
    int getTextFeildValue2()
    {
        int value = Integer.parseInt(textFieldPol2.getText());
        return value;
    }

    void addOneBtn(ActionListener one){
       oneBtn.addActionListener(one);
    }

    //void showError(String errMessage) {
    //    JOptionPane.showMessageDialog(this, errMessage);
    //}
    void addClearListrener(ActionListener del){
        delBtn.addActionListener(del);
    }


}
