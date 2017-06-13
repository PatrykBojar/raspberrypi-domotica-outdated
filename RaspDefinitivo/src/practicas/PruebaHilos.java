package practicas;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class PruebaHilos extends JFrame {

	JTextArea txtSalida ;
	int cont = 0;	
	public static void main(String[] args) {
		new PruebaHilos();
	}

	public PruebaHilos() {

		super("Título");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());

		JToolBar barraHerramientas = new JToolBar();
		
		JButton btnEjecutar = new JButton(new ImageIcon("iconos/38.png"));
		
		btnEjecutar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lanzarHilos();
				
			}
		});
		
		txtSalida = new JTextArea();
		txtSalida.setLineWrap(true);
		txtSalida.setWrapStyleWord(true);
		
		JScrollPane scrSalida = new JScrollPane(txtSalida);
		
		barraHerramientas.add(btnEjecutar);

		add(barraHerramientas,BorderLayout.NORTH);
		add(scrSalida,BorderLayout.CENTER);
		
		//panel superior
		
		//panel Centro
		
		//panel Inferior
		
		setVisible(true);

	}

	public void lanzarHilos(){
		
		
	
		if (cont!=0)
		txtSalida.append("Iniciando el programa con el hilo " + Thread.currentThread().getName() + " " + Thread.currentThread().getState() +  "\n");
		
	
		
		Thread hilo1 = new Thread(new Hilo());
		Thread hilo2 = new Thread(new Hilo());
		Thread hilo3 = new Thread(new Hilo());
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
			
		cont++;
	}
	
}








































