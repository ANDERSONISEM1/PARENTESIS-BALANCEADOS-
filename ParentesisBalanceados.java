
package parentesisbalanceados;

import java.util.*;

public class ParentesisBalanceados {
// Función para verificar si los paréntesis en una cadena están balanceados
    public static boolean parentesisBalanceados(String cadena) {
        Stack<Character> pila = new Stack<>();// Pila para almacenar paréntesis de apertura
        // Iterar sobre cada caracter en la cadena
        for (char c : cadena.toCharArray()) {
            if (c == '(') {// Si el caracter es un paréntesis de apertura
                pila.push(c);// Empujarlo a la pila
            } else if (c == ')') {// Si el caracter es un paréntesis de cierre
                if (pila.isEmpty()) {
                    return false; // Hay un paréntesis de cierre sin paréntesis de apertura correspondiente
                }
                pila.pop();
            }
        }

        return pila.isEmpty(); // La pila debe estar vacía al final para que estén balanceados
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice;
// Bucle principal del programa
        do {
            // Mostrar el menú
            System.out.println("Menú:");
            System.out.println("1. Verificar paréntesis");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':// Verificar paréntesis
                    do {    
                        System.out.print("Ingrese una cadena con paréntesis: ");
                        String cadena = scanner.nextLine();
                           // Llamar a la función para verificar paréntesis y mostrar el resultado
                        if (parentesisBalanceados(cadena)) {
                            System.out.println("Los paréntesis están balanceados.");
                        } else {
                            System.out.println("Los paréntesis no están balanceados.");
                        }
                         // Preguntar al usuario si desea hacer otra verificación
                        System.out.print("¿Desea hacer otra verificación? (S/N): ");
                        choice = scanner.nextLine().toUpperCase().charAt(0);
                        while (choice != 'S' && choice != 'N') {
                            System.out.println("Criterio no válido. Ingrese una opción correcta.");
                            System.out.print("¿Desea hacer otra verificación? (S/N): ");
                            choice = scanner.nextLine().toUpperCase().charAt(0);
                        }

                    } while (choice == 'S');// Repetir si el usuario quiere hacer otra verificación
                    break;
                case '2': // Salir del programa
                    System.out.println("Saliendo del programa...");
                    break;
                default:// Opción no válida
                    System.out.println("Opción no válida. Por favor, ingrese una opción correcta.");
                    break;
            }

        } while (choice != '2');// Continuar hasta que el usuario elija salir

        scanner.close();// Cerrar el scanner al finalizar
    }
}
