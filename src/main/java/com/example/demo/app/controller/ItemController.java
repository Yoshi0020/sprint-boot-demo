package com.example.demo.app.controller;

import java.util.List;

import com.example.demo.domain.entity.Item;
import com.example.demo.domain.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService service;

    @GetMapping
    public String index(Model model) {

		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "item/list";
	}
}