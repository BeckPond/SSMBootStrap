package com.SSM.crud.service;

import com.SSM.crud.bean.Department;
import com.SSM.crud.bean.Msg;
import com.SSM.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts(){

        List<Department> list=departmentMapper.selectByExample(null);
        return list;
    }
}
