package cotrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Product;
import repositories.ProductRepository;
import service.ProductService;


@RestController
@RequestMapping("/api/prodcuts")
public class ProductController {


private final ProductRepository productRepository;

@Autowired
private ProductService productService;

ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
}

@GetMapping("")
public List<Product>list(){
return productService.findAll();
}


@GetMapping("/{id}")
public ResponseEntity<?> view(  @PathVariable Long id) {
    Optional<Product> prodOpt=productService.findById(id);
    if (prodOpt.isPresent()) {
        return ResponseEntity.ok(prodOpt.orElseThrow());
    }
    return ResponseEntity.notFound().build();
}



}



