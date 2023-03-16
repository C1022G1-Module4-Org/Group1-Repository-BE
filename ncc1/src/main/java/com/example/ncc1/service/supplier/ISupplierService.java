package com.example.ncc1.service.supplier;

import com.example.ncc1.model.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {
    Page<Supplier> findAll(Pageable pageable);


    Optional<Supplier> deleteById(int id);

    void save(Supplier supplier);

    Optional<Supplier> findById(int id);

    List<Supplier> listSearchByName(String name);
}
