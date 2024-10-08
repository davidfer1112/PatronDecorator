/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Decorador
 * Tipo de Clase: Java
 */
package decoradores;

import mensajes.InterfaceMensaje;

/**
 *
 * @author Fabrizio Bolaño
 */
public class MensajeSOAP extends DecoradorMensaje {

    public MensajeSOAP(InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje.ProcesarMensaje();
        Formatomensaje =  EnvelopMensaje();
        return Formatomensaje;
    }

    private InterfaceMensaje EnvelopMensaje() {
        String soap = "<soapenv:Envelope xmlns:soapenv="
                + "\n\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "\nxmlns:ser=\"http://service.dishweb.cl.com/\">\n"
                + "   <soapenv:Header/>\n"
                + "   <soapenv:Body>\n"
                + Formatomensaje.getContenido()
                + "\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        Formatomensaje.setContenido(soap);
        return Formatomensaje;
    }
}
