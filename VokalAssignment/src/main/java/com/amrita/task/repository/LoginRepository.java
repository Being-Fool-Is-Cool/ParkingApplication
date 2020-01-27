package com.amrita.task.repository;

import com.amrita.task.entity.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
}
