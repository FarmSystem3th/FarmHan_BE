package is.farmhan.repository;

import is.farmhan.domain.Call;
import is.farmhan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<Call, Long> {

    List<Call> findByUserId(Long userId);

}
