public class GymMember {
    private String name;
    private String membershipType; // Tipo de membresía (Ej: mensual, anual)

    public GymMember(String name, String membershipType) {
        this.name = name;
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
