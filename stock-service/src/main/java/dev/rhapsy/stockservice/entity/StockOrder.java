package dev.rhapsy.stockservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @Builder
@Entity
@Table(name = "stock_order")
public class StockOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String orderDetails;
}
