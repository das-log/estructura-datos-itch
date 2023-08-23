/*
 * Se piden ingresar 2 datos por dia: tiempo, velocidad media.
 * las calorias consumidas se calcularan por dia mediante una funcion.
 * como tenemos una distancia especificada de 10,000 metros y un rango de velocidad de 4 - 6 km/h, 
 * podemos calcular el tiempo usando valores de ese rango.
 * 
 * se podria implementar una sobrecarga de constructor para calcular la velocidad usando el tiempo si se tuviera.
 * 
 */
import java.util.Scanner;
 /*se crea la clase dia */

public class Dia{
   private double tiempo;
   private int velocidad;
   private int peso;
   private double calPerdidas;

   public Dia(int velocidad, int peso){
      this.velocidad = velocidad;
      this.peso = peso;
      this.tiempo = calculoTiempo();
      this.calPerdidas = caloriasPerdidas();
   }


   public double calculoTiempo(){ //funcion para calcular tiempo

      /* consideramos 10km porque es equivalente a 10,000 metros, debido a la unidad de velocidad */
      double tiempo = 10/velocidad; 
      return tiempo;
    }

    
    public double caloriasPerdidas(){ //funcion para calcular calorias perdidas
      double calPerdidas = 1.03 * peso * 10;
      return calPerdidas;
    }

    //metodos accesores

    public double getTiempo(){
      return tiempo;
    }

    public double getCalPerdidas(){
      return calPerdidas;
    }

public static void main(String[] args) {
 //creamos arreglo con cada dia de entrenamiento
 Scanner entrada = new Scanner(System.in);
 System.out.println("Ingrese cuantos dias entreno: ");
 int dias = entrada.nextInt();

 
 Dia[] entrenamiento = new Dia[dias]; //creamos un arreglo de tipo dia

 //llenamos el arreglo 
 for (int i = 0; i < dias; i++) {
  System.out.println("Ingrese la velocidad para el día " + (i + 1) + ": ");
  int velocidad = entrada.nextInt();
  
  System.out.println("Ingrese el peso para el día " + (i + 1) + ": ");
  int peso = entrada.nextInt();

  // Creamos un objeto Dia con los valores ingresados
  entrenamiento[i] = new Dia(velocidad, peso);
System.out.println("Estadisticas para el dia "+i+1);
  System.out.println("El tiempo de fue de: " +entrenamiento[i].getTiempo()+" horas.");
  System.out.println("calorias perdidas: "+entrenamiento[i].getCalPerdidas()+" calorias.");

 }

 //agregar ciclo para porcentaje de mejora con condicion para que calcule apartir de la segunda fecha
}



}
