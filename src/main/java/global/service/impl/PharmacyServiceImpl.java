package global.service.impl;

import global.entity.Medicine;
import global.entity.Pharmacy;
import global.repo.MedicineRepo;
import global.repo.PharmacyRepo;
import global.service.PharmacyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepo pharmacyRepo;
    private final MedicineRepo medicineRepo;

    @Override
    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        return pharmacyRepo.save(pharmacy);
    }

    @Override
    public List<Pharmacy> getAll() {
        return pharmacyRepo.findAll();
    }

    @Override
    public Pharmacy getPharmacyById(Long pharmacyId) {
        return pharmacyRepo.findById(pharmacyId).orElseThrow(
                () -> new NoSuchElementException(
                        "Pharmacy with id: " + pharmacyId + " not found"
                )
        );
    }

    @Override
    public Pharmacy updatePharmacy(Long pharmacyId, Pharmacy pharmacy) {
        Pharmacy pharmacyById = getPharmacyById(pharmacyId);
        pharmacyById.setName(pharmacy.getName());
        pharmacyById.setAddress(pharmacy.getAddress());
        return pharmacyById;
    }

    @Override
    public String deletePharmacy(Long pharmacyId) {
        pharmacyRepo.deleteById(pharmacyId);
        return "Pharmacy with id: " + pharmacyId + " successfully deleted";
    }

    @Override
    public String assignMedicineToPharmacy(List<Long> pharmacyId, List<Medicine> allMedicine) {
        List<Pharmacy> allPharmacy = pharmacyRepo.findAllById(pharmacyId);
        pharmacyRepo.saveAllAndFlush(allPharmacy);
        medicineRepo.saveAll(allMedicine);
        return "Successfully saved";
    }

    @Override
    public Pharmacy getByName(String pharmacyName) {
        return pharmacyRepo.getByName(pharmacyName);
    }


}
