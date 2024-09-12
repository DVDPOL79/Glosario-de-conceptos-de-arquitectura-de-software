
import java.util.ArrayList;
import java.util.List;

// Interfaz Mediador
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Clase Mediador Concreta
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;
    
    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }
    
    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        // Enviar mensaje a todos los usuarios excepto al remitente
        for (User user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

// Clase abstracta User
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

// Clase concreta de User
class UserImpl extends User {

    public UserImpl(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " Mensaje enviado: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " Mensaje recibido:" + message);
    }
}

// Clase principal para probar el patrón de Intermediario
public class Mediator {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();
        
        User user1 = new UserImpl(chatMediator, "David:");
        User user2 = new UserImpl(chatMediator, "Alejo:");
        User user3 = new UserImpl(chatMediator, "Lucho:");
        User user4 = new UserImpl(chatMediator, "Majo:");
        
        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);
        chatMediator.addUser(user4);
        
        user1.send("¡Hola! Nos vemos mañana en la clase de Arquitectura de Software");
    }
}
