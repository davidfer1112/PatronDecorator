/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Decorador
 * Tipo de Clase: Interface
 */

package mensajes;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface InterfaceMensaje {

    public InterfaceMensaje ProcesarMensaje();
    public String getContenido();
    public void setContenido(String contenido);
}
