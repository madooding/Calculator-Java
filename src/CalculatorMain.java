import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

public class CalculatorMain {
	private static JTextField resultTxtField;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
        frame.getContentPane().setLayout(new GridLayout());
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        resultTxtField = new JTextField();
        resultTxtField.setBounds(10, 11, 210, 34);
        panel.add(resultTxtField);
        resultTxtField.setColumns(10);

        JTextArea historyTxtArea = new JTextArea();
        historyTxtArea.setBounds(230, 56, 203, 268);
        panel.add(historyTxtArea);

        Calculator calculator = new Calculator(resultTxtField, historyTxtArea);
        
        JButton btnClear = new JButton("C");
        btnClear.setBounds(10, 56, 45, 45);
        btnClear.addActionListener(new ClearButtonListener(calculator));
        panel.add(btnClear);
        
        JButton btnBackspace = new JButton("BS");
        btnBackspace.setBounds(120, 56, 45, 45);
        btnBackspace.addActionListener(new BackspaceButtonListener(calculator));
        panel.add(btnBackspace);
        
        JButton btnDivide = new JButton("/");
        btnDivide.setBounds(175, 56, 45, 45);
        btnDivide.addActionListener(new OperatingButtonListener(calculator, "/"));
        panel.add(btnDivide);
        
        JButton btn7 = new JButton("7");
        btn7.setBounds(10, 112, 45, 45);
        btn7.addActionListener(new NumButtonListener(calculator, 7));
        panel.add(btn7);
        
        JButton btn8 = new JButton("8");
        btn8.setBounds(65, 112, 45, 45);
        btn8.addActionListener(new NumButtonListener(calculator, 8));
        panel.add(btn8);
        
        JButton btn9 = new JButton("9");
        btn9.setBounds(120, 112, 45, 45);
        btn9.addActionListener(new NumButtonListener(calculator, 9));
        panel.add(btn9);
        
        JButton btnMultiply = new JButton("*");
        btnMultiply.setBounds(175, 112, 45, 45);
        btnMultiply.addActionListener(new OperatingButtonListener(calculator, "*"));
        panel.add(btnMultiply);
        
        JButton btn1 = new JButton("1");
        btn1.setBounds(10, 224, 45, 45);
        btn1.addActionListener(new NumButtonListener(calculator, 1));
        panel.add(btn1);
        
        JButton btn2 = new JButton("2");
        btn2.setBounds(65, 224, 45, 45);
        btn2.addActionListener(new NumButtonListener(calculator, 2));
        panel.add(btn2);
        
        JButton btn3 = new JButton("3");
        btn3.setBounds(120, 224, 45, 45);
        btn3.addActionListener(new NumButtonListener(calculator, 3));
        panel.add(btn3);
        
        JButton btnPlus = new JButton("+");
        btnPlus.setBounds(175, 224, 45, 45);
        btnPlus.addActionListener(new OperatingButtonListener(calculator, "+"));
        panel.add(btnPlus);
        
        JButton btnEqual = new JButton("=");
        btnEqual.setBounds(175, 280, 45, 45);
        btnEqual.addActionListener(new OperatingButtonListener(calculator, "="));
        panel.add(btnEqual);
        
        JButton btnPoint = new JButton(".");
        btnPoint.setBounds(120, 280, 45, 45);
        btnPoint.addActionListener(new OperatingButtonListener(calculator, "."));
        panel.add(btnPoint);
        
        JButton btn0 = new JButton("0");
        btn0.setBounds(65, 280, 45, 45);
        btn0.addActionListener(new NumButtonListener(calculator, 0));
        panel.add(btn0);
        
        JButton btnSubtract = new JButton("-");
        btnSubtract.setBounds(175, 168, 45, 45);
        btnSubtract.addActionListener(new OperatingButtonListener(calculator, "-"));
        panel.add(btnSubtract);
        
        JButton btn6 = new JButton("6");
        btn6.setBounds(120, 168, 45, 45);
        btn6.addActionListener(new NumButtonListener(calculator, 6));
        panel.add(btn6);
        
        JButton btn5 = new JButton("5");
        btn5.setBounds(65, 168, 45, 45);
        btn5.addActionListener(new NumButtonListener(calculator, 5));
        panel.add(btn5);
        
        JButton btn4 = new JButton("4");
        btn4.setBounds(10, 168, 45, 45);
        btn4.addActionListener(new NumButtonListener(calculator, 4));
        panel.add(btn4);
        
        JLabel lblHistory = new JLabel("History");
        lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblHistory.setBounds(233, 21, 60, 14);
        panel.add(lblHistory);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(459, 373);
        frame.setVisible(true);
        
	}
}
