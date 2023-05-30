package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mas.mp5.rm.mas_mp5_s22284.repository.CustomerRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderEntityTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private OrderEntity orderEntity;
    private Customer customer;

    @BeforeEach
    void loadData() {

        customer = Customer.builder()
                        .address("Flora 3a")
                        .fullName("Arnold Konva")
                        .email("trigger@gmail.com")
                        .phone("+375444546119")
                        .build();
        customerRepository.save(customer);

        orderEntity = OrderEntity.builder()
                .destination("Flora 3a")
                .orderStatus(OrderStatus.InPreparation)
                .customer(customer)
                .build();

        entityManager.flush();
    }

    @Test
    void findWhereOrderStatusIsNotDeliveredAndDepartureTimeIsNotNull() {
        List<OrderEntity> result = orderRepository
                .findWhereOrderStatusIsNotDeliveredAndDepartureTimeIsNotNull();
        assertNotNull(result);
        System.out.println(result);
    }
}