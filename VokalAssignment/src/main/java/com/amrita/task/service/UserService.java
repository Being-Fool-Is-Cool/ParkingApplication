package com.amrita.task.service;

import com.amrita.task.entity.*;
import com.amrita.task.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    BillDetailsRepository billDetailsRepository;

    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public List<Item> getAllItemsByCategoryId(Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }

    public List<OrderMaster> getAllOrderByTableId(Long tableId) {
        return orderMasterRepository.findByTableNo(tableId);
    }

    public List<BillDetails> getBillDetails(Long tableId) {
        return billDetailsRepository.findByTableNo(tableId);
    }

    public boolean checkLogin(Login login) {
        return login.equals(loginRepository.findById(login.getId()));
    }

}
