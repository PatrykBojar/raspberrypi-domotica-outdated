import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;

public class Manejador implements Runnable {

	private Socket socketCliente;
	private Servidor ventana;

	
	
	public Manejador(Socket socketCliente, Servidor ventana) {

		this.socketCliente = socketCliente;
		this.ventana = ventana;
	}

	@Override
	public void run() {

		BufferedReader buffer = null;

		try {
			buffer = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

			String mensaje = buffer.readLine();

			SocketAddress direcionSocket = socketCliente.getRemoteSocketAddress();
			String ipCliente = direcionSocket.toString();

			String[] objetos = mensaje.split(":");

			String objeto = objetos[0].substring(0);

			String estado = objetos[1].substring(0);

			String[] campos = ipCliente.split(":");

			ipCliente = campos[0].substring(1);

			ventana.setMensajeLog("elemento " + objeto + " esta encendido: " + estado + " ::: " + " -- "
					+ socketCliente.getInetAddress() + "\n" +ventana.getMensajeLog().toString());
			
			ventana.getTxtArea().setText(ventana.getMensajeLog().toString());

			ventana.controladorEstado(objeto, estado);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
