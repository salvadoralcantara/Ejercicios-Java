import java.util.ArrayList;
import java.util.Scanner;

public class Estadisticas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var salir = false;
        ArrayList<Integer> listaNumeros = new ArrayList<>();

       try{
           while (!salir){
               System.out.print("Introduce un número (o escribe \"fin\" para terminar): ");
               String entrada = input.nextLine().toLowerCase().strip();

              if(entrada.equals("fin")){
                  salir = true;
                  if (!listaNumeros.isEmpty()){
                      System.out.println(datosEstadisticos(listaNumeros));
                  }
                  System.out.println("Fin del programa...");
              } else {
                  try {
                      var entradaNum = Integer.parseInt(entrada);
                      listaNumeros.add(entradaNum);
                  } catch (Exception e){
                      System.out.println("Error, no estas ingresando un numero, vuelve a intentar.");
                  }
              }
           }
       }catch (Exception e){
           System.out.println("Error de tipo: " + e);
       }
    }

   private static String datosEstadisticos(ArrayList<Integer> listaNumeros){
        int suma = 0, promedio = 0;
       int numMayor = listaNumeros.get(0);
      int  numMenor = listaNumeros.get(0);

       for (int i : listaNumeros) {
           suma += i;

           if (i > numMayor) {
               numMayor = i;
           }
           if (i < numMenor) {
               numMenor = i;
           }
       }
            if (!listaNumeros.isEmpty()) {
                promedio = suma / listaNumeros.size();
            } else {
                promedio = 0;
            }


       return "\n" + "--- Datos estadisticos ---" + "\n" +
               "- Suma de numeros ingresados: " + suma + "\n" +
               "- Numero MAYOR ingresado: " + numMayor + "\n" +
               "- Numero MENOR ingresado: " + numMenor + "\n" +
               "- Promedio de numeros ingresados: " + promedio + "\n" +
               "- Cantidad de numeros ingresados: " + listaNumeros.size() + "\n";
   }
}
