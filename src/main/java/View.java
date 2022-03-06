import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class View extends Frame {
    JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn;
    JButton sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    JButton addBtn, subtractBtn, multiplyBtn, divideBtn, powBtn;
    JButton delBtn, pointBtn, xBtn;
    JButton multiplicateOp, substractOp, divideOp, derivateOp, addOp, integrateOp;

    JTextField textFieldPol1, textFieldPol2, textFieldResult;
    JFrame frame;
    JPanel numbersPanel, signsPanel, operationsPanel, inputPanel;
    JLabel pol1, pol2, name, res;

    View() {
        frame = new JFrame("Polynomial Calculator");
        frame.setSize(450, 450);
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
        mouseMove();
        frame.setBackground(new Color(147, 150, 205));
        frame.add(inputPanel, BorderLayout.BEFORE_FIRST_LINE);
        frame.add(operationsPanel, BorderLayout.SOUTH);
        frame.add(numbersPanel, BorderLayout.CENTER);
        frame.add(signsPanel, BorderLayout.WEST);

        chooseTextField();

        frame.setResizable(false);
        frame.setVisible(true);
    }

    JPanel inputPan(JPanel panel) {
        Font f3 = new Font(Font.SANS_SERIF, Font.BOLD, 18);
        name = new JLabel("Polynomial Calculator");
        name.setBounds(6, 20, 40, 50);
        name.setBorder(BorderFactory.createEmptyBorder(20, 63, 10, 0));
        name.setFont(f3);

        pol1 = new JLabel("First Polynomial = ");
        textFieldPol1 = new JTextField(20);
        textFieldPol1.setEditable(true);
        textFieldPol1.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 40));
        textFieldPol1.setBackground(new Color(230,240,240));

        pol2 = new JLabel("Second Polynomial = ");
        textFieldPol2 = new JTextField(20);
        textFieldPol2.setEditable(true);
        textFieldPol2.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 40));
        textFieldPol2.setBackground(new Color(230,240,240));

        res = new JLabel("Result = ");
        textFieldResult = new JTextField(20);
        textFieldResult.setEditable(true);
        textFieldResult.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 40));
        textFieldResult.setBackground(new Color(230,240,240));

        panel.add(name, BorderLayout.CENTER);
        panel.add(pol1);
        panel.add(textFieldPol1);
        panel.add(pol2);
        panel.add(textFieldPol2);
        panel.add(res);
        panel.add(textFieldResult);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new java.awt.Color(147, 150, 205, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 130));
        return panel;
    }

    JPanel operationPan(JPanel panel) {
        multiplicateOp = new JButton("Multiplicate");
        multiplicateOp.setBackground(new java.awt.Color(200, 200, 250, 250));
        multiplicateOp.setForeground(new Color(127, 10, 255));

        substractOp = new JButton("Subtract");
        substractOp.setBackground(new java.awt.Color(200, 200, 250, 250));
        substractOp.setForeground(new Color(127, 10, 255));
        divideOp = new JButton("Divide");
        divideOp.setBackground(new java.awt.Color(200, 200, 250, 250));
        divideOp.setForeground(new Color(127, 10, 255));
        addOp = new JButton("Add");
        addOp.setBackground(new java.awt.Color(200, 200, 250, 250));
        addOp.setForeground(new Color(127, 10, 255));
        derivateOp = new JButton("Derivative");
        derivateOp.setBackground(new java.awt.Color(200, 200, 250, 250));
        derivateOp.setForeground(new Color(127, 10, 255));
        integrateOp = new JButton("Integrate");
        integrateOp.setBackground(new java.awt.Color(200, 200, 250, 250));
        integrateOp.setForeground(new Color(127, 10, 255));
        panel.setLayout(new GridLayout(3, 3));

        panel.add(multiplicateOp);
        panel.add(substractOp);
        panel.add(divideOp);
        panel.add(addOp);
        panel.add(derivateOp);
        panel.add(integrateOp);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.setBackground(new java.awt.Color(147, 150, 205, 230));
        panel.setLayout(new GridLayout(3, 3));

        return panel;
    }

    JPanel numberPan(JPanel panel) {
        oneBtn = new JButton("1");
        twoBtn = new JButton("2");
        threeBtn = new JButton("3");
        fourBtn = new JButton("4");
        fiveBtn = new JButton("5");
        sixBtn = new JButton("6");
        sevenBtn = new JButton("7");
        eightBtn = new JButton("8");
        nineBtn = new JButton("9");
        oneBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        twoBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        threeBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        fourBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        fiveBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        sixBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        sevenBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        eightBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        nineBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        panel.add(oneBtn);
        panel.add(twoBtn);
        panel.add(threeBtn);
        panel.add(fourBtn);
        panel.add(fiveBtn);
        panel.add(sixBtn);
        panel.add(sevenBtn);
        panel.add(eightBtn);
        panel.add(nineBtn);

        //panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        panel.setLayout(new GridLayout(3, 3));
        panel.setBackground(new java.awt.Color(147, 150, 205, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
        return panel;
    }

    JPanel signPan(JPanel panel) {
        zeroBtn = new JButton("0");
        addBtn = new JButton("+");
        //addBtn.setPreferredSize(new Dimension(10, 10));
        subtractBtn = new JButton("-");
        multiplyBtn = new JButton("*");
        divideBtn = new JButton("/");
        powBtn = new JButton("^");
        delBtn = new JButton("C");
        pointBtn = new JButton(".");
        xBtn = new JButton("X");

        delBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        addBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        subtractBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        multiplyBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        divideBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        powBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        pointBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        xBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        zeroBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
        panel.add(delBtn);
        panel.add(addBtn);
        panel.add(subtractBtn);
        panel.add(multiplyBtn);
        panel.add(divideBtn);
        panel.add(pointBtn);
        panel.add(xBtn);
        panel.add(powBtn);
        panel.add(zeroBtn);

        panel.setLayout(new GridLayout(3, 3));
        panel.setBackground(new java.awt.Color(147, 150, 205, 230));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));
        return panel;
    }

    private void addActionListener(JTextField t) {
        oneBtn.addActionListener(e -> t.setText(t.getText() + "1"));
        twoBtn.addActionListener(e -> t.setText(t.getText() + "2"));
        threeBtn.addActionListener(e -> t.setText(t.getText() + "3"));
        fourBtn.addActionListener(e -> t.setText(t.getText() + "4"));
        fiveBtn.addActionListener(e -> t.setText(t.getText() + "5"));
        sixBtn.addActionListener(e -> t.setText(t.getText() + "6"));
        sevenBtn.addActionListener(e -> t.setText(t.getText() + "7"));
        eightBtn.addActionListener(e -> t.setText(t.getText() + "8"));
        nineBtn.addActionListener(e -> t.setText(t.getText() + "9"));
        zeroBtn.addActionListener(e -> t.setText(t.getText() + "0"));
        addBtn.addActionListener(e -> t.setText(t.getText() + "+"));
        subtractBtn.addActionListener(e -> t.setText(t.getText() + "-"));
        multiplyBtn.addActionListener(e -> t.setText(t.getText() + "*"));
        divideBtn.addActionListener(e -> t.setText(t.getText() + "/"));
        xBtn.addActionListener(e -> t.setText(t.getText() + "X"));
        powBtn.addActionListener(e -> t.setText(t.getText() + "^"));
        pointBtn.addActionListener(e -> t.setText(t.getText() + "."));
        delBtn.addActionListener(e -> t.setText(""));
    }

    public void chooseTextField() {
        int ok = 0;
        textFieldPol1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldPol1.requestFocusInWindow();
               removeActionListeners();
                addActionListener(textFieldPol1);
            }
        });
        textFieldPol2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                textFieldPol2.requestFocusInWindow();
                removeActionListeners();
                addActionListener(textFieldPol2);

            }
        });
    }

    public void removeALForButton(JButton b){
        if(b.getActionListeners().length!=0){
            ActionListener bt = b.getActionListeners()[0];
            b.removeActionListener(bt);
        }
    }

    public void removeActionListeners(){
        removeALForButton(oneBtn);
        removeALForButton(twoBtn);
        removeALForButton(threeBtn);
        removeALForButton(fourBtn);
        removeALForButton(fiveBtn);
        removeALForButton(sixBtn);
        removeALForButton(sevenBtn);
        removeALForButton(eightBtn);
        removeALForButton(nineBtn);
        removeALForButton(zeroBtn);
        removeALForButton(pointBtn);
        removeALForButton(powBtn);
        removeALForButton(addBtn);
        removeALForButton(divideBtn);
        removeALForButton(subtractBtn);
        removeALForButton(multiplyBtn);
        removeALForButton(delBtn);
        removeALForButton(xBtn);
    }

    public void mouseMoveOneButton (JButton button){
        button.setOpaque(true);
        button.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(100, 200, 200));
            }
            public void mouseExited(MouseEvent evt)
            {
                button.setBackground(new java.awt.Color(200, 200, 250, 250));
            }
        });
    }
    public void mouseMove(){
        mouseMoveOneButton(addOp);
        mouseMoveOneButton(substractOp);
        mouseMoveOneButton(multiplicateOp);
        mouseMoveOneButton(derivateOp);
        mouseMoveOneButton(integrateOp);
        mouseMoveOneButton(divideOp);
        mouseMoveOneButton(oneBtn);
        mouseMoveOneButton(twoBtn);
        mouseMoveOneButton(threeBtn);
        mouseMoveOneButton(fourBtn);
        mouseMoveOneButton(fiveBtn);
        mouseMoveOneButton(sixBtn);
        mouseMoveOneButton(sevenBtn);
        mouseMoveOneButton(eightBtn);
        mouseMoveOneButton(nineBtn);
        mouseMoveOneButton(zeroBtn);
        mouseMoveOneButton(multiplyBtn);
        mouseMoveOneButton(divideBtn);
        mouseMoveOneButton(addBtn);
        mouseMoveOneButton(subtractBtn);
        mouseMoveOneButton(pointBtn);
        mouseMoveOneButton(powBtn);
        mouseMoveOneButton(xBtn);
        delBtn.setOpaque(true);
        delBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt) {
                delBtn.setBackground(new Color(255,1,70,180));
            }
            public void mouseExited(MouseEvent evt)
            {
                delBtn.setBackground(new java.awt.Color(200, 200, 250, 250));
            }
        });


    }

    void setTextValue1(int value) {
        textFieldPol1.setText(Integer.toString(value));
    }

    void setTextValue2(int value) {
        textFieldPol2.setText(Integer.toString(value));
    }

    String getTextFeild1Value() {
        return textFieldPol1.getText();
    }

    String getTextFeild2Value() {
        return textFieldPol2.getText();
    }

    public void setText(String s) {
        textFieldPol1.setText(s);
    }
    public void setPolynomialAddActionListener(ActionListener actionListener) {
        addOp.addActionListener(actionListener);
    }

    public void setPolynomialSubtractActionListener(ActionListener actionListener){
        substractOp.addActionListener(actionListener);
    }

    public void setPolynomialMultiplyActionListener(ActionListener actionListener){
        multiplicateOp.addActionListener(actionListener);
    }

    public void setPolynomialDeriveActionListener(ActionListener actionListener){
        derivateOp.addActionListener(actionListener);
    }

    public void setPolynomialIntegrateActionListener(ActionListener actionListener){
        integrateOp.addActionListener(actionListener);
    }

    public void setPolynomialDivideActionListener(ActionListener actionListener){
        divideOp.addActionListener(actionListener);
    }

}