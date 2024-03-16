package com.example.testall.repository;

import com.example.testall.model.HoiCacEmNyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacEmNycRepository extends JpaRepository<HoiCacEmNyc, Long> {

}
