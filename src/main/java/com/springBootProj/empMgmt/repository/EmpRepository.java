package com.springBootProj.empMgmt.repository;

import com.springBootProj.empMgmt.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
}
