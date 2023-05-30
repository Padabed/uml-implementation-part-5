package mas.mp5.rm.mas_mp5_s22284.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mas.mp5.rm.mas_mp5_s22284.repository.CustomerRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.ItemRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.ProductRepository;
import mas.mp5.rm.mas_mp5_s22284.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AssociationsTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ProductRepository productRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Customer customer;
    private OrderEntity orderEntity;
    private Product product;
    private ItemEntity itemEntity;

    @BeforeEach
    void loadData() {
        customer = Customer.builder()
                        .address("Flora 3a")
                        .fullName("Arnold Konva")
                        .email("trigger@gmail.com")
                        .phone("+375444546119")
                        .build();

        orderEntity = OrderEntity.builder()
                        .destination("Madrid")
                        .orderStatus(OrderStatus.InPreparation)
                        .customer(customer)
                        .build();

        itemEntity = ItemEntity.builder()
                        .name("Mouse")
                        .price(200)
                        .build();

        product = Product.builder()
                        .consistsOf(itemEntity)
                        .order(orderEntity)
                        .build();

        customerRepository.save(customer);
        orderRepository.save(orderEntity);
        itemRepository.save(itemEntity);
        productRepository.save(product);

        entityManager.flush();
    }



    @Test
    void CompositionTest() {
        customerRepository.delete(customer);
        assertTrue(entityManager.contains(orderEntity));
    }
}