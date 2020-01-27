package com.amrita.task.controller;

import com.amrita.task.entity.*;
import com.amrita.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> getAllCategory() {
        return userService.getAllCategory();
    }

    @RequestMapping(value = "/item/category", method = RequestMethod.GET)
    public List<Item> getItemByCategoryId(@RequestParam("categoryId") Long categoryId) {
        return userService.getAllItemsByCategoryId(categoryId);
    }

    @RequestMapping(value = "/order/table", method = RequestMethod.GET)
    public List<OrderMaster> getOrderByTableId(@RequestParam("tableId") Long tableId) {
        return userService.getAllOrderByTableId(tableId);
    }

    @RequestMapping(value = "/bill/table", method = RequestMethod.GET)
    public List<BillDetails> getBillDetails(@RequestParam("tableId") Long tableId) {
        return userService.getBillDetails(tableId);
    }

}
