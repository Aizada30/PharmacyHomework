package global.service.impl;

import global.entity.Pharmacy;
import global.entity.Worker;
import global.repo.PharmacyRepo;
import global.repo.WorkerRepo;
import global.service.WorkerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final PharmacyServiceImpl pharmacyService;
    private final WorkerRepo workerRepo;
    private final PharmacyRepo pharmacyRepo;


    @Override
    public Worker saveWorker(Worker worker) {
        return workerRepo.save(worker);

    }

    @Override
    public List<Worker> getAll() {
        return workerRepo.getAll();
    }

    @Override
    public Worker getWorkerById(Long workerId) {
        return workerRepo.findById(workerId).orElseThrow(
                () -> new NoSuchElementException(
                        "Worker with id: " + workerId + " not found"
                ));
    }

    @Override
    public Worker updateWorker(Long workerId, Worker worker) {
        Worker workerById = getWorkerById(workerId);
        workerById.setFullName(worker.getFullName());
        workerById.setEmail(worker.getEmail());
        workerById.setAddress(worker.getAddress());
        workerById.setSalary(worker.getSalary());
        workerById.setDateOfBirth(worker.getDateOfBirth());
        return workerById;
    }

    @Override
    public String deleteWorker(Long workerId) {
        workerRepo.deleteById(workerId);
        return "Worker with id: " + workerId + " successfully deleted";
    }




    @Override
    public List<Worker> sortWorkers(Long pharmacyId, String word) {
        if(word.equalsIgnoreCase("desc")){
            List<Worker> workers = workerRepo.getWorkersByPharmacyId(pharmacyId);
            workers.sort(Comparator.comparingInt(Worker::getSalary));
            return workers;
        } else if (word.equalsIgnoreCase("asc")) {
            List<Worker> workers = workerRepo.getWorkersByPharmacyId(pharmacyId);
            workers.sort(Comparator.comparingInt(Worker::getSalary).reversed());
        return workers; }
        return null;
    }

    @Override
    public String assignWorkerToPharmacy(Long pharmacyId, Long worker) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(() -> new NoSuchElementException("not found pharmacy"));
        Worker worker1 = workerRepo.findById(worker).orElseThrow(() -> new NoSuchElementException("not found worker"));
        worker1.setPharmacy(pharmacy);
        pharmacy.getWorkers().add(worker1);
        workerRepo.save(worker1);
        return "Successfully assigned";
    }

    @Override
    public double srStaticAge(Long pharmacyId) {
        return workerRepo.getSrStatic(pharmacyId);
    }

    @Override
    public Pharmacy getPharByWorkerId(Long workerId){
      return   workerRepo.getPhBYWorId(workerId);
    }


}
