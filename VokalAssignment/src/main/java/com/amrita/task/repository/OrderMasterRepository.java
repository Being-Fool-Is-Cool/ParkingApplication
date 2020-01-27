package com.amrita.task.repository;

import com.amrita.task.entity.OrderMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMasterRepository extends CrudRepository<OrderMaster, Long> {
    public List<OrderMaster> findByTableNo(Long tableId);
}
