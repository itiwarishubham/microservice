package com.wissen.InvoiceService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String currency;
    private String currencyCode;
    private Double taxRate;

    @OneToMany(mappedBy = "country")
    private List<Product> products;

    @ManyToMany
    @JoinTable(
            name = "country_tax",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "tax_id")
    )
    private List<Tax> taxes;
}