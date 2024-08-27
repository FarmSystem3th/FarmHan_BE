package is.farmhan.repository;

import is.farmhan.domain.DisabledType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisabledTypeRepository  extends JpaRepository <DisabledType,Long> {

    List<DisabledType> findAllByUserId(Long userId);
}
