package com.delivery.catalogservice.service;

import com.delivery.catalogservice.domain.MenuItem;
import com.delivery.catalogservice.repo.MenuItemRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItem saveMenu(MenuItem menuItemList) {
        return menuItemRepository.save(menuItemList);
    }

}
