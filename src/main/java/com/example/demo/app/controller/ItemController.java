package com.example.demo.app.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.app.form.ItemForm;
import com.example.demo.domain.entity.Item;
import com.example.demo.domain.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("regist")
	public String showRegist(Model model) {
		model.addAttribute("form", new ItemForm());
		return "item/regist";
	}

	@PostMapping("regist")
	public String regist(@ModelAttribute("form") @Valid ItemForm itemForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			
			model.addAttribute("form", itemForm);
			return "item/regist";
		}

		service.save(itemForm.createItem());

		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "item/list";
	}

	@GetMapping("edit/{id}")
	public String showEdit(@PathVariable int id, Model model) {

		Item item = service.findOne(id);
		model.addAttribute("item", item);
		return "item/edit";
	}

	@PostMapping("edit/{id}")
	public String update(@ModelAttribute("item") Item item, Model model) {
		service.update(item);

		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "item/list";
	}
}