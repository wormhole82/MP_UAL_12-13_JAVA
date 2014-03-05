package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class Fecha.
 */
public class Fecha {

	/** The dia. */
	private int dia;
	
	/** The mes. */
	private int mes;
	
	/** The a�o. */
	private int a�o;
	
	
	/**
	 * Instantiates a new fecha.
	 *
	 * @param dia the dia
	 * @param mes the mes
	 * @param a�o the a�o
	 */
	public Fecha(int dia, int mes, int a�o){
		this.dia = dia;
		this.mes = mes;
		this.a�o = a�o;
	}
	
	
	/**
	 * Gets the dia.
	 *
	 * @return the dia
	 */
	public int getDia(){
		return dia;
	}
	
	/**
	 * Gets the mes.
	 *
	 * @return the mes
	 */
	public int getMes(){
		return mes;
	}
	
	/**
	 * Gets the a�o.
	 *
	 * @return the a�o
	 */
	public int getA�o(){
		return a�o;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return dia+"-"+mes+"-"+a�o;
	}
	
	
	

}
