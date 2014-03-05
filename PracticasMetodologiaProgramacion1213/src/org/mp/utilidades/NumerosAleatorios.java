package org.mp.utilidades;

// CONSTRUCCION: con (a) ninguna inicializaci�n o (b) un entero
//     que especifica el estado inicial del generador
//
// ******************OPERACIONES PUBLICAS*********************
//     Devuelve un n�mero aleatorio seg�n una distribuci�n:
// int randomInt( )                     --> Uniforme, 1 a 2^31-1
// double randomReal( )                 --> Uniforme, 0..1
// int randomInt( int linf, int lsup )  --> Uniforme linf..lsup
// Un m�todo estatico relacionado:
// void permuta( Object [ ] a )         --> Permutaci�n aleatoria

/**
 * Clase de n�meros aleatorios, usando un 
 * generador lineal de congruencias 31-bit.
 * Observese que java.util contiene una clase Random,
 * por lo que se deben vigilar los conflictos de nombre.
 * 
 */
public class NumerosAleatorios
{
    private static final int A = 48271;
    private static final int M = 2147483647;
    private static final int Q = M / A;
    private static final int R = M % A;

    private int estado;

    /**
     * Construcci�n de un objeto Random cuyo
     * estado inicial se obtiene del reloj del sistema.
     */
    public NumerosAleatorios( )
    {
        this( (int) ( System.currentTimeMillis( ) % Integer.MAX_VALUE ) );
    }

    /**
     * Construcci�n de un objeto Random
     * especificando un estado inicial.
     * @param valorInicial el estado inicial.
     */
    public NumerosAleatorios( int valorInicial )
    {
        if( valorInicial < 0 )
            valorInicial += M;

        estado = valorInicial;
        if( estado == 0 )
            estado = 1;
    }

    /**
     * Devuelve un entero pseudoaleatorio, y cambia 
     * el estado.
     * @return un entero pseudoaleatorio.
     */
    public int randomInt( )
    {
        int estadoTmp = A * ( estado % Q ) - R * ( estado / Q );
        if( estadoTmp >= 0 )
            estado = estadoTmp;
        else
            estado = estadoTmp + M;

        return estado;
    }

    /**
     * Devuelve un valor de tipo double en (0,1), y
     * cambia el estado interno.
     * @return el double pseudoaleatorio.
     */
    public double randomReal( )
    {
        return randomInt( ) / ( double ) M;
    }

    /**
     * Devuelve un entero en el rango [linf,lsup], y
     * cambia el estado interno.
     * @param linf el valor minimo.
     * @param lsup el valor m�ximo.
     * @return el entero pseudoaleatorio.
     */
    public int randomInt( int linf, int lsup )
    {
        double tamanyoParticion = (double) M / ( lsup - linf + 1 );

        return (int) ( randomInt( ) / tamanyoParticion ) + linf;
    }


    /**
     * Reordena un vector de forma aletoria.
     * Los n�meros aleatorios empleados dependen de la hora y el dia.
     * @param el vector a.
     */
    public static final void permuta( Object [ ] a )
    {
        NumerosAleatorios r = new NumerosAleatorios( );

        for( int j = 1; j < a.length; j++ )
            swapReferencias( a, j, r.randomInt( 0, j ) );
    }

    public static void swapReferencias( Object [ ] a, int index1, int index2 )
    {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

}
