import java.util.ArrayList;
import java.util.List;

// Definimos la interfaz para los consumidores de eventos
interface EventListener {
    void onEvent(String event);
}

// Clase que actúa como el Bus de Eventos
class EventBus {
    private List<EventListener> listeners = new ArrayList<>();

    // Método para registrar un consumidor
    public void register(EventListener listener) {
        listeners.add(listener);
    }

    // Método para emitir un evento
    public void emit(String event) {
        for (EventListener listener : listeners) {
            listener.onEvent(event);
        }
    }
}

// Clase que simula el servicio de notificación por correo
class EmailService implements EventListener {
    @Override
    public void onEvent(String event) {
        if (event.equals("Compra Realizada")) {
            System.out.println("Correo Electronico: Enviando correo de confirmacion...");
        }
    }
}

// Clase que simula el servicio de notificación por SMS
class SMSService implements EventListener {
    @Override
    public void onEvent(String event) {
        if (event.equals("Compra Realizada")) {
            System.out.println("Mensajeria sms: Enviando SMS de confirmacion...");
        }
    }
}

// Clase principal donde se orquesta todo
public class MainBus {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        // Registramos los consumidores
        eventBus.register(new EmailService());
        eventBus.register(new SMSService());

        // Simulamos que una compra ha sido realizada
        System.out.println("Compra realizada por el usuario...");
        eventBus.emit("Compra Realizada");
    }
}
