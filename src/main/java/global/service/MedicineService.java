package global.service;

import global.entity.Medicine;

import java.util.List;

public interface MedicineService {

    Medicine saveMedicine(Medicine medicine);
    List<Medicine> getAll();
    Medicine getMedicineById(Long medicineId);
    Medicine updateMedicine(Long medicineId,Medicine medicine);
    String deleteMedicine(Long medicineId);
    String assignMedToPhar(List<Long> pharmaciesId, List<Long>medicinesId);

}
