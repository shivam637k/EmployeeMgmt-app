package com.springBootProj.empMgmt.service;

import com.springBootProj.empMgmt.entity.Emp;
import com.springBootProj.empMgmt.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public void addEmp(Emp e) {
        empRepository.save(e);
    }

    public List<Emp> getAllEmployee() {
        return empRepository.findAll();
    }

    public Emp getEmpById(int id) {
        Optional<Emp> e = empRepository.findById(id);
        return e.orElse(null);
    }

    public void deleteEmp(int id) {
        empRepository.deleteById(id);
    }
}
