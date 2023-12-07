public class ABB{
	private Nodo raiz;

	ABB(){
		this.raiz = null;
	} 

	public boolean esVacio(){
		return (this.raiz == null); 
	}

	public Nodo regresaRaiz(){
		return this.raiz;
	}

	public void insertarNodo(int valor, Nodo nodoRef){
		if (nodoRef == null){
			nodoRef = new Nodo();
			nodoRef.dato = valor;
			nodoRef.izquierdo = null;
			nodoRef.derecho = null;
		}
		else 
			if (valor <= nodoRef.dato)
				insertarNodo(valor, nodoRef.izquierdo);
			else
				if (valor > nodoRef.dato)
				insertarNodo(valor, nodoRef.derecho);
	}


}










