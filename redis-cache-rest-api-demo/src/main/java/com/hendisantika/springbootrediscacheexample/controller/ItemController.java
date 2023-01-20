package com.hendisantika.springbootrediscacheexample.controller;

import com.hendisantika.springbootrediscacheexample.entity.Item;
import com.hendisantika.springbootrediscacheexample.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.items();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Integer id) {
        return itemService.getItem(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item request) {
        return itemService.createItem(request);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item request) {
        return itemService.updateItem(id, request);
    }
}
