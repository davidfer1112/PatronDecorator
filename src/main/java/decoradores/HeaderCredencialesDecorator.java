package decoradores;

import mensajes.InterfaceMensaje;

/**
 * Decorador que agrega credenciales al header de un mensaje SOAP.
 */
public class HeaderCredencialesDecorator extends DecoradorMensaje {
    private String usuario;
    private String password;

    public HeaderCredencialesDecorator(String usuario, String password, InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        agregarCredenciales();
        return Formatomensaje;
    }

    private void agregarCredenciales() {
        String soapConCredenciales = Formatomensaje.getContenido().replace(
                "<soapenv:Header/>", // Reemplazamos el Header vacío
                "<soapenv:Header>\n" +
                        "   <wsse:Security>\n" +
                        "       <wsse:UsernameToken>\n" +
                        "           <wsse:Username>" + usuario + "</wsse:Username>\n" +
                        "           <wsse:Password>" + password + "</wsse:Password>\n" +
                        "       </wsse:UsernameToken>\n" +
                        "   </wsse:Security>\n" +
                        "</soapenv:Header>"
        );
        Formatomensaje.setContenido(soapConCredenciales);
    }
}
