package org.mp.sesion01;

// TODO: Auto-generated Javadoc
/**
 * The Class UsoListaMultimedia.
 */
public class UsoListaMultimedia {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Ejercicio 13
		try{
		ListaMultimedia mylist = new ListaMultimedia(10);
		
		
		Pelicula peli1 = new Pelicula("Santiago Segura","Torrente", "dvd", 78, "Subires",null);
		Pelicula peli2 = new Pelicula("Santiago Segura","Torrente 2", "dvd", 78, null,null);
		Pelicula peli3 = new Pelicula("Santiago Segura","Torrente 3", "dvd", 78, "Subires",null);
			
		
		
		mylist.add(peli1);
		mylist.add(peli2);
		mylist.add(peli3);
		
		System.out.println(mylist);
		
		Pelicula peli4 = new Pelicula("Santiago Segura","Torrente 3", "dvd", 78, "Subires",null);
		
		System.out.println(mylist.get(mylist.indexOf(peli4)));
		
		//Ejercicio 15
		ListaMultimedia mylist2 = new ListaMultimedia(10);
		
		Disco disco1 = new Disco("Vi�arock 2013","Recopilaci�n Vi�a 03", "mp3", 55, "Rock");
		Disco disco2 = new Disco("Vi�arock 2012","Recopilaci�n Vi�a 02", "mp3", 58, "Rock");
		Disco disco3 = new Disco("Vi�arock 2011","Recopilaci�n Vi�a 01", "mp3", 74, "Rock");
		
		mylist2.add(disco1);
		mylist2.add(disco2);
		mylist2.add(disco3);
		
		System.out.println(mylist2);
		
		Disco disco4 = new Disco("Vi�arock 2011","Recopilaci�n Vi�a 01", "mp3", 74, "Rock");
		System.out.println("Posici�n: "+mylist2.indexOf(disco4)+" "+mylist2.get(mylist2.indexOf(disco4)));
		
		//Duraci�n total discos
		int duracionTotal = 0;
		for(int i=0; i < mylist2.getLength() ; i++){
			if(mylist2.get(i) != null){
				duracionTotal += mylist2.get(i).getDuracion();
			}
		}
		
		System.out.println("La duraci�n total de la lista de Discos es: "+duracionTotal+" minutos.");

		//N� de discos de rock
		int discosRock = 0;
		for(int i=0; i < mylist2.getLength() ; i++){
			if(mylist2.get(i) != null){
				Disco temp = (Disco) mylist2.get(i);
				if(temp.getGenero().equals("Rock")){
					discosRock++;
				}
			}
		}
				
		System.out.println("N� discos Rock: "+discosRock+".");
		
		
		//N� peliculas sin actriz principal
		
		int pelisSinActriz = 0;
		for(int i=0; i < mylist.getLength() ; i++){
			if(mylist.get(i) != null){
				Pelicula temp = (Pelicula) mylist.get(i);
				if(temp.getActrizPrincipal() == null){
					pelisSinActriz++;
				}
			}
		}
		
		System.out.println("N� peliculas sin Actriz Principal: "+pelisSinActriz+".");
		
		}catch(Exception e){
			System.out.println(e.getMessage()); 
		}
		
	}

}
