package junioMP;

/**
 *  Interfaz que representa una cola
 *
 *
 */

public interface Cola {

	void insertar (Object x);
	
	Object primero() throws DesbordamientoInferiorException;
	
	Object quitarPrimero() throws DesbordamientoInferiorException;
	
	boolean esVacia();
	
	void vaciar();
	
	int tamano();

}
