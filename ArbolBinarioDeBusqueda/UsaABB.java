public class UsaABB {
    public static void main(String[] args) {
        ABB arbol = new ABB();

      
        arbol.insertarNodo(50, arbol.regresaRaiz());
        arbol.insertarNodo(30, arbol.regresaRaiz());
        arbol.insertarNodo(20, arbol.regresaRaiz());
        arbol.insertarNodo(40, arbol.regresaRaiz());
        arbol.insertarNodo(70, arbol.regresaRaiz());
        arbol.insertarNodo(60, arbol.regresaRaiz());
        arbol.insertarNodo(80, arbol.regresaRaiz());

      
        System.out.println("Recorrido Preorden:");
        arbol.imprimirPreorden(arbol.regresaRaiz());

        System.out.println("\nRecorrido Inorden:");
        arbol.imprimirInorden(arbol.regresaRaiz());

        System.out.println("\nRecorrido Postorden:");
        arbol.imprimirPostorden(arbol.regresaRaiz());

        int valorABuscar = 40;
        arbol.buscarNodo(arbol.regresaRaiz(), valorABuscar);

        int valorAEliminar = 30;
        arbol.eliminarNodo(arbol.regresaRaiz(), valorAEliminar);

        System.out.println("\nÁrbol después de eliminar el nodo con valor " + valorAEliminar + ":");
        arbol.imprimirArbolHorizontal(arbol.regresaRaiz(), 0);
    }
    
}