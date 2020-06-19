package homework.tema12.entity;

public enum OrderStatus {
    CANCELLED("Cancelled"),
    DISPUTED("Disputed"),
    IN_PROCESS("In Process"),
    ON_HOLD("On Hold"),
    RESOLVED("Resolved"),
    SHIPPED("Shipped");

    private String name;

    OrderStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
