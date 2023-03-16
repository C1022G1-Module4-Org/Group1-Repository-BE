package com.example.ncc1.repository;

import com.example.ncc1.model.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISupplierRepository  extends JpaRepository<Supplier,Integer> {
    @Query(value = "select * from ncc where name like concat('%',:name1,'%')",nativeQuery = true)
    List<Supplier> listSearchByName(@Param("name1") String name);
}
