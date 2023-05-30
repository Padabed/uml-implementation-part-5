package mas.mp5.rm.mas_mp5_s22284.repository;

import mas.mp5.rm.mas_mp5_s22284.model.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

    @Query("from OrderEntity as o join Delivery as d on o.id = d.id " +
            "where o.orderStatus not like 'Delivered' and d.arrivalDate is not null")
    List<OrderEntity> findWhereOrderStatusIsNotDeliveredAndDepartureTimeIsNotNull();
}
