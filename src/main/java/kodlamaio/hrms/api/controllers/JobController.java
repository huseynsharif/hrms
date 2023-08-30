package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/getAll")
    public Result getAll(){

        return this.jobService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody Job job){

        return this.jobService.add(job);

    }


}
