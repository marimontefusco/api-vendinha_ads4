package com.api.api_vendinha.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sales")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @ManyToOne
//    private User user_id;
//
//    @OneToMany(mappedBy = "products")
//    private Product product_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private Float price;



}
