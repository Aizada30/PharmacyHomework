package global.api;

import global.entity.Medicine;
import global.entity.Pharmacy;
import global.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacy")
@RequiredArgsConstructor
public class PharmacyApi {

    private final PharmacyService pharmacyService;

    @GetMapping
    public List<Pharmacy> getAll() {
        return pharmacyService.getAll();
    }

    @PostMapping
    public Pharmacy savePharmacy(@Validated @RequestBody Pharmacy pharmacy) {
        return pharmacyService.savePharmacy(pharmacy);
    }

    @GetMapping("/byId")
    public Pharmacy getById(@RequestParam Long pharmacyId) {
        return pharmacyService.getPharmacyById(pharmacyId);
    }

    @GetMapping("/updatePh")
    public Pharmacy update(@RequestParam Long pharmacyId,
                           @RequestBody Pharmacy pharmacy) {
        return pharmacyService.updatePharmacy(pharmacyId, pharmacy);
    }


    @GetMapping("/deletePharmacy")
    public String deletePharmacy(@RequestParam Long pharmacyId) {
        return pharmacyService.deletePharmacy(pharmacyId);
    }

    @PostMapping("/assignMedtoPhar")
    public String assignMedToPhar(@RequestParam List<Long>pharmaciesId,
                                  @RequestBody List<Medicine>medicinesId){
        return pharmacyService.assignMedicineToPharmacy(pharmaciesId,medicinesId);
    }

    @GetMapping("/getByName")
    public Pharmacy getByName(@RequestParam String name){
       return pharmacyService.getByName(name);
    }

}
