package moon.codingmate._11_primitive_obsession._30_repliace_primitive_with_object;

public class Order {

//    private String priorityValue;

    private Priority priority;

    public Order(Priority priority) {
        this.priority = priority;
    }

    public Order(String priorityValue) {
//        this.priorityValue = priorityValue;
//        this.priority = new Priority(priorityValue);
        this(new Priority(priorityValue));

    }

    public Priority getPriority() {
        return priority;
    }
    /*
    public String getPriorityValue() {
        return priorityValue;
    }

     */
}
