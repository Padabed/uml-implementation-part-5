package mas.mp5.rm.mas_mp5_s22284.component;

import lombok.RequiredArgsConstructor;
import mas.mp5.rm.mas_mp5_s22284.model.OrderEntity;
import mas.mp5.rm.mas_mp5_s22284.model.OrderStatus;
import mas.mp5.rm.mas_mp5_s22284.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class OrderDataInitializer implements CommandLineRunner {

    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) {
        OrderEntity order = new OrderEntity();
        order.setId(1L);
        order.setDestination("Flora 3a");
        order.setDepartureDate(LocalDate.of(2023, 5, 21));
        order.setArrivalDate(null);
        order.setOrderStatus(OrderStatus.OnTheWay);

        orderRepository.save(order);
    }
}

