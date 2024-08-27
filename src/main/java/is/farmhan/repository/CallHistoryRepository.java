package is.farmhan.repository;

import is.farmhan.domain.CallHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallHistoryRepository extends JpaRepository<CallHistory,Long> {
    List<CallHistory> findByCallId(Long callId);

}
