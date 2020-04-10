package fc.mapper;

import com.fc.model.Users;
import com.fc.model.UsersExample;
import org.springframework.stereotype.Repository;

/**
 * UsersDAO继承基类
 *
 * @author 18220
 * @date  2020-04-04
 */
@Repository
public interface UsersDAO extends MyBatisBaseDao<Users, Integer, UsersExample> {
}