package control_gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.Container;
import multiplication.Multiplication;

public class ControlContainer extends Container{
	private JPanel controlContainer;
	private Multiplication mult;
	
	public ControlContainer(JFrame frame, Multiplication mult) {
		super(frame, "Control.");
		this.mult = mult;
		
		
		frame.add(this.controlContainer);
		frame.pack();
	}
	
	private void addPush() {
		JButton pushButton = new JButton("PUSH X");
		JLabel pushLabel = new JLabel();
		JTextField pushTextField = new JTextField(20);
		
		pushLabel.setText("Push");
		
		pushButton.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent ae){
			      String textFieldValue = pushTextField.getText();
			      // handlePushX(textFieldValue);
			   }
			});
		
		// this.setInputLayoutConstraints(pushLabel);
		// this.setInputLayoutConstraints(pushButton);
		// this.setInputLayoutConstraints(pushTextField);
		
		this.controlContainer.add(pushLabel);
		this.controlContainer.add(pushTextField);
		this.controlContainer.add(pushButton);
	}
	
	public boolean solveForNewX(float[][] aInputs, float[][] bInputs) {
		
		
		
		return true;
	}
}
