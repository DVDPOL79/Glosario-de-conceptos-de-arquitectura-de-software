public class Gym {
    public static void main(String[] args) {
        // Crear el modelo con los datos de un miembro
        GymMember model = new GymMember("David", "Anual");

        // Crear la vista para mostrar los datos del miembro
        GymMemberView view = new GymMemberView();

        // Crear el controlador que conecta el modelo y la vista
        GymMemberController controller = new GymMemberController(model, view);

        // Mostrar los detalles del miembro
        controller.updateView();

        // Cambiar el nombre del miembro a través del controlador
        controller.setMemberName("Carlos");

        // Cambiar el tipo de membresía a través del controlador
        controller.setMembershipType("Mensual");

        // Volver a mostrar los detalles actualizados
        controller.updateView();
    }
}
