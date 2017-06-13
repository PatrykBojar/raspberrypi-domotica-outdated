
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

public class Cliente extends JFrame implements ActionListener {
	// botones1
	private JLabel lblEstado1;
	private JPanel panelControl1;
	private JButton btnZ1Encendido;
	private JButton btnZ1Apagar;
	// botones2
	private JLabel lblEstado2;
	private JPanel panelControl2;
	private JButton btnZ2Encendido;
	private JButton btnZ2Apagar;

	// botones3
	private JLabel lblEstado3;
	private JPanel panelControl3;
	private JButton btnZ3Encendido;
	private JButton btnZ3Apagar;

	// Log y estado
	private JTextArea lblLog;
	private boolean estado1;
	private boolean estado2;
	private boolean estado3;
	private String log = "";
	private Date date ;
	
	public static void main(String[] args) {

		new Cliente();

	}

	public Cliente() {
		super("Domotic Controller");
		setSize(new Dimension(400, 700));
		setMinimumSize(new Dimension(400, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		setLayout(new FlowLayout());

		// PANEL1 ////////////////////////////////////////////
		JPanel panelZona1 = new JPanel();

		panelZona1.setLayout(new BoxLayout(panelZona1, BoxLayout.X_AXIS));

		btnZ1Encendido = new JButton("Encender");
		btnZ1Apagar = new JButton("Apagar");

		btnZ1Encendido.setPreferredSize(new Dimension(120, 100));
		btnZ1Apagar.setPreferredSize(new Dimension(120, 100));

		panelControl1 = new JPanel(new FlowLayout());

		lblEstado1 = new JLabel("");

		panelControl1.add(lblEstado1);
		panelControl1.setBorder(BorderFactory.createTitledBorder("Estado"));
		panelControl1.setBackground(Color.GRAY);

		panelZona1.add(btnZ1Encendido);
		panelZona1.add(btnZ1Apagar);
		panelZona1.add(panelControl1);

		panelZona1.setBorder(BorderFactory.createTitledBorder("Controlador 1"));

		// PANEL2 ////////////////////////////////////////////
		JPanel panelZona2 = new JPanel();

		panelZona2.setLayout(new BoxLayout(panelZona2, BoxLayout.X_AXIS));

		btnZ2Encendido = new JButton("Encender");
		btnZ2Apagar = new JButton("Apagar");

		btnZ2Encendido.setPreferredSize(new Dimension(120, 100));
		btnZ2Apagar.setPreferredSize(new Dimension(120, 100));

		panelControl2 = new JPanel(new FlowLayout());

		lblEstado2 = new JLabel("");

		panelControl2.add(lblEstado2);
		panelControl2.setBorder(BorderFactory.createTitledBorder("Estado"));
		panelControl2.setBackground(Color.GRAY);

		panelZona2.add(btnZ2Encendido);
		panelZona2.add(btnZ2Apagar);
		panelZona2.add(panelControl2);

		panelZona2.setBorder(BorderFactory.createTitledBorder("Controlador 2"));

		// PANEL3 ////////////////////////////////////////////
		JPanel panelZona3 = new JPanel();

		panelZona3.setLayout(new BoxLayout(panelZona3, BoxLayout.X_AXIS));

		btnZ3Encendido = new JButton("Encender");
		btnZ3Apagar = new JButton("Apagar");

		btnZ3Encendido.setPreferredSize(new Dimension(120, 100));
		btnZ3Apagar.setPreferredSize(new Dimension(120, 100));

		panelControl3 = new JPanel(new FlowLayout());

		lblEstado3 = new JLabel("");

		panelControl3.add(lblEstado3);
		panelControl3.setBorder(BorderFactory.createTitledBorder("Estado"));
		panelControl3.setBackground(Color.GRAY);

		panelZona3.add(btnZ3Encendido);
		panelZona3.add(btnZ3Apagar);
		panelZona3.add(panelControl3);

		panelZona3.setBorder(BorderFactory.createTitledBorder("Controlador 3"));

		
		// Label Log ////////////////////////////////////
		JPanel panelLog = new JPanel();

		lblLog = new JTextArea(10,30);
		JScrollPane srcLog = new JScrollPane(lblLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		lblLog.setEditable(false);

		panelLog.add(srcLog);

		// Eventos de botones
		// btn1
		btnZ1Encendido.addActionListener(this);
		btnZ1Apagar.addActionListener(this);
		// btn2
		btnZ2Encendido.addActionListener(this);
		btnZ2Apagar.addActionListener(this);
		// btn3
		btnZ3Encendido.addActionListener(this);
		btnZ3Apagar.addActionListener(this);
		
		// Tamaño de los paneles
		panelZona1.setPreferredSize(new Dimension(getWidth() - 20, 100));
		panelZona2.setPreferredSize(new Dimension(getWidth() - 20, 100));
		panelZona3.setPreferredSize(new Dimension(getWidth() - 20, 100));
		
		
		add(panelZona1);
		add(panelZona2);
		add(panelZona3);
		add(panelLog);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object btn = e.getSource();

		if (btn == btnZ1Encendido || btn == btnZ1Apagar) {
			componente1(e, btn);
		} else if (btn == btnZ2Encendido || btn == btnZ2Apagar) {
			componente2(e, btn);
		}else if (btn == btnZ3Encendido || btn == btnZ3Apagar) {
			componente3(e, btn);
		}
	}

	public void componente1(ActionEvent e, Object btn) {
		if (btn == btnZ1Encendido) {
			if (estado1 == true) {
				lblEstado1.setText("Ya esta Encendido");
			} else {
				estado1 = true;
				System.out.println("Componente 1 Encendido");
				lblEstado1.setText("");
				log = "Componente 1 Encendido\n"+log ;
				lblLog.setText(log);
				panelControl1.setBackground(Color.GREEN);
				enviarMensaje(1, estado1);
			}
		} else if (btn == btnZ1Apagar) {
			if (estado1 == false) {
				lblEstado1.setText("Ya esta apagado");
			} else {
				estado1 = false;
				System.out.println("Componente 1 Apagado");
				lblEstado1.setText("");
				log ="Componente 1 Apagado\n"+log ;
				lblLog.setText(log);
				panelControl1.setBackground(Color.GRAY);
				enviarMensaje(1, estado1);
				
			}
		}
		

	}
	
	public void componente2(ActionEvent e, Object btn) {
		if (btn == btnZ2Encendido) {
			if (estado2 == true) {
				lblEstado2.setText("Ya esta Encendido");
			} else {
				estado2 = true;
				System.out.println("Componente 2 Encendido");
				lblEstado2.setText("");
				log ="Componente 2 Encendido\n"+log ;
				lblLog.setText(log);
				panelControl2.setBackground(Color.GREEN);
				enviarMensaje(2, estado2);
			}
		} else if (btn == btnZ2Apagar) {
			if (estado2 == false) {
				lblEstado2.setText("Ya esta apagado");
			} else {
				estado2 = false;
				System.out.println("Componente 2 Apagado");
				lblEstado2.setText("");
				log = "Componente 2 Apagado\n"+log ;
				lblLog.setText(log);
				panelControl2.setBackground(Color.GRAY);
				enviarMensaje(2, estado2);
			}
		}
		
	}
	
	public void componente3(ActionEvent e, Object btn) {
		if (btn == btnZ3Encendido) {
			if (estado3 == true) {
				lblEstado3.setText("Ya esta Encendido");
				
			} else {
				estado3 = true;
				System.out.println("Componente 3 Encendido");
				lblEstado3.setText("");
				log = "Componente 3 Encendido\n"+log ;
				lblLog.setText(log);
				panelControl3.setBackground(Color.GREEN);
				enviarMensaje(3, estado3);
			}
		} else if (btn == btnZ3Apagar) {
			if (estado3 == false) {
				lblEstado3.setText("Ya esta apagado");
			} else {
				estado3 = false;
				System.out.println("Componente 3 Apagado");
				lblEstado3.setText("");
				log ="Componente 3 Apagado\n"+log ;
				lblLog.setText(log);
				panelControl3.setBackground(Color.GRAY);
				enviarMensaje(3, estado3);
			}
		}
		
	}
	
	private void enviarMensaje(int objeto, boolean estado) {

		Socket socket = null;

		PrintStream salida = null;

		try {
			socket = new Socket("192.168.1.190", 5000);
			socket.setReuseAddress(false);
			

			
			
			salida = new PrintStream(socket.getOutputStream());

			salida.println( objeto + ":" + estado);
			

		} catch (UnknownHostException e) {
			System.out.println("Error: equipo desconocido. ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error: equipo desconocido. ");
			e.printStackTrace();
		} finally {
			
			try {
				salida.close();
				socket.close();
			} catch (IOException | NullPointerException e ) {
				System.out.println("Error de E/S: " + e.toString());
			}
		}

	}
	
}