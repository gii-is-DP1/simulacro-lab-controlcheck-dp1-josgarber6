package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/product")
public class ProductController {

  private ProductService productService;
  public static final String LIST_ALL_PRODUCTS = "productsListing";
  public static final String CREATE_PRODUCT = "createOrUpdateProductForm";

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public String getAllProducts(ModelMap model) {
    List<Product> listAllProducts = productService.getAllProducts();
    model.put("products", listAllProducts);
    return LIST_ALL_PRODUCTS;
  }

  @GetMapping(value="/create")
  public String addProduct(ModelMap model) {
    model.put("product", new Product());
    return CREATE_PRODUCT;
  }

  @PostMapping(value="/create")
  public String postMethodName(@Valid Product product, BindingResult bindingResult, ModelMap model) {
      if (bindingResult.hasErrors()) {
        model.put("message", "Description is incorrect");
        return CREATE_PRODUCT;
      } else {
        Product newProduct = new Product();
        BeanUtils.copyProperties(product, newProduct, "id");
        Product createdProduct = productService.save(newProduct);
        model.put("message", "Product " + createdProduct.getId() + " succesfully created");
        return "redirect:/products";
      }
  }
  
  
    
}
