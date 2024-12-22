import java.util.ArrayList;
import java.util.Scanner;

public class MainToDoList {

    public static void main(String[] args) {
        System.out.println("--- TO DO LIST ---");
        ArrayList<Tarea> listaTareas = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        menuPrincipal(input, listaTareas);
    }

    public static void menuPrincipal(Scanner input, ArrayList<Tarea> listaTareas){
        boolean salir = false;
            while (!salir){
                System.out.println("\n" + "--- Datos estadisticos ---" + "\n" +
                        "1. Agregar tarea. "+"\n"+
                        "2. Listar todas las tareas."+"\n"+
                        "3. Eliminar tarea."+"\n"+
                        "4. Marcar tarea como completa."+"\n"+
                        "5. Mostrar tareas completas."+"\n"+
                        "6. Mostrar tareas pendientes."+"\n"+
                        "7. Salir.");
                System.out.print("Ingresa una opcion: ");
                String opcion = input.nextLine();

                if(esNumerico(opcion)){
                    int opcionInt = Integer.parseInt(opcion);
                    salir = opciones(opcionInt, input, listaTareas);
                } else {
                    System.out.println("Error, Ingresa una opcion valida...");
                }
            }
    }

    public static boolean opciones(int opcion, Scanner input, ArrayList<Tarea> listaTareas){
        boolean salir = false;
        switch (opcion) {
            case 1: {
                System.out.println("--- Nueva tarea ---");
                System.out.print("Descripcion de la tarea: ");
                String descripcion = input.nextLine();
                var tarea = new Tarea(descripcion);
                listaTareas.add(tarea);
                System.out.println("Tarea agregada...");
            }break;
            case 2: {
                System.out.println("--- Lista de todas las tareas ---");
               listaTareas.forEach(System.out::println);
            } break;
            case 3: {
                System.out.println("--- Eliminar tarea ---");
                System.out.print("Ingresa el id de la tarea a eliminar: ");
                try {
                    int idTarea = Integer.parseInt(input.nextLine());
                    if (listaTareas.isEmpty()){
                        System.out.println("La tarea que quieres eliminar no existe...");
                    } else {
                        listaTareas.remove(idTarea);
                        System.out.println("Tarea eliminada...");
                    }
                }catch (Exception e){
                    System.out.println("Error, valor ingresado invalido...");
                }
            } break;
            case 4: {
                System.out.println("--- Marcar tarea como completa ---");
                try {
                    System.out.println("Ingresa el id de la tarea a marcar como completa: ");
                    int tareaCompleta = Integer.parseInt(input.nextLine());
                    listaTareas.get(tareaCompleta).setEstaCompleta(true);
                    System.out.println("Tarea marcada como completa...");
                }catch (Exception e){
                    System.out.println("Error, valor ingresado invalido...");
                }

            } break;
            case 5: {
                System.out.println("--- Mostrar tareas completas ---");
                listaTareas.stream().filter(Tarea::isEstaCompleta).forEach(System.out::println);
            } break;
            case 6: {
                System.out.println("--- Tareas pendientes ---");
                listaTareas.stream().filter(p -> !p.isEstaCompleta()).forEach(System.out::println);
            } break;
            case  7: {
                System.out.println("Fin de ejecucion....");
                salir = true;
            } break;
            default: {
                System.out.println("Opcion invalida, vuelve a intentar...");
            }
        }
        return salir;
    }

    public static boolean esNumerico(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
