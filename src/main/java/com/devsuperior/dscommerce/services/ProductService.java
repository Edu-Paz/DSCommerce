package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    // Search a product by id
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
//        Optional<Product> result = repository.findById(id);
//        Product product = result.get();
//        ProductDTO dto = new ProductDTO(product);
//        return dto;

        // Option more optimized
        // Ask to repository to search the id in database
        Product product = repository.findById(id).get();
        // Return a DTO to controller
        return new ProductDTO(product);
    }

    // Return all products
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        // Return a DTO to controller
        return result.map(x -> new ProductDTO(x));
    }

    // Save DTO's data in database
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

}
