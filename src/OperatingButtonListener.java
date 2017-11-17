import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatingButtonListener implements ActionListener {
	private Calculator calc;
	private String operator;
	public OperatingButtonListener(Calculator calc, String operator){
		this.calc = calc;
		this.operator = operator;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(operator){
			case "+": this.calc.add();
					break;
			case "-": this.calc.subtract();
					break;
			case "*": this.calc.multiply();
					break;
			case "/": this.calc.divide();
					break;
			case ".": this.calc.point();
					break;
			case "=": this.calc.equal();
					break;

		}
	}
	
}
