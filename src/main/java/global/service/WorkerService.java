package global.service;

import global.entity.Pharmacy;
import global.entity.Worker;

import java.util.List;

public interface WorkerService {

    Worker saveWorker(Worker worker);
    List<Worker> getAll();
    Worker getWorkerById(Long workerId);
    Worker updateWorker(Long workerId,Worker worker);
    String deleteWorker(Long workerId);
    List<Worker>sortWorkers(Long pharmacyId,String word);
    String assignWorkerToPharmacy(Long pharmacyId, Long worker);
    double srStaticAge(Long pharmacyId);
    Pharmacy getPharByWorkerId(Long workerId);
}
