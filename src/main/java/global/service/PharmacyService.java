package global.service;

import global.entity.Medicine;
import global.entity.Pharmacy;
import global.entity.Worker;

import java.util.List;

public interface PharmacyService {

    Pharmacy savePharmacy(Pharmacy pharmacy);
    List<Pharmacy> getAll();
    Pharmacy getPharmacyById(Long pharmacyId);
    Pharmacy updatePharmacy(Long pharmacyId,Pharmacy pharmacy);
    String deletePharmacy(Long pharmacyId);
    String assignMedicineToPharmacy(List<Long>pharmacyId,List<Medicine>allMedicine);

}
