package pruebasRaspi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinDirection;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.PinEventType;

public class ControLed {

	public static void main(String[] args) {

		/**
		 * PARA EJECUTAR y compilar usando librerias externas
		 * 
		 * 
		 * queremos compilar un programa Main.java que esta dentro de una
		 * carpeta llamada server:
		 * 
		 * home horabaixa server Main.java
		 * 
		 * Evidente mente la clase Main pertenece al paquete server.
		 * 
		 * Nos colocamos en /home/horabaixa
		 * 
		 * javac -cp .:/opt/pi4j/lib/* server/Main.java
		 * 
		 * java -cp .:/opt/pi4j/lib/* server/Main
		 * 
		 * 
		 */
	}

}
