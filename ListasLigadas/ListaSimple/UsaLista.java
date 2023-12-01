public class UsaLista{

	public static void main(String[] args){
		ListaSimple lista = new ListaSimple();

		lista.insertaPrimerNodo("H");
		lista.insertaAntesPrimerNodo("O");
		lista.insertaAlFinal("Y");
		lista.insertaEntreNodos("R", "A");
lista.obtenerNodoPorPosicion(1);
lista.obtenerPosicionesNodos();
		lista.imprimir();
		lista.insertarAntesUltimo("Z");
		lista.obtenerPosicionesNodos();
	}


}