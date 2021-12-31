package com.bridgelabz.employeesystem.service;

import com.bridgelabz.employeesystem.entity.Employee;
import com.bridgelabz.employeesystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;

    public  void  addEmp(Employee e){

        repo.save(e);
    }
    public List<Employee> getAllEmp(){
       return repo.findAll();

    }
    public  Employee getById( int id){
        Optional<Employee> e= repo.findById(id);
        if (e.isPresent()){
            return  e.get();

        }
        return  null;
    }

}

