package com.amrita.task.repository;

import com.amrita.task.entity.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {

    @Query(value = "Update order_details set order_status = :itemStatus  where order_id = :orderId and item_id = :itemId", nativeQuery = true)
    OrderDetails updateItemStatus(@Param("orderId") Long orderId, @Param("itemId") Long itemId, @Param("itemStatus") String itemStatus);
}
