package proyectoRaspberryPI;

import java.awt.*;

import java.awt.*;

import javax.swing.*;

public class ventana extends JFrame {

	JPanel panelCentral;
	JPanel porPonerAlgo;
	JPanel panelAbajo;

	public ventana() {
		super("Titulo");
		setSize(new Dimension(400, 700));
		setMinimumSize(new Dimension(400, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		panelCentral = new JPanel();
		panelAbajo = new JPanel();

		BtnZona z1 = new BtnZona();
		BtnZona z2 = new BtnZona();
		BtnZona z3 = new BtnZona();
		BtnZona z4 = new BtnZona();
		BtnZona z5 = new BtnZona();
		BtnZona z6 = new BtnZona();
		BtnZona z7 = new BtnZona();
		BtnZona z8 = new BtnZona();
		BtnZona z9 = new BtnZona();
		BtnZona z10 = new BtnZona();
		BtnZona z11 = new BtnZona();
		BtnZona z12 = new BtnZona();
		BtnZona z13 = new BtnZona();
		BtnZona z14 = new BtnZona();
		BtnZona z15 = new BtnZona();
		BtnZona z16 = new BtnZona();

		LogArea LogArea = new LogArea();

		porPonerAlgo = new JPanel();
		porPonerAlgo.setLayout(new BoxLayout(porPonerAlgo, BoxLayout.Y_AXIS));

		panelCentral.add(porPonerAlgo);

		añadirBotones();
		añadirLog();

		JScrollPane scrBarCentral = new JScrollPane(panelCentral);

		add(scrBarCentral, BorderLayout.CENTER);
		add(panelAbajo, BorderLayout.SOUTH);
		setVisible(true);
	}

	private void añadirBotones() {
		JPanel[] btns = BtnZona.getPanelzona1();

		for (int i = 0; i < btns.length; i++) {
			System.out.println(btns[i]);
			if (btns[i] != null) {
				porPonerAlgo.add(btns[i]);
			}

		}

	}

	private void añadirLog() {

		panelAbajo.add(LogArea.getpanelLog());
	}
}
