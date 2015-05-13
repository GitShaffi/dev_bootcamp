package com.tw.shoppy.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.tw.shoppy.web.views.View;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseModel<Product>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonView(View.Product.class)
    private String name;
}
