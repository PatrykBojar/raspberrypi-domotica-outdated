package proyectoRaspberryPI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BtnZona {

	private static JLabel lblEstado1;
	private static final JPanel[] panelZona1 = new JPanel[50];
	private static JPanel panelControl1;
	private static JButton btnZ1Encendido;
	private static JButton btnZ1Apagar;

	public BtnZona() {
		
		crearBtn();

	}

	private void crearBtn() {
		
		for (int i = 0; i < panelZona1.length; i++) {

			if (panelZona1[i] == null) {
				
				panelZona1[i] = new JPanel();

				panelZona1[i].setLayout(new BoxLayout(panelZona1[i], BoxLayout.X_AXIS));

				btnZ1Encendido = new JButton("Encender");
				btnZ1Apagar = new JButton("Apagar");

				btnZ1Encendido.setPreferredSize(new Dimension(125, 150));
				btnZ1Apagar.setPreferredSize(new Dimension(125, 150));

				panelControl1 = new JPanel(new FlowLayout());

				lblEstado1 = new JLabel("");
				lblEstado1.setPreferredSize(new Dimension(100, 100));
				panelControl1.add(lblEstado1);
				panelControl1.setBorder(BorderFactory.createTitledBorder("Estado"));
				panelControl1.setBackground(Color.GRAY);

				panelZona1[i].setPreferredSize(new Dimension(350, 100));

				panelZona1[i].add(btnZ1Encendido);
				panelZona1[i].add(btnZ1Apagar);
				panelZona1[i].add(panelControl1);

				panelZona1[i].setBorder(BorderFactory.createTitledBorder("Controlador " + (i + 1)));
				
				break;
			} 
		}
	}

	public static JPanel[] getPanelzona1() {
		return panelZona1;
	}

}
