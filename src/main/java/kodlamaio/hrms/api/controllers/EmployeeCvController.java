package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeCvService;
import kodlamaio.hrms.entities.concretes.EmployeeCv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employeeCv")
public class EmployeeCvController {

    private EmployeeCvService employeeCvService;

    @Autowired
    public EmployeeCvController(EmployeeCvService employeeCvService) {
        this.employeeCvService = employeeCvService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EmployeeCv employeeCv){

        return ResponseEntity.ok(this.employeeCvService.add(employeeCv));

    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(this.employeeCvService.getall());

    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getbyid(@RequestParam(name = "id") int id){
        return ResponseEntity.ok(this.employeeCvService.findById(id));
    }


}
