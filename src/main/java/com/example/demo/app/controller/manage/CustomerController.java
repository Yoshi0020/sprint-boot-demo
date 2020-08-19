package com.example.demo.app.controller.manage;

import java.util.List;

import com.example.demo.app.form.CustomerForm;
import com.example.demo.app.helper.CustomerHelper;
import com.example.demo.domain.entity.Customer;
import com.example.demo.domain.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage/customer")
public class CustomerController {

    private CustomerService service;
    private CustomerHelper helper;

    @Autowired
    public CustomerController(final CustomerService service, final CustomerHelper helper) {
        this.service = service;
        this.helper = helper;
    }

    @GetMapping
    public String index() {
        return "forward:/manage/customer/list";
    }

    @GetMapping("list")
    public String showList(final Model model) {
        final List<Customer> customers = this.service.findAll();

        model.addAttribute("customers", customers);
        return "manage/customer/list";
    }

    @GetMapping("regist")
    public String showRegist(final Model model) {

        model.addAttribute("customerForm", new CustomerForm());
        return "manage/customer/regist";
    }

    @PostMapping("regist")
    public String regist(@ModelAttribute("customerForm") @Validated CustomerForm customerForm, BindingResult result,
            final Model model) {
        if (result.hasErrors() == true) {

            model.addAttribute("customerForm", customerForm);
            return "manage/customer/regist";
        }
        final boolean saveResult = this.service.Save(this.helper.convertFormToItem(customerForm));
        if (saveResult == false) {
            throw new IllegalStateException("登録処理に失敗しました。");
        }

        final List<Customer> customers = this.service.findAll();

        model.addAttribute("customers", customers);
        return "redirect:/manage/customer";
    }

    @GetMapping("edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        final Customer customer = this.service.fineOnd(id);

        final CustomerForm customerForm = new CustomerForm();
        this.helper.setItemFormFromItem(customerForm, customer);
        customerForm.setPurchaseHistories(this.service.findPurchaseHistories(id));

        model.addAttribute("customerForm", customerForm);
        return "manage/customer/edit";
    }

    @PostMapping(path = "edit/{id}", params = "update")
    public String update(@ModelAttribute @Validated CustomerForm customerForm, BindingResult result, Model model) {
        if (result.hasErrors() == true) {

            model.addAttribute("customerForm", customerForm);
            return "manage/customer/edit";
        }

        if (customerForm.getId() == null) {
            throw new IllegalStateException("顧客IDが取得できません。");
        }

        final Integer resultCount = this.service.Update(this.helper.convertFormToItem(customerForm));
        if (resultCount == 0) {
            throw new IllegalStateException("更新処理に失敗しました。");
        }

        model.addAttribute("customers", this.service.findAll());
        return "redirect:/manage/customer";
    }

    @PostMapping(path = "edit/{id}", params = "delete")
    public String delete(@ModelAttribute CustomerForm customerForm, Model model) {
        if (customerForm.getId() == null) {
            throw new IllegalStateException("顧客IDが取得できません。");
        }

        final Integer resultCount = this.service.Delete(customerForm.getId());
        if (resultCount == 0) {
            throw new IllegalStateException("削除処理に失敗しました。");
        }

        model.addAttribute("customers", this.service.findAll());
        return "redirect:/manage/customer";
    }
}