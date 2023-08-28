package global.repo;

import global.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository <Medicine,Long> {
}
