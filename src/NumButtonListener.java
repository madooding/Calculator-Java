import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumButtonListener implements ActionListener {
	private int num;
	private Calculator calc;
	public NumButtonListener(Calculator calc, int num){
		this.calc = calc;
		this.num = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.calc.pressNum(num);
	}

}
