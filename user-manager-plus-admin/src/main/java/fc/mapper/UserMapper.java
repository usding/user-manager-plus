package fc.mapper;

import com.fc.model.User;
import com.fc.param.UserParam;

import java.util.List;

public interface UserMapper {

	List<User> getAll();

	List<User> getList(UserParam userParam);

	User findByUserName(String userName);

	User findById(Integer id);

	int getCount(UserParam userParam);

	User getOne(Long id);

	void insert(User user);

	int update(User user);

	int deleteById(Integer id);

}