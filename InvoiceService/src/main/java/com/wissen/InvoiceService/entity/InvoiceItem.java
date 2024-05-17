package com.wissen.InvoiceService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "invoice_items")
@Getter
@Setter
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double quantity;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
