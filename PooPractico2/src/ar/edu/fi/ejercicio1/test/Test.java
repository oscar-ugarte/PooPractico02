package ar.edu.fi.ejercicio1.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Test {
	static final Integer CANTIDAD_ELEMENTOS = 5 ;
	/**
	 *Se cambia el contenido de los multiplos de tres de la lista por el mismo valor mas la sumatoria de los elementos de la
	 *segunda lista.
	 * @param primeraLista
	 * @param segundaLista
	 * @return
	 */
	public static List<Integer> sumarMultiplosDeTresConSumatoria ( List<Integer> primeraLista, List<Integer> segundaLista )
	{
		Integer totalDeLaSuma = sumarElementosDeLaLista(segundaLista) ;
		List<Integer> listaAuxiliar = new ArrayList<Integer>();
		for(Integer numero : primeraLista)
		{
			if(numero % 3 == 0)
				numero = numero + totalDeLaSuma;
			listaAuxiliar.add(numero);
		}
		return listaAuxiliar;
	}
	
	/**
	 * Obtiene la sumatoria de todos los elementos de la lista pasada como parametros.
	 * @param lista
	 * @return
	 */
	public static Integer sumarElementosDeLaLista(List<Integer> lista)
	{
		Integer suma = 0;
		for(Integer numero : lista)
		{
			suma = suma + numero;
		}
		return suma;
	}
	
	/**
	 * Obtiene el factorial de un numero.
	 * @param numero
	 * @return
	 */
	public static Integer obtenerFactorial(Integer numero)
	{
		Integer factorial = 1 ;
		for(Integer i = 1 ; i <= numero ; i++ )
		{
			factorial = factorial * i ;
		}
		return factorial;
	}
	
	/**
	 * Recibe un lista de enteros y devuelve la misma lista cambiando los pares por su factorial.
	 * @param lista
	 * @return
	 */
	public static List<Integer> convertirParesEnSuFactorial(List<Integer> lista)
	{
		List<Integer> listaAuxiliar = new ArrayList<Integer>();
		for(Integer numero : lista)
		{
			if(numero % 2 == 0)
				numero = obtenerFactorial(numero);
			listaAuxiliar.add(numero);
		}
		return listaAuxiliar;
	}
	
	/**
	 * Obtiene el elemento con la menor posicion de la lista
	 * @param lista
	 * @return
	 */
	public static Integer obtenerPosicionDelMenor(List<Integer> lista)
	{
		Integer posicionDelMenor = 0, i = 0;
		while(i < lista.size() )
		{
			if( lista.get(posicionDelMenor) > lista.get(i)  )
			{
				posicionDelMenor = i;
			}
			i++;
		}
		return posicionDelMenor;
	}
	/**
	 * Comprueba si la lista esta ordenada
	 * @param lista
	 * @return
	 */
	public static boolean verificarOrden(List<Integer> lista )
	{
		boolean ordenado = true ;
		int i=0;
		while( ordenado & i < lista.size()-1 )
		{
			if( lista.get(i) <= lista.get(i+1)  )
			{
				i++;
			}
			else
			{
				ordenado = false;
			}
		}
		return ordenado;
	}
	
	/**
	 * Muestra el contenido de una lista de numeros enteros
	 * @param lista
	 */
	public static void mostrarLista( List<Integer> lista )
	{
		for(Integer numero : lista )
		{
			System.out.println("Numero: " + numero );
		}
	}
	
	public static List<Integer> generarListaDeEnteros()
	{
		List<Integer> lista = new ArrayList<Integer>();
		for(Integer i = 1 ; i <= CANTIDAD_ELEMENTOS ; i++ )
		{
			lista.add(  (int) Math.floor(Math.random()*(10-20+1)+20) );
		}
		return lista;
	}
	
	public static void main(String[] args) 
	{
		List<Integer> lista = generarListaDeEnteros() ;
		List<Integer> listaDos = generarListaDeEnteros();
		//lista.add(2);
		//lista.add(3);
		//lista.add(9);
		//listaDos.add(7);
		//listaDos.add(3);
		System.out.println("Lista Original.");
		mostrarLista(lista);
		System.out.println("Lista cambiando los multiplos de tres.");
		lista = sumarMultiplosDeTresConSumatoria(lista, listaDos) ;
		mostrarLista(lista);
		System.out.println("La posicion del menors es " + obtenerPosicionDelMenor(lista)  );
		lista.add(obtenerPosicionDelMenor(lista), 10);
		System.out.println("Lista con la inserccion del menor: ");
		mostrarLista(lista);
		System.out.println("Cambiar los pares por su factorial:");
		lista = convertirParesEnSuFactorial(lista);
		mostrarLista(lista);
		if(verificarOrden(lista))
			System.out.println("La lista esta ordenado.");
		else
		{
			System.out.println("La lista no esta ordenado.");
			Collections.sort(lista);
			mostrarLista(lista);
			System.out.println("La posicion del menor es " + obtenerPosicionDelMenor(lista)  );
		}
		
	}

}
