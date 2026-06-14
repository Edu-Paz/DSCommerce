package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Category;
import com.devsuperior.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters")
    @NotBlank(message = "Required field")
    private String name;
    @Size(min = 10, message = "Description must be more than 10 characters")
    @NotBlank(message = "Required field")
    private String description;
    @NotNull(message = "Required field")
    @Positive(message = "Price must be positive")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Must have at least 1 category")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Double price, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        for (Category cat : entity.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
