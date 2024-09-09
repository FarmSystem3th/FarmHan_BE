package is.farmhan.repository;

import is.farmhan.domain.DisabledType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DisabledTypeRepository  extends JpaRepository <DisabledType,Long> {

    List<DisabledType> findAllByUserId(Long userId);
}
