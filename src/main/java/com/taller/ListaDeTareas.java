package com.taller;

import java.util.*;

    public class ListaDeTareas {
        public static void main(String[] args) {

        // Crear un LinkedHashSet para almacenar las tareas

        LinkedHashSet<String> tareas = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌟 BIENVENIDO A TU LISTA DE TAREAS 🌟");

        // Pedir al usuario que ingrese una lista de tareas

        System.out.println("Por favor, ingresa tus tareas (escribe 'fin' para terminar):");
        while (true) {
            System.out.print("Ingresa una tarea: ");
            String tarea = scanner.nextLine();

            // Si el usuario escribe "fin", salimos del bucle

            if (tarea.equalsIgnoreCase("fin")) {
                break;
            }

            // Validamos que la tarea no contenga números

            if (contieneNumeros(tarea)) {
                System.out.println("❌ Error: No se permiten números en las tareas. Intenta nuevamente.");
                continue; // Volvemos al inicio del bucle
            }

            // Agregamos la tarea al LinkedHashSet

            tareas.add(tarea);
        }

        // Mostrar la lista de tareas en el orden ingresado

        System.out.println("\n📝 Tu lista de tareas:");
        int indice = 1;
        for (String tarea : tareas) {
            System.out.println(indice + ". " + tarea);
            indice++;
        }

        // Permitir que el usuario elimine una tarea de la lista

        System.out.println("\n¿Deseas eliminar alguna tarea? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Ingresa el número de la tarea que deseas eliminar: ");
            int tareaAEliminar = Integer.parseInt(scanner.nextLine());

            // Convertimos el LinkedHashSet a un ArrayList para poder eliminar por índice
            
            int contador = 1;
            String tareaEliminada = null;

            for (String tarea : tareas) {
                if (contador == tareaAEliminar) {
                    tareaEliminada = tarea;
                    break;
                }
                contador++;
            }

            if (tareaEliminada != null) {
                tareas.remove(tareaEliminada);
                System.out.println("✅ Tarea eliminada: " + tareaEliminada);
            } else {
                System.out.println("❌ No se encontró ninguna tarea con ese número.");
            }
        }

        // Mostramos la lista actualizada

        System.out.println("\n📝 Lista de tareas actualizada:");
        indice = 1;
        for (String tarea : tareas) {
            System.out.println(indice + ". " + tarea);
            indice++;
        }

        System.out.println("\n🚀 ¡Gracias por usar tu lista de tareas!");
        scanner.close();
    }

    // Método para verificar si una cadena contiene números 
    //fuente de donde tome para la comprobacion de numeros 
    // https://jcodepoint.com/java/verificar-si-una-cadena-contiene-caracteres-numericos-en-java/#:~:text=es%20un%20n%C3%BAmero.-,El%20m%C3%A9todo%20Character.,pronto%20como%20encontremos%20un%20d%C3%ADgito.  

    private static boolean contieneNumeros(String texto) {
        for (char c : texto.toCharArray()) {
            if (Character.isDigit(c)) {
                return true; // Si encuentra un número, retorna true
            }
        }
        return false; // Si no encuentra números, retorna false
    }
}