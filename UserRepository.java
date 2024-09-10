

// Capa de Persistencia
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<String> users = new ArrayList<>();

    public void addUser(String user) {
        users.add(user);
    }

    public List<String> getUsers() {
        return users;
    }
}
