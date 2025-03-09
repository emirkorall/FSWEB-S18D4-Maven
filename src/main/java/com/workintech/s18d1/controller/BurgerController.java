package com.workintech.s18d1.controller;


import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping

    public List<Burger> findAllBurgers() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @PutMapping()
    public Burger updateBurger(@RequestBody Burger burger) {
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger removeBurger(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType) {
        return burgerDao.findByBreadType(BreadType.valueOf(breadType));
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }


}
