public class ListaDoble{

	Node topForward;
	Node topBackward;

	//Métodos para los casos de inserción de nodos
	public boolean insertaPrimerNodo(String dato){
		if (topForward == null) { //La lista está vacía
			topForward = new Node();
			topForward.name = dato;
			topForward.previous = null;
			topForward.next = null;
			
			topBackward = topForward;

			return true;
		}
		else {
			return false;
		}
	}
	
	public void imprimir(){
		System.out.print("[X]"); 

		for (Node temp = this.topForward; temp != null; temp = temp.next){
			System.out.print(" <- [ " + temp.name + " ] -> ");
		}

		System.out.print("[X]\n"); 
	}
	
	public String toString(){
		String cadAux = "[X]";
		for (Node temp = this.topForward; temp != null; temp = temp.next){
			cadAux += " <- [ " + temp.name + " ] -> ";
		}

		cadAux += "[X]\n"; 

		return cadAux;
	}

	public void insertaAntesPrimerNodo(String nombre){
		Node temp; 
		temp = new Node ();
		temp.name = nombre;
		temp.next = this.topForward;
		this.topForward.previous = temp;
		this.topForward = temp;
		temp = null;
	}

	public void insertaAlFinal(String nombre){
		Node temp = new Node ();
		temp.name = nombre;
		temp.next = null;
		
		temp.previous = this.topBackward;
		this.topBackward.next = temp;
		this.topBackward = temp;
		temp = null;
	}

	public boolean insertaEntreNodos(String nombre, String buscado){
		Node temp = new Node();
		temp.name = nombre;
		Node temp2 = this.topForward;

		//boolean NodoNoEncontrado = true;

		while ( (temp2 != null) 
				&& temp2.name.equals(buscado) == false ) {	
		         temp2 = temp2.next;
		}

		if (temp2 != null){  //Nodo buscado se encontró
			temp.next = temp2.next;
			temp2.next = temp;

			temp.previous = temp2;
			temp.next.previous = temp;

			temp = null;
			temp2 = null;
			
			return true;
		}
		else return false;
	} 
	
	//Métodos de borrado
	public void borrarPrimerNodo(){
		this.topForward = this.topForward.next;
		this.topForward.previous.next = null;
		this.topForward.previous = null;
	}

	public void borrarUltimoNodo(){
		this.topBackward = this.topBackward.previous;
		this.topBackward.next.previous = null;
		this.topBackward.next = null;
	}

	
	//Borrar cualquier nodo que no sea el primero
	public boolean borrarCualquierNodo(String buscado){
		Node temp = this.topForward;

		while ( (temp != null) 
				&& temp.name.equals(buscado) == false ) {	
		         temp = temp.next;
		}

		if (temp != null){  //Nodo buscado se encontró
			temp.next = temp.next.next;
			temp.next.previous.previous = null;
			temp.next.previous.next = null;
			temp.next.previous = temp;
			temp = null;
			
			return true;
		}
		else return false;
	}

	//TODO: Crear el método para borrar el nodo buscado
	//Adecuación del método de borrado: borrarCualquierNodo()

	
	// se implementa como dos funciones diferentes

	public void obtenerPosicionesNodos() {
		Node temp = this.topForward;
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
		temp = this.topForward;
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

	public void insertarAntesUltimo(String nombre){
		Node temp = new Node();
		temp.name = nombre;
		temp.next = null;
		temp.previous = null;
	
		// Comprueba si la lista está vacía
		if (topForward == null) {
			topForward = temp;
			topBackward = temp;
			return;
		}
	
		if (topForward.next == null) { // Solo hay un nodo en la lista
			temp.next = topForward;
			topForward.previous = temp;
			topForward = temp;
			topBackward = temp.next;
		} else {
			Node temp2 = topBackward.previous;
			temp2.next = temp;
			temp.previous = temp2;
			temp.next = topBackward;
			topBackward.previous = temp;
		}

		
	

		
	}
// intercambiar nodo existente por uno nuevo

	public void intercambiarNodos(String existente, String nombre) {
		Node temp = new Node();
		temp.name = nombre;
		temp.next = null;
		temp.previous = null;
	
		Node nodoExistente = this.topForward;
		while (nodoExistente != null && !nodoExistente.name.equals(existente)) {
			nodoExistente = nodoExistente.next;
		}
	
		if (nodoExistente == null) {
			System.out.println("El nodo existente no fue encontrado.");
			return;
		}
	
		temp.previous = nodoExistente.previous;
		temp.next = nodoExistente.next;
	
		if (nodoExistente.previous != null) {
			nodoExistente.previous.next = temp;
		} else {
			this.topForward = temp;
		}
	
		if (nodoExistente.next != null) {
			nodoExistente.next.previous = temp;
		} else {
			this.topBackward = temp;
		}
	}
	
	
		

	}

