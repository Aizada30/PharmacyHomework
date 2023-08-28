package global.api;

import global.entity.Pharmacy;
import global.entity.Worker;
import global.service.WorkerService;
import global.service.impl.PharmacyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@RequiredArgsConstructor
public class WorkerApi {
    private final WorkerService workerService;
    private final PharmacyServiceImpl pharmacyService;

    @PostMapping("/assign")
    public void assign(@RequestParam Long pharmacyId,
                       @RequestParam Long workerId) {
        workerService.assignWorkerToPharmacy(pharmacyId, workerId);
    }

    @GetMapping
    public List<Worker> getAllWorkers() {
        return workerService.getAll();
    }

    @PostMapping
    public Worker saveWorker(@Validated @RequestBody Worker worker) {
        return workerService.saveWorker(worker);
    }

    @GetMapping("/byId")
    public Worker getByIdWorker(@RequestParam Long workerId) {
        return workerService.getWorkerById(workerId);
    }

    @GetMapping("/update")
    public Worker updateWorker(@RequestParam Long workerId,
                               @RequestBody Worker worker) {
        return workerService.updateWorker(workerId, worker);
    }

    @GetMapping("/delete")
    public String deleteWorker(@RequestParam Long workerId) {
        return workerService.deleteWorker(workerId);
    }

    @GetMapping("/sort")
    public List<Worker> sortSalary(@Validated @RequestParam String word ,@RequestParam Long pharmacyId) {
        return workerService.sortWorkers(pharmacyId,word);
    }

    @GetMapping("/sr")
    public double sredne(@RequestParam Long pharmacyId){
        return workerService.srStaticAge(pharmacyId);
    }

    @GetMapping("/getPharByWor")
    public Pharmacy getPhar(@RequestParam Long workerId){
       return workerService.getPharByWorkerId(workerId);
    }

    @GetMapping("/getWorByPharId")
    public List<Worker>getWorByPharId(@RequestParam Long pharmacyId){
        return workerService.getWorByPharId(pharmacyId);
    }


}



