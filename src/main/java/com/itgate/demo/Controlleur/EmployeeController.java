package com.itgate.demo.Controlleur;

import com.itgate.demo.dao.DepartmentRepository;
import com.itgate.demo.dao.EmployeeRepository;
import com.itgate.demo.dao.SpaceParkingRepository;
import com.itgate.demo.models.Department;
import com.itgate.demo.models.Employee;
import com.itgate.demo.models.SpaceParking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping(value = "/users/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository Iemp;
    @Autowired
    private DepartmentRepository Idep ;

    @Autowired
    private SpaceParkingRepository i_Sp ;


    @GetMapping("/all")
    public List<Employee> getall(){
        return Iemp.findAll();
    }
    @GetMapping("/getone/{Id}")
    public Employee getone(@PathVariable Long Id){
        return Iemp.findOne(Id);
    }

    @PostMapping("/save/{id_dep}")
    public Employee save(Employee E, @PathVariable Long id_dep) {

  Department d = Idep.findOne(id_dep) ;
   E.setDepartment(d);
        return Iemp.save(E);
    }


    @PutMapping("/update/{Id}")
    public Employee update(@RequestBody Employee E, @PathVariable Long Id){
        E.setId(Id);
        return Iemp.saveAndFlush(E);
    }
    @DeleteMapping("/delete/{Id}")
    public HashMap<String,String> deletespecialiste(@PathVariable Long Id) {
        HashMap message=new HashMap();
        try{
            Iemp.delete(Id);
            message.put("etat","employee deleted");
            return message;
        }
        catch (Exception e) {
            message.put("etat","employee  not deleted");
            return message;
        }
    }

}
