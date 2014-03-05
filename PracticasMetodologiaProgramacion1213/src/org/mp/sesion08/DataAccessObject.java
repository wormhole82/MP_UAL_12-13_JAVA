package org.mp.sesion08;

//import java.io.Serializable;

//public class DataAccesObject implements Serializable {

/**
 *  Interfaz DataAccessObject. Permite leer y escribir objetos en disco. 
 * 
 *
 */
 public interface DataAccessObject{
	/**
	 * Escribir objeto en disco
	 * @param object objeto a escribir en disco
	 */
	public void escribir(Object object);
	/**
	 * Lee un objeto en disco y lo devuelve
	 * @return objeto leido en disco
	 */
	public Object leer();

}
