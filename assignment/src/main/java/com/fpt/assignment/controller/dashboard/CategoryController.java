package com.fpt.assignment.controller.dashboard;

import com.fpt.assignment.model.Category;
import com.fpt.assignment.serviceImpl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    CategoryService dao;
 
    @RequestMapping("category/save")
    public String save(@ModelAttribute("itemCa") Category category) {
        if (!dao.findAll().contains(category)) {
            dao.save(category);
        }
        else {
            return "error/505";
        }
        return "redirect:/dashboard/category";
    }
    

    @RequestMapping("category/delete")
    public String delete(Category category) {
        dao.delete(category.getId());
        return "redirect:/dashboard/category";
    }


    @RequestMapping("category/edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("itemCa", dao.findById(id));
        return "dashboard/category";
    }

    @RequestMapping("category/reset")
    public String reset(RedirectAttributes model) {
        model.addAttribute("itemCa", new Category());
        return "redirect:/dashboard/category";
    }







    @ModelAttribute("categories_map")
    public Map<Integer, String> getCategoriesMap() 
    {
        List<Category> list = dao.findAll();
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (Category category : list) {
            map.put(category.getId(), category.getType());
        }
        return map;
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return dao.findAll();
    }
}
