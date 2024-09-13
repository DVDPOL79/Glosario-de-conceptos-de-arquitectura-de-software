public class GymMemberController {
    private GymMember model;
    private GymMemberView view;

    public GymMemberController(GymMember model, GymMemberView view) {
        this.model = model;
        this.view = view;
    }

    public void setMemberName(String name) {
        model.setName(name);
    }

    public String getMemberName() {
        return model.getName();
    }

    public void setMembershipType(String membershipType) {
        model.setMembershipType(membershipType);
    }

    public String getMembershipType() {
        return model.getMembershipType();
    }

    public void updateView() {
        view.printGymMemberDetails(model.getName(), model.getMembershipType());
    }
}
