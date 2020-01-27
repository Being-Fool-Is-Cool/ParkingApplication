package com.amrita.task.service;

import com.amrita.task.entity.Category;
import com.amrita.task.entity.Item;
import com.amrita.task.entity.OrderDetails;
import com.amrita.task.entity.OrderMaster;
import com.amrita.task.repository.CategoryRepository;
import com.amrita.task.repository.ItemRepository;
import com.amrita.task.repository.OrderDetailsRepository;
import com.amrita.task.repository.OrderMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    ItemRepository itemRepository;

    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public List<OrderMaster> getAllOrdersFromMaster() {
        return (List<OrderMaster>) orderMasterRepository.findAll();
    }

    public List<OrderDetails> getAllOrderDetails() {
        return (List<OrderDetails>) orderDetailsRepository.findAll();
    }

    public boolean isAlreadyExistCategory(String name) {
        if(categoryRepository.findByCategoryName(name) != null)
            return true;
        return false;
    }

    public Category addCategory(String name) {
        return categoryRepository.save(new Category(name));
    }

    public boolean isItemAlreadyExists(String itemName) {
        if (itemRepository.findByItemName(itemName) != null)
            return true;
        return false;
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public OrderMaster updateOrderStatusMaster(Long orderId, String status) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        orderMaster.setOrderStat(status);
        return orderMasterRepository.save(orderMaster);
    }
    public OrderMaster updateOrderStatusM(OrderMaster orderMaster) {
        return updateOrderStatusMaster(orderMaster.getId(), orderMaster.getOrderStat());
    }

    public OrderDetails updateItemStatus(Long orderId, Long itemId, String itemStatus) {
        return orderDetailsRepository.updateItemStatus(orderId, itemId, itemStatus);
    }

    public OrderMaster addOrder(OrderMaster orderMaster) {
        return orderMasterRepository.save(orderMaster);
    }

    public void getLastOrderId() {

    }

    public void addOrderedItems(List<OrderDetails> orderDetails) {
        orderDetailsRepository.saveAll(orderDetails);
    }

}
