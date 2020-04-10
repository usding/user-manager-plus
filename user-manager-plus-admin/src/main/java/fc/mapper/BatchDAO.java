package fc.mapper;

import com.fc.model.Batch;
import com.fc.model.BatchExample;
import org.springframework.stereotype.Repository;

/**
 * BatchDAO继承基类
 */
@Repository
public interface BatchDAO extends MyBatisBaseDao<Batch, Integer, BatchExample> {
}