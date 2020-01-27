package com.amrita.task.repository;

import com.amrita.task.entity.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends CrudRepository<Parking, Long> {
}
