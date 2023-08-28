package global.api;


import global.entity.Medicine;
import global.entity.Pharmacy;
import global.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/medicine")
@RequiredArgsConstructor
public class MedicineApi {

    private final MedicineService medicineService;

    @PostMapping("/assignMed")
    public String assign(@RequestBody List<Long> medicine,
                         @RequestParam List<Long> pharmaciesId){
       return medicineService.assignMedToPhar(pharmaciesId,medicine);
    }

    @GetMapping
    public List<Medicine> getAll() {
        return medicineService.getAll();
    }


    @PostMapping
    public Medicine saveMedicine(@Validated @RequestBody Medicine medicine) {
        return medicineService.saveMedicine(medicine);
    }


    @GetMapping("/getById")
    public Medicine getByIdMedicine(@Validated @RequestParam Long medicineId) {
        return medicineService.getMedicineById(medicineId);
    }

    @GetMapping("/delete")
    public String deleteMedicine(@Validated @RequestParam Long medicineId) {
        return medicineService.deleteMedicine(medicineId);
    }


    @GetMapping("/update")
    public Medicine updateMedicine(@Validated
                                   @RequestParam Long medicineId,
                                   @RequestBody Medicine medicine) {
        return medicineService.updateMedicine(medicineId, medicine);
    }
}
