package mas.mp5.rm.mas_mp5_s22284.component;

import lombok.RequiredArgsConstructor;
import mas.mp5.rm.mas_mp5_s22284.model.*;
import mas.mp5.rm.mas_mp5_s22284.repository.CustomerRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.ItemRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.ProductRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        Customer customer =
                Customer.builder()
                        .address("Flora 3a")
                        .fullName("Arnold Konva")
                        .email("trigger@gmail.com")
                        .phone("+375444546119")
                        .build();
        customerRepository.save(customer);

        OrderEntity order =
                OrderEntity.builder()
                        .destination("Madrid")
                        .orderStatus(OrderStatus.InPreparation)
                        .customer(customer)
                        .build();
        orderRepository.save(order);

        ItemEntity itemEntity =
                ItemEntity.builder()
                        .name("Mouse")
                        .price(200)
                        .build();
        itemRepository.save(itemEntity);

        Product product =
                Product.builder()
                        .item(itemEntity)
                        .order(order)
                        .build();
        productRepository.save(product);

    }
}

