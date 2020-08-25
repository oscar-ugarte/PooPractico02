package ar.edu.fi.ejercicio2.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test
{
	static final Integer CANTIDAD_ELEMENTOS = 3 ;
	
	//Comienzo de la de la conversion de numero a letras
	public static String obtenerDecenaDeDiez(Integer numero)
	{
		String decena = ""; 
		switch(numero)
		{
			case 0:
				decena = "diez";
				break;
			case 1:
				decena = "once";
			break;
			case 2:
				decena = "doce";
			break;
			case 3:
				decena = "trece";
			break;
			case 4:
				decena = "catorce";
			break;
			case 5:
				decena = "quince";
			break;
			case 6:
				decena = "dieciseis";
			break;
			case 7:
				decena = "diecisiete";
			break;
			case 8:
				decena = "dieciocho";
			break;
			case 9:
				decena = "diecinueve";
			break;			
		}				
		return decena;
	}
	
	public static String obtenerDecena(Integer numero)
	{
		String decena = "";
		switch(numero)
		{
			case 2:
				decena = "veinte";
			break;
			case 3:
				decena = "treinta";
			break;
			case 4:
				decena = "cuarenta";
			break;
			case 5:
				decena = "cincuenta";
			break;
			case 6:
				decena = "sesenta";
			break;
			case 7:
				decena = "setenta";
			break;
			case 8:
				decena = "ochenta";
			break;
			case 9:
				decena = "noventa";
			break;	
			case 10:
				decena = "cien";
			break;	
		}		
		return decena;
	}
	
	public static String obtenerUnidad(Integer numero)
	{
		String unidad = "";
		switch(numero)
		{
			case 1:
				unidad = " uno";
			break;
			case 2:
				unidad = " dos";
			break;
			case 3:
				unidad = " tres";
			break;
			case 4:
				unidad = " cuatro";
			break;
			case 5:
				unidad = " cinco";
			break;
			case 6:
				unidad = " seis";
			break;
			case 7:
				unidad = " siete";
			break;
			case 8:
				unidad = " ocho";
			break;
			case 9:
				unidad = " nueve";
			break;			
		}
		return unidad;
	}
	
	public static String convertirNumeroALetras(Integer numero)
	{
		String letras = "";
		if( numero >= 1 && numero <= 9 )
			letras = obtenerUnidad(numero).replace(" ",""); //Se borra el espacio en blanco al comienzo.
		else
		{
			if(numero >= 10 && numero <= 19)
				letras = obtenerDecenaDeDiez(numero % 10); //Para obtener entre 10 y 19
			else	
			{	
			letras = obtenerDecena(numero / 10 ); //Para los casos del 20 al 100
			letras = letras + obtenerUnidad(numero % 10);
			}
		}
		return letras;
	}	
	//Fin de la parte de la conversion de numero a letras
	
	/**
	 * Convierte el valor vinculado a la llave en mayusculas
	 * @param lista
	 * @param llave
	 * @return
	 */
	public static Map<Integer,String> convertirAMayusculas(Map<Integer,String> lista, Integer llave )
	{
		lista.put(llave, lista.get(llave).toUpperCase() );
		return lista;
	}
	
	/**
	 * Busca un valor dentro del mapa
	 * @param lista
	 * @param buscado
	 * @return
	 */
	public static Integer buscarUnValor(Map<Integer,String> lista, String buscado)
	{
		Integer llave = 0 ;
		Set<Integer> keys = lista.keySet();
		String valor;
		for(Integer key : keys)
		{
			if( buscado.equalsIgnoreCase(lista.get(key)) )
			{
				llave = key;
				break; //Para romper el ciclo,
			}
		}		
		return llave;
	}
	
	/*
	 * Muestra el contenido del hashmap
	 */
	public static void mostrarHashMap(Map<Integer,String> lista)
	{
		Set<Integer> keys = lista.keySet();
		String valor;
		for(Integer key : keys)
		{
			valor = lista.get(key);
			System.out.println("Llave: " + key + " - valor: " + valor  );
		}		
	}
	
	public static Map<Integer,String> generarMapa()
	{
		String valorEscrito;
		Map<Integer,String> mapa = new HashMap<Integer, String>();
		Integer i = 1, clave;
		
		while( i <= CANTIDAD_ELEMENTOS  )
		{
			clave =  (int) (Math.random() * 99) + 1; //Se genera la clave
			System.out.println("Clave: " + clave );
			if( !mapa.containsKey(clave)) //Se consulta si la clave no esta repetida y se agrega
			{
				valorEscrito = convertirNumeroALetras(clave); //Se genera el numero escrito
				mapa.put(clave, valorEscrito);
				i++;
			}
		}
		return mapa;
	}
	
	public static void main(String[] args) 
	{
		Integer buscado;
		Map<Integer,String> lista = generarMapa() ; //Se genera la clave 
		//Map<Integer,String> lista = new HashMap<Integer, String>();
		//lista.put(1, "uno");
		//lista.put(2, "dos");
		//lista.put(3, "tres");
		lista.put(4, "cuatro"); //Para probar el cambio a mayusculas
		//System.out.println( "El tres se repite: " + lista.containsKey(3) );
		mostrarHashMap(lista);
		buscado =  buscarUnValor(lista, "nueve") ;
		if( buscado != 0 )
		{
			System.out.println("Encontrado y actualizado el valor.");
			//lista.put(buscado, lista.get(buscado).toUpperCase() );
			lista = convertirAMayusculas(lista, buscado);
		}
		else
		{
			System.out.println("No encontrado.");
		}
		mostrarHashMap(lista);
		//Prueba con el cambio a mayusculas el valor
		buscado =  buscarUnValor(lista, "cuatro") ;
		if( buscado != 0 )
		{
			System.out.println("Encontrado y actualizado el valor.");
			lista = convertirAMayusculas(lista, buscado);
		}
		else
		{
			System.out.println("No encontrado.");
		}
		mostrarHashMap(lista);
	}
}
