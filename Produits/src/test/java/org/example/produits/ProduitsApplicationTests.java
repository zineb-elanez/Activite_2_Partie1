package org.example.produits;

import org.example.produits.entities.Product;
import org.example.produits.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProduitsApplicationTests implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(ProduitsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Computer",4300,3));
        productRepository.save(new Product(null,"Printer",1200,4));
        productRepository.save(new Product(null,"Smart phone",3200,32));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> System.out.println(p.toString()));
        Product product =productRepository.findById(Long.valueOf(2)).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());


        List<Product> products2 = productRepository.findByNameContains("C");
        products2.forEach(p -> System.out.println(p.toString()));


        List<Product> products3 = productRepository.search("%C%");
        products3.forEach(p -> System.out.println(p.toString()));

        List<Product> products4 = productRepository.findByPriceGreaterThan(3000);
        products4.forEach(p -> System.out.println(p.toString()));

        List<Product> products5 = productRepository.searchByPrice(1200);
        products5.forEach(p -> System.out.println(p.toString()));


    }
}