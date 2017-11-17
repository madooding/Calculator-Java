import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackspaceButtonListener implements ActionListener{
	private Calculator calc;
	
	public BackspaceButtonListener(Calculator calc){
		this.calc = calc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.calc.backspace();
	}
	
}
