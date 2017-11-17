import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;

public class Calculator {
	private String exp = "";
	private String currentOperand = "0";
	private String currentOperator = "";
	private JTextField txtField;
	private JTextArea historyTxtArea;
	private Pattern numberPattern = Pattern.compile("[0-9]+\\.?[0-9]+$");

	
	public Calculator(JTextField txtField, JTextArea historyTxtArea){
		this.txtField = txtField;
		this.historyTxtArea = historyTxtArea;
		this.setResultTxtField();
	}
	
	public void pressNum(int num){
		if(this.currentOperand.equals("0")){
			this.currentOperand = Integer.toString(num);
		}else{
			this.currentOperand += num;
		}
		this.exp += this.currentOperator;
		this.currentOperator = "";
		this.setResultTxtField();
	}
	
	public void add(){
		this.exp += this.currentOperand;
		this.currentOperand = "";
		this.currentOperator = "+";
		this.setResultTxtField();
	}
	
	public void subtract(){
		this.exp += this.currentOperand;
		this.currentOperand = "";
		this.currentOperator = "-";
		this.setResultTxtField();
	}
	
	public void multiply(){
		this.exp += this.currentOperand;
		this.currentOperand = "";
		this.currentOperator = "*";
		this.setResultTxtField();
	}
	
	public void divide(){
		this.exp += this.currentOperand;
		this.currentOperand = "";
		this.currentOperator = "/";
		this.setResultTxtField();
	}
	
	public void point(){
		if(!this.currentOperand.contains(".")) this.currentOperand += ".";
		this.setResultTxtField();
	}
	
	public void backspace(){
		if (!this.currentOperator.equals("")){
			this.currentOperator = "";
		} else if (this.currentOperand.length() > 0){
			this.deleteOperand();
		} else if (this.exp.length() > 0){
			Pattern pattern;
			Matcher matcher;
			if(this.exp.matches(".*[0-9]+(\\.[0-9]+)*$")){
				pattern = Pattern.compile("[0-9]+(\\.[0-9]+)*$");
				matcher = pattern.matcher(this.exp);
				if(matcher.find()){
					this.currentOperand = matcher.group(0);
					System.out.println(this.currentOperand);
					this.exp = this.exp.substring(0, this.exp.lastIndexOf(this.currentOperand));
					this.deleteOperand();
				}
			}
		}
		
		this.setResultTxtField();
	}

	private void deleteOperand(){
		this.currentOperand = this.currentOperand.substring(0, this.currentOperand.length()-1);
		if(this.currentOperand.length() == 0 && this.exp.length() > 0){
			this.currentOperator = "" + this.exp.charAt(this.exp.length()-1);
			this.exp = this.exp.substring(0, this.exp.length()-1);
		}
	}
	
	public void clear(){
		this.exp = "";
		this.currentOperand = "0";
		this.currentOperator = "";
		this.setResultTxtField();
	}
	
	public void equal(){
		this.historyTxtArea.setText(historyTxtArea.getText()+this.exp+this.currentOperand+"\n");
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Number n = 0;
		try {
			n = (Number) engine.eval(this.exp + this.currentOperand);
			this.txtField.setText(exp + this.currentOperand + " = " + n);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	public void setResultTxtField(){
		String textToShow = exp + currentOperand + currentOperator;
		System.out.println(textToShow);
		this.txtField.setText(textToShow.length() > 0 ? textToShow : "0");
	}
	
}
