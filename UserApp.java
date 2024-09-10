

// Capa de Presentación
import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrar Productos");
            System.out.println("2. Listar Productos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            if (option == 1) {
                System.out.print("Ingresa el nombre del Producto: ");
                String username = scanner.nextLine();
                userService.registerUser(username);
            } else if (option == 2) {
                userService.listUsers();
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}

