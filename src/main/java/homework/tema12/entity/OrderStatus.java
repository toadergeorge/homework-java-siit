package homework.tema12.entity;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

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

    public static OrderStatus fromString(String text) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.name.equalsIgnoreCase(text)) {
                return status;
            }
        }
        return null;
    }
}
