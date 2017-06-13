import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;

public class manejadorPeticiones implements Runnable{

	private Socket socketCliente;
	private Servidor ventana;
	
	public manejadorPeticiones(Socket socketCliente, Servidor ventana) {
		
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
			
			String[] campos = ipCliente.split(":");
			
			ipCliente = campos[0].substring(1);
			
			ventana.getTxtMensajes().append(ipCliente + " ::: " +  mensaje + " -- " + socketCliente.getInetAddress());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
