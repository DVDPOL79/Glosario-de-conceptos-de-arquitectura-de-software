// Capa de Lógica de Negocio
public class UserService {
    private UserRepository userRepository = new UserRepository();

    public void registerUser(String user) {
        if (user != null && !user.isEmpty()) {
            userRepository.addUser(user);
            System.out.println("Producto cargado " + user);
        } else {
            System.out.println("Producto no valido");
        }
    }

    public void listUsers() {
        System.out.println("Productos a la venta " + userRepository.getUsers());
    }
}
