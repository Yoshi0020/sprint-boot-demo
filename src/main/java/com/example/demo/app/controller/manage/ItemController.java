package com.example.demo.app.controller.manage;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.app.form.ItemForm;
import com.example.demo.app.helper.ItemHelper;
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
@RequestMapping("/manage/item")
public class ItemController {
	
	private ItemService service;
	private ItemHelper helper;

	@Autowired
	public ItemController(final ItemService service, final ItemHelper helper)
	{
		this.service = service;
		this.helper = helper;
	}

	@GetMapping
	public String index() {

		return "forward:/manage/item/list";
	}

	@GetMapping("list")
	public String showList(Model model){
		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "manage/item/list";
	}

	@GetMapping("regist")
	public String showRegist(Model model) {
		model.addAttribute("itemForm", new ItemForm());
		return "manage/item/regist";
	}

	@PostMapping("regist")
	public String regist(@ModelAttribute("itemForm") @Valid ItemForm itemForm, BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			
			model.addAttribute("itemForm", itemForm);
			return "manage/item/regist";
		}

		service.save(helper.convertFormToItem(itemForm));

		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "manage/item/list";
	}

	@GetMapping("edit/{id}")
	public String showEdit(@PathVariable Integer id, Model model) {

		final Item item = service.findOne(id);

		final ItemForm form = new ItemForm();

		helper.setItemFormFromItem(form, item);
		model.addAttribute("itemForm", form);
		return "manage/item/edit";
	}

	@PostMapping(path = "edit/{id}", params = "update")
	public String update(@ModelAttribute("itemForm") @Valid ItemForm itemForm,  BindingResult result, Model model) {
		if (result.hasErrors() == true) {
			
			model.addAttribute("itemForm", itemForm);
			return "manage/item/edit";
		}
		if (itemForm.getId() == null || itemForm.getId() == 0){
			throw new IllegalAccessError();
		}

		service.update(this.helper.convertFormToItem(itemForm));

		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "manage/item/list";
	}

	@PostMapping(path = "edit/{id}", params = "delete")
	public String delete(@ModelAttribute("itemForm") ItemForm itemForm, Model model) {
		if (itemForm.getId() == null || itemForm.getId() == 0){
			throw new IllegalAccessError();
		}

		service.delete(itemForm.getId());

		List<Item> itemList = service.findAll();

		model.addAttribute("items", itemList);
		return "manage/item/list";
	}	
}