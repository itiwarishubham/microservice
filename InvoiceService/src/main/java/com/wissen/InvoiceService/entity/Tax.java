package com.wissen.InvoiceService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "taxes")
@Setter
@Getter
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taxName;
    private Double taxRate;

    @ManyToMany
    @JoinTable(
            name = "product_tax",
            joinColumns = @JoinColumn(name = "tax_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @ManyToMany
    @JoinTable(
            name = "country_tax",
            joinColumns = @JoinColumn(name = "tax_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries;
}
