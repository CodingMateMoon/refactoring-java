package moon.codingmate._11_primitive_obsession._30_replace_primitive_with_object;

import java.util.List;

public class OrderProcessor {

    public long numberOfHighPriorityOrders(List<Order> orders) {
        return orders.stream()
//                .filter(o -> o.getPriorityValue() == "high" || o.getPriorityValue() == "rush")
                .filter(o -> o.getPriority().higherThan(new Priority("normal")))
                .count();
    }
}
