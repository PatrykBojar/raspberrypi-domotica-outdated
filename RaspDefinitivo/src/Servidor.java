
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class Servidor extends JFrame {

	JTextArea txtArea;

	JLabel label1;
	boolean estado1 = false;
	JLabel label2;
	boolean estado2 = false;
	JLabel label3;
	boolean estado3 = false;
	
	private String mensajeLog = "";

	public static void main(String[] args) {
		new Servidor();
	}

	Servidor() {
		super("Servidor Domotica");
		setSize(new Dimension(470, 420));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		// PANEL SUPERIOR DE LOS ESTADOS DE LOS LEDS
		JPanel estado = new JPanel();

		estado.setBorder(BorderFactory.createTitledBorder("Indicadores"));

		estado.setLayout(new FlowLayout(FlowLayout.LEFT));

		// paneles de estado

		label1 = new JLabel();
		label1.setPreferredSize(new Dimension(100, 100));
		label1.setBackground(Color.RED);
		label1.setOpaque(true);

		label2 = new JLabel();
		label2.setPreferredSize(new Dimension(100, 100));
		label2.setBackground(Color.RED);
		label2.setOpaque(true);

		label3 = new JLabel();
		label3.setPreferredSize(new Dimension(100, 100));
		label3.setBackground(Color.RED);
		label3.setOpaque(true);
		// PANEL INFERIOR DE LOS MENSAJES QUE RESIVE DEL CLIENTE
		JPanel mensajes = new JPanel();

		mensajes.setBorder(BorderFactory.createTitledBorder("Mensajes"));
		mensajes.setLayout(new FlowLayout(FlowLayout.LEFT));

		txtArea = new JTextArea(16, 38);

		JScrollPane srcLog = new JScrollPane(txtArea);

		estado.add(label1);
		estado.add(label2);
		estado.add(label3);

		mensajes.add(srcLog);

		add(estado, BorderLayout.NORTH);
		add(mensajes, BorderLayout.CENTER);

		setVisible(true);

		iniciarServicio();
	}

	private void iniciarServicio() {

		ServerSocket socketServidor;

		try {
			socketServidor = new ServerSocket(5000);

			Socket socketCliente = null;

			while (true) {
				socketCliente = socketServidor.accept();

				// Crear un hilo nuevo, pasarle el socketCliente
				// (que permite)
				Thread hilo = new Thread(new Manejador(socketCliente, this));
				hilo.start();

			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void controladorEstado(String objeto, String estado) {

		if (objeto.equals("1")) {
			if (estado.equals("true")) {
				label1.setBackground(Color.GREEN);

			} else {
				label1.setBackground(Color.RED);
			}
		} else if (objeto.equals("2")) {
			if (estado.equals("true")) {

				getLabel2().setBackground(Color.GREEN);
			} else {
				getLabel2().setBackground(Color.RED);
			}
		} else if (objeto.equals("3")) {
			if (estado.equals("true")) {
				getLabel3().setBackground(Color.GREEN);
			} else {
				getLabel3().setBackground(Color.RED);
			}
		}
	}

	public JTextArea getTxtArea() {
		return txtArea;
	}

	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public boolean isEstado1() {
		return estado1;
	}

	public void setEstado1(boolean estado1) {
		this.estado1 = estado1;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public boolean isEstado2() {
		return estado2;
	}

	public void setEstado2(boolean estado2) {
		this.estado2 = estado2;
	}

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

	public boolean isEstado3() {
		return estado3;
	}

	public void setEstado3(boolean estado3) {
		this.estado3 = estado3;
	}

	public String getMensajeLog() {
		return mensajeLog;
	}

	public void setMensajeLog(String mensajeLog) {
		this.mensajeLog = mensajeLog;
	}

	
	
}