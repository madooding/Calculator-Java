import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener{
	private Calculator calc;
	public ClearButtonListener(Calculator calc){
		this.calc = calc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		calc.clear();
		
	}

}
