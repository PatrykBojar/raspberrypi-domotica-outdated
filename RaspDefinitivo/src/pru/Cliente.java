
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * La clase Cliente permite introducir textos y mandarlos a un servidor.
 * 
 * @author Carlos
 *
 */
public class Cliente extends JFrame {

	public Cliente() {

		super("Cliente");
		setSize(400, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new FlowLayout());

		JTextField txtMensaje = new JTextField(20);
		JButton btnMensaje = new JButton("Enviar");
		btnMensaje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				enviarMensaje(txtMensaje.getText());
				txtMensaje.setText("");

			}

		});

		add(txtMensaje);
		add(btnMensaje);

		// Hacemos que sea el botón por defecto.
		getRootPane().setDefaultButton(btnMensaje);

		setVisible(true);

	}

	/**
	 * Envía un mensaje hacia el servidor.
	 * 
	 * @param mensaje
	 *            Mensaje de texto que se envía al servidor.
	 */
	private void enviarMensaje(String mensaje) {

		Socket socket = null;

		PrintStream salida = null;

		try {
			socket = new Socket("localhost", 5000);
			socket.setReuseAddress(false);
			

			
			
			salida = new PrintStream(socket.getOutputStream());

			salida.println(mensaje);

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

	public static void main(String[] args) {
		new Cliente();
	}

}
