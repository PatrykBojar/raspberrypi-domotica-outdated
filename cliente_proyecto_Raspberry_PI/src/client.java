import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

/**
 * Esta clase representa un controlador domótico con cuatro zonas.
 * Permite encender y apagar cada zona y registra el estado en un log.
 * También proporciona una interfaz gráfica para interactuar con los botones.
 * 
 * @author Borja Pellicer
 */
public class client extends JFrame implements ActionListener {
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
    // botones4
    private JLabel lblEstado4;
    private JPanel panelControl4;
    private JButton btnZ4Encendido;
    private JButton btnZ4Apagar;

    // Log y estado
    private JTextArea lblLog;
    private boolean estado1;
    private boolean estado2;
    private boolean estado3;
    private boolean estado4;
    private String log = "";
    private Date date;

    /**
     * Método principal que crea una instancia de la clase client.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        new client();
    }

    /**
     * Constructor de la clase client.
     * Crea la interfaz gráfica y configura los botones y paneles.
     */
    public client() {
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

        // PANEL4 ////////////////////////////////////////////
        JPanel panelZona4 = new JPanel();

        panelZona4.setLayout(new BoxLayout(panelZona4, BoxLayout.X_AXIS));

        btnZ4Encendido = new JButton("Encender");
        btnZ4Apagar = new JButton("Apagar");

        btnZ4Encendido.setPreferredSize(new Dimension(120, 100));
        btnZ4Apagar.setPreferredSize(new Dimension(120, 100));

        panelControl4 = new JPanel(new FlowLayout());

        lblEstado4 = new JLabel("");

        panelControl4.add(lblEstado4);
        panelControl4.setBorder(BorderFactory.createTitledBorder("Estado"));
        panelControl4.setBackground(Color.GRAY);

        panelZona4.add(btnZ4Encendido);
        panelZona4.add(btnZ4Apagar);
        panelZona4.add(panelControl4);

        panelZona4.setBorder(BorderFactory.createTitledBorder("Controlador 4"));

        // Label Log ////////////////////////////////////
        JPanel panelLog = new JPanel();
		
				// Creación del área de texto para el registro de eventos
		lblLog = new JTextArea();

		// Configuración del área de texto
		lblLog.setEditable(false);

		// Se agrega el área de texto al panel de registro
		panelLog.add(lblLog);

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
		// btn4
		btnZ4Encendido.addActionListener(this);
		btnZ4Apagar.addActionListener(this);

		// Tamaño de los paneles
		panelZona1.setPreferredSize(new Dimension(getWidth() - 20, 100));
		panelZona2.setPreferredSize(new Dimension(getWidth() - 20, 100));
		panelZona3.setPreferredSize(new Dimension(getWidth() - 20, 100));
		panelZona4.setPreferredSize(new Dimension(getWidth() - 20, 100));

		// Se agregan los paneles al JFrame
		add(panelZona1);
		add(panelZona2);
		add(panelZona3);
		add(panelZona4);
		add(panelLog);

		// Se hace visible el JFrame
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Se obtiene el objeto que desencadenó el evento
		Object btn = e.getSource();

		// Se determina qué botón se presionó y se invoca el método correspondiente
		if (btn == btnZ1Encendido || btn == btnZ1Apagar) {
			componente1(e, btn);
		} else if (btn == btnZ2Encendido || btn == btnZ2Apagar) {
			componente2(e, btn);
		} else if (btn == btnZ3Encendido || btn == btnZ3Apagar) {
			componente3(e, btn);
		} else if (btn == btnZ4Encendido || btn == btnZ4Apagar) {
			componente4(e, btn);
		}
	}

		/**
	 * Método para controlar el estado del componente 1.
	 * 
	 * @param e   Objeto ActionEvent que desencadena el evento.
	 * @param btn Objeto que representa el botón que desencadena el evento.
	 */
	public void componente1(ActionEvent e, Object btn) {
		if (btn == btnZ1Encendido) {
			if (estado1 == true) {
				lblEstado1.setText("Ya está Encendido");
			} else {
				estado1 = true;
				System.out.println("Componente 1 Encendido");
				lblEstado1.setText("");
				log = "Componente 1 Encendido\n" + log;
				lblLog.setText(log);
				panelControl1.setBackground(Color.GREEN);
			}
		} else if (btn == btnZ1Apagar) {
			if (estado1 == false) {
				lblEstado1.setText("Ya está apagado");
			} else {
				estado1 = false;
				System.out.println("Componente 1 Apagado");
				lblEstado1.setText("");
				log = "Componente 1 Apagado\n" + log;
				lblLog.setText(log);
				panelControl1.setBackground(Color.GRAY);
			}
		}
	}

	/**
	 * Método para controlar el estado del componente 2.
	 * 
	 * @param e   Objeto ActionEvent que desencadena el evento.
	 * @param btn Objeto que representa el botón que desencadena el evento.
	 */
	public void componente2(ActionEvent e, Object btn) {
		if (btn == btnZ2Encendido) {
			if (estado2 == true) {
				lblEstado2.setText("Ya está Encendido");
			} else {
				estado2 = true;
				System.out.println("Componente 2 Encendido");
				lblEstado2.setText("");
				log = "Componente 2 Encendido\n" + log;
				lblLog.setText(log);
				panelControl2.setBackground(Color.GREEN);
			}
		} else if (btn == btnZ2Apagar) {
			if (estado2 == false) {
				lblEstado2.setText("Ya está apagado");
			} else {
				estado2 = false;
				System.out.println("Componente 2 Apagado");
				lblEstado2.setText("");
				log = "Componente 2 Apagado\n" + log;
				lblLog.setText(log);
				panelControl2.setBackground(Color.GRAY);
			}
		}
	}

		/**
	 * Método para controlar el estado del componente 3.
	 * 
	 * @param e   Objeto ActionEvent que desencadena el evento.
	 * @param btn Objeto que representa el botón que desencadena el evento.
	 */
	public void componente3(ActionEvent e, Object btn) {
		if (btn == btnZ3Encendido) {
			if (estado3 == true) {
				lblEstado3.setText("Ya está Encendido");
			} else {
				estado3 = true;
				System.out.println("Componente 3 Encendido");
				lblEstado3.setText("");
				log = "Componente 3 Encendido\n" + log;
				lblLog.setText(log);
				panelControl3.setBackground(Color.GREEN);
			}
		} else if (btn == btnZ3Apagar) {
			if (estado3 == false) {
				lblEstado3.setText("Ya está apagado");
			} else {
				estado3 = false;
				System.out.println("Componente 3 Apagado");
				lblEstado3.setText("");
				log = "Componente 3 Apagado\n" + log;
				lblLog.setText(log);
				panelControl3.setBackground(Color.GRAY);
			}
		}
	}

	/**
	 * Método para controlar el estado del componente 4.
	 * 
	 * @param e   Objeto ActionEvent que desencadena el evento.
	 * @param btn Objeto que representa el botón que desencadena el evento.
	 */
	public void componente4(ActionEvent e, Object btn) {
		if (btn == btnZ4Encendido) {
			if (estado4 == true) {
				lblEstado4.setText("Ya está Encendido");
			} else {
				estado4 = true;
				System.out.println("Componente 4 Encendido");
				lblEstado4.setText("");
				log = "Componente 4 Encendido\n" + log;
				lblLog.setText(log);
				panelControl4.setBackground(Color.GREEN);
			}
		} else if (btn == btnZ4Apagar) {
			if (estado4 == false) {
				lblEstado4.setText("Ya está apagado");
			} else {
				estado4 = false;
				System.out.println("Componente 4 Apagado");
				lblEstado4.setText("");
				log = "Componente 4 Apagado\n" + log;
				lblLog.setText(log);
				panelControl4.setBackground(Color.GRAY);
			}
		}
	}

