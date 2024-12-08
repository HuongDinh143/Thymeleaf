package ra.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.thymeleaf.model.dto.ProductDto;
import ra.thymeleaf.model.entity.Product;
import ra.thymeleaf.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/findAll")
    public String listProduct(Model model) {
        model.addAttribute("listProducts", productService.findAll());
        return "products/list";
    }
    @GetMapping("/initCreate")
    public String initCreate(Model model) {
        model.addAttribute("product", new ProductDto());
        return "products/add";
    }
    @PostMapping("/add")
    public String create(@ModelAttribute("product") ProductDto request) {
        boolean result = productService.add(request);
        if (result) {
            return "redirect:/productController/findAll";
        }else {
            return "error";
        }
    }
    @GetMapping("/initUpdate")
    public String initUpdate(Model model, Integer productId) {
        Product productUpdate = productService.findById(productId);
        model.addAttribute("productUpdate", productUpdate);
        return "products/edit";
    }
    @PostMapping("/edit")
    public String editProduct(Product product) {
        boolean result = productService.update(product);
        if (result) {
            return "redirect:/productController/findAll";
        }
        return "error";
    }
    @GetMapping("/delete")
    public String deleteProduct(Integer productId) {
        boolean result = productService.delete(productId);
        if (result) {
            return "redirect:/productController/findAll";
        }
        return "error";
    }
    @GetMapping("/findByName")
    public String findByName(@RequestParam String name, Model model) {
        List<Product> products = productService.findByName("%" + name + "%");
        model.addAttribute("listProducts", products);
        model.addAttribute("searchValue", name);
        return "products/list";
    }



}
