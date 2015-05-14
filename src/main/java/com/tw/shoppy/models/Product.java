package com.tw.shoppy.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.tw.shoppy.web.views.View;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseModel<Product>{

    public final static BaseModel.Repo<Product> REPO = new BaseModel.Repo<Product>(Product.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(View.ProductListing.class)
    private String name;
}
