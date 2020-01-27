package com.amrita.task.repository;

import com.amrita.task.entity.Category;
import com.amrita.task.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    public List<Item> findByCategoryId(Long categoryId);

    public List<Item> findByItemName(String itemName);
}
