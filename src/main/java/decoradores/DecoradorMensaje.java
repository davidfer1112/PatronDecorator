/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Decorador
 * Tipo de Clase: Clase Abstracta
 */
package decoradores;

import mensajes.InterfaceMensaje;

/**
 *
 * @author Fabrizio Bolaño
 */
public abstract class DecoradorMensaje implements InterfaceMensaje{
    protected InterfaceMensaje Formatomensaje;

    public DecoradorMensaje(InterfaceMensaje mensaje) {
        this.Formatomensaje = mensaje;
    }

    @Override
    public String getContenido() {
        return Formatomensaje.getContenido();
    }

    @Override
    public void setContenido(String contenido) {
        Formatomensaje.setContenido(contenido);
    }




}
