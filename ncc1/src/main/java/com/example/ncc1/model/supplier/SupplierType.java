package com.example.ncc1.model.supplier;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SupplierType {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String date;
    private Integer idNcc;
    @ManyToOne
    @JoinColumn(name = "id_ncc", referencedColumnName = "idNcc")
    private SupplierType supplierType;

    public SupplierType() {

    }

    public SupplierType(String name, String date, Integer idNcc, SupplierType supplierType) {
        this.name = name;
        this.date = date;
        this.idNcc = idNcc;
        this.supplierType = supplierType;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getIdNcc() {
        return idNcc;
    }

    public void setIdNcc(Integer idNcc) {
        this.idNcc = idNcc;
    }

    public SupplierType getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(SupplierType supplierType) {
        this.supplierType = supplierType;
    }
}
