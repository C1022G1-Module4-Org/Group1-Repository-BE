package com.example.ncc1.model.supplier;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "supplierType")
    private Set<Supplier> suppliers;

    public Supplier() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier(Integer id, String name, Set<Supplier> suppliers) {
        this.id = id;
        this.name = name;
        this.suppliers = suppliers;
    }

}
