package com.delivery.catalogservice.controller;

import com.delivery.catalogservice.domain.MenuItem;
import com.delivery.catalogservice.repo.MenuItemRepository;
import com.delivery.catalogservice.service.MenuItemService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {

    private MenuItemService menuItemService;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping("/additems")
    @CrossOrigin(origins = "http://localhost:4200")
    public MenuItem upload(@RequestBody MenuItem menuItemList) {
        MenuItem itemObj=null;
        itemObj=menuItemService.saveMenu(menuItemList);
        return itemObj;
    }

    @GetMapping("/listitems")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<MenuItem> getAllItems() {
        return menuItemRepository.findAll();
    }
}
