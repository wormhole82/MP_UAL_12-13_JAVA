package org.mp.examentipoa2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

public class EncuestaTestA extends TestCase {

	String mensaje;

	Encuesta encuesta;
	ArrayList validacionMultiple;
	ArrayList validacionSINO;
	ArrayList validacionAlternativa;
	
	public EncuestaTestA(String name) {
		super(name);
		encuesta = new Encuesta();
		
		validacionSINO = new ArrayList();
		validacionSINO.add("SI");
		validacionSINO.add("NO");
		validacionSINO.add("Si");
		validacionSINO.add("No");
		validacionSINO.add("si");
		validacionSINO.add("no");
		
		validacionMultiple = new ArrayList();
		validacionMultiple.add("-1");
		validacionMultiple.add("0");
		validacionMultiple.add("1");
		validacionMultiple.add("2");
		validacionMultiple.add("3");
		validacionMultiple.add("4");
		validacionMultiple.add("5");

		validacionAlternativa = new ArrayList();
		validacionAlternativa.add("a");
		validacionAlternativa.add("b");
		validacionAlternativa.add("c");
		validacionAlternativa.add("d");
		validacionAlternativa.add("A");
		validacionAlternativa.add("B");
		validacionAlternativa.add("C");
		validacionAlternativa.add("D");
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testEncuesta() throws FileNotFoundException {

		rellenarEncuesta();
		imprimirEncuesta();

		String directorio = System.getProperty("user.dir");
		directorio = directorio + File.separator + "src"
				+ File.separator + "org" + File.separator + "mp"
				+ File.separator + "encuesta" 
				+ File.separator;

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {
			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			mensaje = pc.getNumero() + "-->  " + pc.getTipo() + "-->" + pc.getContestacion();
			assertTrue(mensaje, validar(pc.getTipo(), pc.getContestacion()));

		}

		File file = new File(directorio
				+ ((PreguntaContestacion) encuesta.getEncuesta().get(0))
						.getContestacion() + ".encuesta");
		PrintStream ps = new PrintStream(file);

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {

			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			ps.print(pc.getNumero() + ";");
			ps.print(pc.getTipo() + ";");
			ps.print(pc.getPregunta() + ";");
			ps.print(pc.getContestacion() + ";");
			ps.print("\n");

		}
		ps.close();
	}

	private void rellenarEncuesta() {

		// m�todo que debe rellenar por c�digo
		
		// Debe rellenar todos los nulls de las contestaciones

		// Hay cuatro tipos de preguntas:

		// ABIERTA
		// en estas debe sustituir el null por un texto

		// SI/NO
		// en estas debe elegir entre SI o NO
		
		// ALTERNATIVA
		// debe contestar con la opci�n que m�s se aproxime a su opini�n

		// MULTIPLE
		// debe contestar con el valor que m�s se aproxime a su opini�n
		// -1 (No sabe/No contesta), o un valor en una escala de 0 a 5
		// 0 (nada),
		// 1 (muy poco), 
		// 2 (poco), 
		// 3 (regular), 
		// 4(bien/bastante), 
		// 5 (muy bien/mucho)

		PreguntaContestacion pc;
		String pregunta;
		String contestacion;
		String tipo;
		int numero = 0;
		
		// preguntas de Inicio de la encuesta		
		
		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su Apellido1Apellido2Nombre \n";
		// Por ejemplo MartinezPerezJulian
		contestacion = "SubiresParraDavid";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "SI/NO";
		pregunta = " � Ha hecho usted las pr�cticas ? \n";
		// Parece l�gico decir algo como SI
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � Cu�l es tu edad ? \n"
				+ "a) 18 a 20 \n"
				+ "b) 21 a 25 \n"
				+ "c) 26 a 30 \n"
				+ "d) >30 \n"
				;
		contestacion = "b)";	
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � Cu�ntas veces te has matriculado en la asignatura Introducci�n a la Programaci�n ? \n"
				  + "a) 1 \n"
				  + "b) 2 \n"
				  + "c) >2 \n"
				  ;
		contestacion = "a)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � Cu�ntas veces te has matriculado en la asignatura Metodolog�a de la Programaci�n ? \n"
				+ "a) 1 \n"
				+ "b) 2 \n"
				+ "c) >2 \n"
				;
		contestacion = "a)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � En qu� grupo docente estas matriculado ? \n"
				+ "a) Ma�ana \n"
				+ "b) Tarde \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � Estudios previos ? \n"
				+ "a) Bachiller \n"
				+ "b) Modulo \n"
				+ "c) Mayor 25 a�os \n"
				+ "d) Otros \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " Tu conocimiento en Programaci�n de Ordenadores antes de comenzar tus estudios en Ingenier�a Inform�tica era \n"
				+ "a) Ninguno \n"
				+ "b) Bajo \n"
				+ "c) Medio \n"
				+ "d) Alto \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � C�mo valoras el grado de dificultad de la materia Introducci�n a la Programaci�n ? \n"
				+ "a) Bajo \n"
				+ "b) Medio \n"
				+ "c) Alto \n"
				+ "d) Muy Alto \n"
				;
		contestacion = "b)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " � C�mo valoras el grado de dificultad de la materia Metodolog�a de la Programaci�n ?\n"
				+ "a) Bajo \n"
				+ "b) Medio \n"
				+ "c) Alto \n"
				+ "d) Muy Alto \n"
				;
		contestacion = "c)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre los repositorios y el control de versiones Subversi�n

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este a�o hemos utilizado repositorios con un sistema de control de versiones \n"
				+ " basado en Subversion \n"
				+ "� Le ha resultado sencillo empezar a utilizarlo ?\n";
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "MULTIPLE";
		pregunta = "Este a�o hemos utilizado repositorios con un sistema de control de versiones \n"
				+ " basado en Subversion \n"
				+ " � Le ha facilitado el control del c�digo que iba realizando en los grupos de trabajo \n"
				+ " y en el trabajo aut�nomo ? \n"
				;
		contestacion = "Si, ademas de poder trabajar con varios equipos mediante commit/update";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = " � Ha necesitado recurrir a los repositorios en alguna ocasi�n para \n"
				+ "recuperar una copia de seguridad ? \n";
		contestacion = "No";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);	
		
		numero++;
		tipo = "SI/NO";
		pregunta = " � Incluir�as en Introduci�n a la Programaci�n \n"
				+ "la utilizaci�n de repositorios como metodolog�a de trabajo  ? \n";
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		// preguntas sobre el aprendizaje basado en pruebas (tests)
		
		numero++;
		tipo = "MULTIPLE";
		pregunta = "Teniendo como referencia la especificaci�n de un problema basada en texto escrito, \n"
				+ " como por ejemplo los guiones de pr�cticas de Introducci�n a la Programaci�n. \n"
				+ " � En qu� grado te ha ayudado la utilizaci�n de test de prueba como especificaci�n adicional  \n"
				+ " para la resoluci�n e implementaci�n del c�digo soluci�n. ? \n"
				;
		contestacion = "Creo que ayuda mucho para implementar la solucion";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ALTERNATIVA";
		pregunta = " Seg�n tu percepci�n personal, �acelera el tiempo para generar el c�digo de la soluci�n ?\n"
				+ "a) Indiferente \n"
				+ "b) Me lleva m�s tiempo \n"
				+ "c) Me lleva menos tiempo \n"
				;
		contestacion = "c)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		tipo = "ALTERNATIVA";
		pregunta = " En caso de haber contestado la opci�n c en la pregunta anterior; \n" 
				+ "en qu� grado, seg�n tu percepci�n personal, la utilizaci�n de tests de prueba \n"
				+ "acelera el tiempo para generar el c�digo de la soluci�n ? \n"
				+ "a) 25% menos de tiempo \n"
				+ "b) 50% menos de tiempo \n"
				+ "c) 75% menos de tiempo \n"
				;
		contestacion = "a)";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
			
		numero++;
		tipo = "MULTIPLE";
		pregunta = "�C�mo valoras el grado de dificultad que te ha supuesto entender el mecanismo de funcionamiento de los tests? \n"
				;
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "SI/NO";
		pregunta = " � Incluir�as en la Introduci�n a la Programaci�n \n"
				+ "la utilizaci�n de tests de prueba como forma de metodolog�a de aprendizaje ? \n";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		// preguntas sobre las clases

		numero++;
		tipo = "SI/NO";
		pregunta = " Este a�o hemos a�adido como herramienta de comunicaci�n \n"
				+ "una cuenta en twitter: ualmetodolologia. \n"
				+ " �Eres seguidor de esta cuenta \n";
		contestacion = "Si";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "MULTIPLE";
		pregunta = "� En qu� medida valora la utilidad de los foros, del aula virtual, como herramienta para la asignatura \n"
				;
		contestacion = "El foro es de gran ayuda, para solucion de errores comunes y estar informado de las actualizaciones de test por ejemplo";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "SI/NO";
		pregunta = " Est� usted de acuerdo con la siguiente afirmaci�n \n"
				+ "No suelo acudir a clases porque prefiero ir por mi cuenta \n"
				+ "ya que tengo todo lo que necesito en la Web \n";
		contestacion = "No";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "SI/NO";
		pregunta = " Est� usted de acuerdo con la siguiente afirmaci�n \n"
				+ "No suelo acudir a clases porque prefiero \n"
				+ "dedicar mi tiempo a otras asignaturas y dejar esta para m�s adelante \n";
		contestacion = "No";
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su opini�n sobre,  \n"
				+ "� Por qu� asisten pocos alumnos a las clases ? \n";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ABIERTA";
		pregunta = "Escriba su opini�n sobre,  \n"
				+ "� Qu� cosas cambiaria, o a�adir�a, para mejorar la asignatura  ? \n";
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);
		
		numero++;
		tipo = "ABIERTA";
		pregunta = "Una �ltima pregunta,  \n"
				+ "� A�ada alg�n comentario m�s que quiera que leamos ? \n";
		// Si no se te ocurre nada, puede poner  "...que el ex�men sea f�cil..."
		contestacion = null;
		pc = new PreguntaContestacion(numero, tipo, pregunta, contestacion);
		encuesta.addPregunta(pc);

	}
	
	private void imprimirEncuesta() {
		System.out.println("Encuesta");
		System.out.println("=====================");
		System.out.println();

		for (Iterator iterator = encuesta.getEncuesta().iterator(); iterator
				.hasNext();) {
			PreguntaContestacion pc = (PreguntaContestacion) iterator.next();

			System.out.println();
			System.out.println(pc.getNumero());
			System.out.println(pc.getTipo());
			System.out.println(pc.getPregunta());
			System.out.println(pc.getContestacion());
			System.out.println();
			System.out.println("=====================");
			

		}
	}

	private boolean validar(String tipo, String contestacion) {

		if (contestacion == null) {
			return false;
		}

		if (tipo.equals("ABIERTA")) {
			return true;
		}

		if (tipo.equals("SI/NO")) {
			return validacionSINO.contains(contestacion);
		}

		if (tipo.equals("MULTIPLE")) {
			return validacionMultiple.contains(contestacion);
		}
		
		if (tipo.equals("ALTERNATIVA")) {
			return validacionAlternativa.contains(contestacion);
		}

		return false;

	}
}

