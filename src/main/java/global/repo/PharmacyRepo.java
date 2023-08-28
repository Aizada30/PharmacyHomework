package global.repo;

import global.entity.Medicine;
import global.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {
    @Query("select p.medicineList from Pharmacy p where p.id=:pharmacyId")
    List<Medicine> getAllMedByPhar(Long pharmacyId);

    @Query("SELECT p FROM Pharmacy p WHERE p.name=:pharmacyName")
    Pharmacy getByName(String pharmacyName);

}
