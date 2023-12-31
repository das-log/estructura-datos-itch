public class ListaSimple {
	Node top;

	// Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato) {
		if (top == null) { // verificar si la lista esta vacia
			top = new Node();
			top.name = dato;
			top.next = null;

			return true;
		} else {
			return false;
		}
	}

	public void insertaAntesPrimerNodo(String nombre) {
		Node temp;
		temp = new Node();
		temp.name = nombre;
		temp.next = this.top;
		this.top = temp;
		temp = null;
	}

	public void insertaAlFinal(String nombre) {
		Node temp = new Node();
		temp.name = nombre;
		temp.next = null;
		// Node temp2;
		Node temp2 = this.top;

		while (temp2.next != null)
			temp2 = temp2.next;

		temp2.next = temp;
		temp = null;
		temp2 = null;
	}

	public boolean insertaEntreNodos(String nombre, String buscado) {
		Node temp = new Node();
		temp.name = nombre;
		Node temp2 = this.top;

		// boolean NodoNoEncontrado = true;

		while ((temp2 != null)
				&& temp2.name.equals(buscado) == false) {
			temp2 = temp2.next;
		}

		if (temp2 != null) { // Nodo buscado se encontró
			temp.next = temp2.next;
			temp2.next = temp;
			temp = null;
			temp2 = null;
			return true;
		} else
			return false;
	}

	public void imprimir() {
		for (Node temp = this.top; temp != null; temp = temp.next) {
			System.out.print("[ " + temp.name + " ] -> ");
		}

		System.out.print("[X]\n");
	}

	public String toString() {
		String cadAux = "";
		for (Node temp = this.top; temp != null; temp = temp.next) {
			cadAux += "[ " + temp.name + " ] -> ";
		}

		cadAux += "[X]\n";

		return cadAux;
	}

	// Métodos de borrado
	public void borrarPrimerNodo() {
		this.top = this.top.next;
	}

	// Borrar cualquier nodo que no sea el primero
	public boolean borrarCualquierNodo(String buscado) {
		Node temp = this.top;

		while ((temp != null)
				&& temp.name.equals(buscado) == false) {
			temp = temp.next;
		}

		if (temp != null) { // Nodo buscado se encontró
			temp.next = temp.next.next;
			temp = null;

			return true;
		} else
			return false;
	}

	// se implementa como dos funciones diferentes

	public void obtenerPosicionesNodos() {
		Node temp = this.top;
		int c = 0;
		while (temp != null) {
			System.out.println("[posicion: " + c + " , nodo: " + temp.name + " ]");
			temp = temp.next;
			c++;
		}

	}

	// buscar nodo por posicion
	public Node obtenerNodoPorPosicion(int posicion) {
		Node temp = new Node();
		temp = this.top;
		int c = 0;
		while (temp != null) {
			if (c == posicion) {
				System.out.println(temp.name);
				return temp;

			}
			temp = temp.next;
			c++;

		}
		temp = null;
		return null;
	}

	// insertar nuevo nodo antes del ultimo
	public void insertarAntesUltimo(String nombre) {
		Node temp = new Node();
		temp.name = nombre;
		temp.next = null;

		// comprobamos si la lista esta vacia
		if (top == null) {
			top = temp;
			return;
		}

		// si solo hay un nodo, se inserta antes de el
		if (top.next == null) {
			temp.next = top;
			top = temp;
			return;
		}

		Node temp2 = this.top;
		Node anterior = null;

		while (temp2.next != null) {
			anterior = temp2;
			temp2 = temp2.next;
		}

		temp.next = temp2;
		anterior.next = temp;
	}

	// intercambiar nodo existente por uno nuevo
	public void intercambiarNodos(String existente, String nombre) {
		Node temp = new Node();
		temp.name = nombre;
		temp.next = null;

		// debemos buscar el nodo anterior al existente tambien
		Node nodoAnterior = null;
		Node nodoExistente = this.top;

		while (nodoExistente != null && !nodoExistente.name.equals(existente)) {
			nodoAnterior = nodoExistente;
			nodoExistente = nodoExistente.next;

		}

		if (nodoExistente == null) {
			System.out.println("El nodo existente no fue encontrado.");
			return;
		}

		temp.next = nodoExistente.next;

		// si el nodo existente no es el inicial
		if (nodoAnterior != null) {
			nodoAnterior.next = temp;
		} else {
			this.top = temp;

		}

	
	}

}
