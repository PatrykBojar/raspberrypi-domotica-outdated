package proyectoRaspberryPI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class LogArea {

	
	static JPanel panelLog ;
	
	LogArea(){
		panelLog = new JPanel();

		JTextArea lblLog = new JTextArea();

		lblLog.setEditable(false);

		JScrollPane scrBar = new JScrollPane(lblLog);
		
		
		
		lblLog.setPreferredSize(new Dimension(380, 300));
		panelLog.setPreferredSize(new Dimension(380, 200));
		panelLog.add(scrBar);
	}

	public static JPanel getpanelLog() {
		return panelLog;
	}

	public void JPanel(JPanel panelLog) {
		this.panelLog = panelLog;
	}
	
}
