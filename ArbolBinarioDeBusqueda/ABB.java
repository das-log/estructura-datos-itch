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

	//metodo para agregar nodo 

	public void insertarNodo(int valor, Nodo nodoRef) {
		if (nodoRef == null) {
			this.raiz = new Nodo();
			this.raiz.dato = valor;
			this.raiz.izquierdo = null;
			this.raiz.derecho = null;
		} else {
			if (valor <= nodoRef.dato) {
				if (nodoRef.izquierdo == null) {
					nodoRef.izquierdo = new Nodo();
					nodoRef.izquierdo.dato = valor;
					nodoRef.izquierdo.izquierdo = null;
					nodoRef.izquierdo.derecho = null;
				} else {
					insertarNodo(valor, nodoRef.izquierdo);
				}
			} else {
				if (nodoRef.derecho == null) {
					nodoRef.derecho = new Nodo();
					nodoRef.derecho.dato = valor;
					nodoRef.derecho.izquierdo = null;
					nodoRef.derecho.derecho = null;
				} else {
					insertarNodo(valor, nodoRef.derecho);
				}
			}
		}
	}
	

	//metodos de impresion

	public void imprimirPreorden(Nodo nodo){
		if (nodo!= null){
			System.out.println(nodo.dato + " ");
			imprimirPreorden(nodo.izquierdo);
			imprimirPreorden(nodo.derecho);

		}
		
	}

	public void imprimirInorden(Nodo nodo){
		if (nodo != null){
			imprimirInorden(nodo.izquierdo);
			System.out.println(nodo.dato);
			imprimirInorden(nodo.derecho);
		}
	}

	public void imprimirPostorden(Nodo nodo){
		if (nodo != null) {
			imprimirPostorden(nodo.izquierdo);
			imprimirPostorden(nodo.derecho);
			System.out.println(nodo.dato);
		}
	}


	//metodo para buscar nodo

	public  Nodo buscarNodo(Nodo nodo, int valor){
		if (nodo == null || nodo.dato == valor) {
            if (nodo != null && nodo.dato == valor) {
                System.out.println("Nodo encontrado con valor: " + valor);
            } else {
                System.out.println("Nodo no encontrado con valor: " + valor);
            }
            return nodo;
        }

        if (valor < nodo.dato) {
            return buscarNodo(nodo.izquierdo, valor);
        } else {
            return buscarNodo(nodo.derecho, valor);
        }
	}

	//metodo para eliminar nodo

	public Nodo eliminarNodo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = eliminarNodo(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = eliminarNodo(nodo.derecho, valor);
        } else {
            // Caso: nodo tiene 0 o 1 hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso: nodo tiene 2 hijos
            nodo.dato = encontrarMinimo(nodo.derecho);
            nodo.derecho = eliminarNodo(nodo.derecho, nodo.dato);
        }
        return nodo;
    }

    private int encontrarMinimo(Nodo nodo) {
        int min = nodo.dato;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return min;
    }

	//imprimir arbol horizontsal
	public void imprimirArbolHorizontal(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirArbolHorizontal(nodo.derecho, nivel + 1);
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            System.out.println(nodo.dato);
            imprimirArbolHorizontal(nodo.izquierdo, nivel + 1);
        }
    }


}










