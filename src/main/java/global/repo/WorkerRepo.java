package global.repo;

import global.entity.Pharmacy;
import global.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface WorkerRepo extends JpaRepository<Worker, Long> {

    @Query("SELECT w FROM Worker w")
    List<Worker> getAll();

    @Query("SELECT w FROM Worker w WHERE w.pharmacy.id=:pharmacyId")
    List<Worker> getWorkersByPharmacyId(Long pharmacyId);

    @Query("SELECT AVG(YEAR (CURRENT_DATE)-YEAR (w.dateOfBirth)) FROM Worker w  WHERE w.pharmacy.id=:pharmacyId")
    double getSrStatic(Long pharmacyId);

    @Query("SELECT w.pharmacy FROM Worker w WHERE w.id=:workerId")
    Pharmacy getPhBYWorId(Long workerId);
}
