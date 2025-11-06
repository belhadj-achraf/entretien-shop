package com.service.order.order.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private String userId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Long productId;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer totalPrice;

}