package com.product.controller;

import com.product.model.Product;
import com.product.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping("")
    public ResponseEntity<Iterable<Product>> getAllProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> creatNewProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    //  @GetMapping("/{id}")
//    public ResponseEntity<Product> findOneById(@PathVariable Long id){
//      Optional<Product> product=productService.findById(id);
//      if (!product.isPresent()){
//          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }
//      return new ResponseEntity<>(product.get(),HttpStatus.OK);
//  }
  @GetMapping("/top4")
    public ResponseEntity<Product> getNewTop4(){
     Iterable<Product> product=productService.top4();
      if (product==null){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity(product,HttpStatus.OK);
  }
    @GetMapping("/search/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String  name) {
        Iterable<Product> products =  productService.findByName(name);
        if (products==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }
//    @GetMapping("/searchByCategory/{categoryName}")
//    public ResponseEntity<Product> findProductByCategoryName(@PathVariable String  categoryName) {
//        Iterable<Product> products =  productService.findProductByCategoryName(categoryName);
//        if (products==null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity(products, HttpStatus.OK);
//    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> editProductById(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity("edit fault", HttpStatus.NOT_FOUND);
        }
        product.setId(optionalProduct.get().getId());
        productService.save(product);
        return new ResponseEntity("edit success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity("delete success", HttpStatus.OK);
    }

}
