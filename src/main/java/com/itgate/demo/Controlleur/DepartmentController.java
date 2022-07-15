package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.DepartmentRepository;
import com.itgate.demo.dao.EmployeeRepository;
import com.itgate.demo.models.Department;
import com.itgate.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping(value = "/users/Department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository idep;
    @Autowired
    private EmployeeRepository iemp;

    @GetMapping("/all")
    public List<Department> getall(){
        return idep.findAll();
    }

    @GetMapping("/getone/{Id}")
    public Department getone(@PathVariable Long Id){
        return idep.findOne(Id);
    }

    @PostMapping("/save")
    public Department save(@RequestBody Department D ) {

        return idep.save(D);
    }

    @PutMapping("/update/{Id}")
    public  Department  update(@RequestBody Department D, @PathVariable Long Id){
        D.setId(Id);
        return idep.saveAndFlush(D);
    }

    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> delete(@PathVariable Long Id) {
        HashMap message=new HashMap();
        try{
            idep.delete(Id);
            message.put("etat","department deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat"," department  not deleted");
            return message;
        }
    }
}
