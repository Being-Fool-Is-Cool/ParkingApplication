package com.amrita.task.controller;

import com.amrita.task.entity.Category;
import com.amrita.task.entity.Item;
import com.amrita.task.entity.OrderDetails;
import com.amrita.task.entity.OrderMaster;
import com.amrita.task.repository.CategoryRepository;
import com.amrita.task.service.CookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cook")
public class CookController {
    @Autowired
    CookService cookService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> getAllCategory() {
        return cookService.getAllCategory();
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<OrderMaster> getAllOrdersFromMaster() {
        return cookService.getAllOrdersFromMaster();
    }

    @RequestMapping(value = "/orderd", method = RequestMethod.GET)
    public List<OrderDetails> getAllOrderDetails() {
        return cookService.getAllOrderDetails();
    }

    @RequestMapping(value = "/category/{name}", method = RequestMethod.GET)
    public boolean isAlreadyExistCategory(@PathVariable("name") String name) {
        return cookService.isAlreadyExistCategory(name);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category addCategory(@RequestParam("name") String name) {
        return cookService.addCategory(name);
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    public boolean isItemAlreadyExists(@RequestParam("itemName") String itemName) {
        return cookService.isItemAlreadyExists(itemName);
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item) {
        return cookService.addItem(item);
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public OrderMaster updateOrderStatusMaster(@RequestBody OrderMaster orderMaster) {
        return cookService.updateOrderStatusM(orderMaster);
    }


    public OrderDetails updateItemStatus(Long orderId, Long itemId, String itemStatus) {
        return cookService.updateItemStatus(orderId, itemId, itemStatus);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public OrderMaster addOrder(@RequestBody OrderMaster orderMaster) {
        return cookService.addOrder(orderMaster);
    }

    public void getLastOrderId() {

    }

    @RequestMapping(value = "/orderD", method = RequestMethod.POST)
    public void addOrderedItems(@RequestBody List<OrderDetails> orderDetails) {
        cookService.addOrderedItems(orderDetails);
    }

}
