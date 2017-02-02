package com.niit;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.CategoryInfo;
import com.niit.services.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/category")
	public String getCateg(Map<String, Object> map, @ModelAttribute("category") CategoryInfo category,
			BindingResult result) {
		map.put("category", category);
		map.put("categoryList", categoryService.getAllCategory());
		return "category";
	}

	@RequestMapping(value = "category", method = RequestMethod.POST)
	public String docatActions(@ModelAttribute("category") CategoryInfo category, BindingResult result,
			@RequestParam String action/* the name of the button */, Map<String, Object> map) {

		// Category category = new Category();
		switch (action.toLowerCase()) {
		case "add":
			categoryService.add(category);

			break;
		case "edit":
			categoryService.edit(category);
			break;
		case "delete":
			categoryService.delete(category.getC_id());
			System.out.println("delete in controller");
			break;
		}

		map.put("category", category);
		map.put("categoryList", categoryService.getAllCategory());
		return "category";// jsp page
	}

	@RequestMapping("/deleteCategory")
	public String deletecat(Map<String, Object> map, @RequestParam int id) {
		categoryService.delete(id);
		System.out.println("delete in controller");
		map.put("categoryList", categoryService.getAllCategory());
		return "categoryDetails";// jsp page

	}

}
