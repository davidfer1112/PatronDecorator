package decoradores;

import mensajes.InterfaceMensaje;

/**
 * Decorador que genera un mensaje en formato SOAP.
 */
public class MensajeSOAP extends DecoradorMensaje {

    public MensajeSOAP(InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = EnvelopMensaje();
        return Formatomensaje;
    }

    private InterfaceMensaje EnvelopMensaje() {
        // Generamos el mensaje en formato SOAP
        String soap = "<soapenv:Envelope xmlns:soapenv="
                + "\n\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "\nxmlns:ser=\"http://service.dishweb.cl.com/\">\n"
                + "   <soapenv:Header/>\n" // El header se agregará más tarde con el decorador de credenciales.
                + "   <soapenv:Body>\n"
                + Formatomensaje.getContenido() // El contenido del mensaje (cifrado o no)
                + "\n   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        Formatomensaje.setContenido(soap);
        return Formatomensaje;
    }
}



