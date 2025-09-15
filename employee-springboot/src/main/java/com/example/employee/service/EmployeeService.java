package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return repo.findById(id);
    }

    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    public Employee update(Long id, Employee updated) {
        return repo.findById(id).map(existing -> {
            existing.setEmployeeName(updated.getEmployeeName());
            existing.setDepartment(updated.getDepartment());
            existing.setAge(updated.getAge());
            existing.setMobileNumber(updated.getMobileNumber());
            return repo.save(existing);
        }).orElseGet(() -> {
            updated.setEmployeeId(id);
            return repo.save(updated);
        });
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Optional<Employee> partialUpdate(Long id, Employee partialEmployee) {
        return repo.findById(id).map(existing -> {
            if (partialEmployee.getEmployeeName() != null) {
                existing.setEmployeeName(partialEmployee.getEmployeeName());
            }
            if (partialEmployee.getDepartment() != null) {
                existing.setDepartment(partialEmployee.getDepartment());
            }
            if (partialEmployee.getAge() != null) {
                existing.setAge(partialEmployee.getAge());
            }
            if (partialEmployee.getMobileNumber() != null) {
                existing.setMobileNumber(partialEmployee.getMobileNumber());
            }
            return repo.save(existing);
        });
    }
}
