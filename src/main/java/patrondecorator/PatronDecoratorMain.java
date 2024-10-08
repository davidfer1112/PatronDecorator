/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Decorador
 * Tipo de Clase: Main()
 */

package patrondecorator;
import decoradores.CifrarMensaje;
import decoradores.MensajeSOAP;
import decoradores.FormatoDecoradorXML;
import mensajes.InterfaceMensaje;
import mensajes.MensajeCliente;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronDecoratorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MensajeCliente MensajeUsuario = new MensajeCliente(
                "Fabrizio Bolaño", "fbolano@javeriana.edu.co", "99887766");
        System.out.println("Mensaje Original ==> " + MensajeUsuario);

        InterfaceMensaje F1Mensaje = new CifrarMensaje("user", "HG58YZ3CR9123456",
                new MensajeSOAP(
                        new FormatoDecoradorXML(MensajeUsuario))).ProcesarMensaje();
        System.out.println("Mensaje No. 1 =====================================>\n"
                + F1Mensaje.getContenido() + "\n\n");

        InterfaceMensaje F2Mensaje = new MensajeSOAP(
                new CifrarMensaje("user", "HG58YZ3CR9123456",
                        new FormatoDecoradorXML(MensajeUsuario))).ProcesarMensaje();
        System.out.println("message2 =====================================>\n"
                + F2Mensaje.getContenido());


    }

}
