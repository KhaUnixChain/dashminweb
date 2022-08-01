package com.fpt.assignment.controller.dashboard;

import com.fpt.assignment.model.Category;
import com.fpt.assignment.model.Employee;
import com.fpt.assignment.model.Product;
import com.fpt.assignment.repository.CategoryDAO;
import com.fpt.assignment.serviceImpl.*;
import com.fpt.assignment.utils.SaveHelperUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    ProductService pDao;
    @Autowired
    CategoryDAO cDao;

    @RequestMapping("product/save")
    public String save(@ModelAttribute("itemPr") Product product) {
        product.setImage(product.getImage().replace(",", ""));
        pDao.save(product);
        return "redirect:/dashboard/product";
    }

    @RequestMapping("product/delete")
    public String delete(@RequestParam("id") String id) {
        pDao.delete(id);
        return "redirect:/dashboard/product";
    }

    @RequestMapping("product/edit")
    public String edit(Model model, @RequestParam("id") String id, @ModelAttribute("itemPr") Product product) {
        product = pDao.findById(id);
        model.addAttribute("product", product);
        return "dashboard/product";
    }

    @RequestMapping("product/reset")
    public String reset(@ModelAttribute("itemPr") Product product, @RequestParam("id") String id) {
        product = new Product();
        return "redirect:/dashboard/product";
    }

    /**
     * this is model what this is to show list product existence
     * @return
     */
    @ModelAttribute("products")
    public List<Product> getProducts() {
        return pDao.findAll();
    }

    @ModelAttribute("employee")
    public Employee account() {
        return SaveHelperUtils.employee;
    }

    @ModelAttribute("categories_map")
    public Map<Integer, String> getCategoriesMap() 
    {
        List<Category> list = cDao.findAll();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Category category : list) {
            map.put(category.getId(), category.getType());
        }
        return map;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return cDao.findAll();
    }
}
