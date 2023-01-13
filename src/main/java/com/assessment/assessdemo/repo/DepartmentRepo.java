package com.assessment.assessdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.assessdemo.models.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    @Query(value = " SELECT * FROM department WHERE status IN (:statuses) ", nativeQuery = true)
    public List<Department> getActiveDepartment(@Param("statuses") List<Integer> statuses);

    @Query(value = " SELECT * FROM department WHERE code IN (:codes) ", nativeQuery = true)
    public List<Department> getDepartmentByCode(@Param("codes") List<String> codes);
}
