package com.example.Ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Ecommerce.model.Customer;
import com.example.Ecommerce.service.CustomerService;

@Controller
public class AppController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("customerList", customerService.getAllCustomers());
		return "home";
	}

	@GetMapping("/add-customer")
	public String showAddCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "addcustomer";
	}

	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showEditCustomerForm(@PathVariable("id") Long id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "editcustomer";
	}

	@PostMapping("/update-customer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/";
	}

}
