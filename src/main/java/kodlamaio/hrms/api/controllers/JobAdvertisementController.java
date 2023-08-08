package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getallactive")
    public DataResult<List<JobAdvertisement>> getAllActive(){
        return this.jobAdvertisementService.getAllActive();
    }

    @GetMapping("/getallactivewithemployerid")
    public DataResult<List<JobAdvertisement>> getAllActiveWithEmployerId(@RequestParam int employerId){
        return this.jobAdvertisementService.getAllActiveWithEmployerId(employerId);
    }


    @PostMapping("/add")
    public DataResult<JobAdvertisement> add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }


    @PostMapping("/deActive")
    public Result deActive(@RequestParam int jobAdvertisementId){
        return this.jobAdvertisementService.deActive(jobAdvertisementId);
    }

    @PostMapping("/getAllActiveOrderByDateASC")
    public DataResult<List<JobAdvertisement>> getAllActiveOrderByDateASC() {
        return this.jobAdvertisementService.getAllActiveOrderByDateASC();
    }

}
