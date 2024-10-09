package decoradores;

import mensajes.InterfaceMensaje;

/**
 * Decorador que agrega los datos de la empresa al pie de un mensaje SOAP.
 */
public class FooterEmpresaDecorator extends DecoradorMensaje {
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String email;

    public FooterEmpresaDecorator(String nombreEmpresa, String direccion, String telefono, String email, InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        agregarDatosEmpresa();
        return Formatomensaje;
    }

    private void agregarDatosEmpresa() {
        String contenidoConPie = Formatomensaje.getContenido() + "\n\n---\n" +
                "Empresa: " + nombreEmpresa + "\n" +
                "Dirección: " + direccion + "\n" +
                "Teléfono: " + telefono + "\n" +
                "Email: " + email;
        Formatomensaje.setContenido(contenidoConPie);
    }
}

