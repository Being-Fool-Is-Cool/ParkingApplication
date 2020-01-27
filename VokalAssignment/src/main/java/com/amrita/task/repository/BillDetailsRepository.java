package com.amrita.task.repository;

import com.amrita.task.entity.BillDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDetailsRepository extends CrudRepository<BillDetails, Long> {
    public List<BillDetails> findByTableNo(Long tableNo);
}
