package global.service.impl;

import global.entity.Medicine;
import global.entity.Pharmacy;
import global.entity.Worker;
import global.repo.MedicineRepo;
import global.repo.PharmacyRepo;
import global.service.MedicineService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepo medicineRepo;
    private final PharmacyRepo pharmacyRepo;


    @Override
    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepo.save(medicine);
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }

    @Override
    public Medicine getMedicineById(Long medicineId) {
        return medicineRepo.findById(medicineId).orElseThrow(
                ()->new NoSuchElementException(
                        "Medicine with id: "+medicineId+" not found"
                )
        );
    }

    @Override
    public Medicine updateMedicine(Long medicineId, Medicine medicine) {
        Medicine medicineById = getMedicineById(medicineId);
        medicineById.setName(medicine.getName());
        medicineById.setPrice(medicine.getPrice());
        return medicineById;
    }

    @Override
    public String deleteMedicine(Long medicineId) {
        medicineRepo.deleteById(medicineId);
        return "Medicine with id: "+medicineId+" successfully deleted";
    }

    @Override
    public String assignMedToPhar(List<Long> pharmaciesId, List<Long> medicine) {
        List<Pharmacy> pharmacies = pharmacyRepo.findAllById(pharmaciesId);
        List<Medicine> medicines = medicineRepo.findAllById(medicine);
        for (int i = 0; i < pharmacies.size(); i++) {
            pharmacies.get(i).setMedicineList(medicines);
            medicines.get(i).setPharmacies(pharmacies);
        }
        return "Medicine successfully saved";
    }

}
