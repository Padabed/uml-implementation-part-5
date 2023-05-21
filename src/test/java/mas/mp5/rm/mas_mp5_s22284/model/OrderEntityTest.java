package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mas.mp5.rm.mas_mp5_s22284.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderEntityTest {

    @Autowired
    private OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private OrderEntity orderEntity;

    @BeforeEach
    void loadData() {
        orderEntity = OrderEntity.builder()
                .destination("Flora 3a")
                .departureDate(LocalDate.of(2020, 06, 05))
                .arrivalDate(LocalDate.of(2020, 06, 05))
                .orderStatus(OrderStatus.InPreparation)
                .build();
    }

    @Test
    void findWhereOrderStatusIsNotDeliveredAndDepartureTimeIsNotNull() {
        orderRepository.save(orderEntity);
        entityManager.flush();
        List<OrderEntity> result = orderRepository.findWhereOrderStatusIsNotDeliveredAndDepartureTimeIsNotNull();
        assertNotNull(result);
        System.out.println(result);
    }
}