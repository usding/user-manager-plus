package fc.utils;

import com.fc.model.UsersExample;

/**
 * db utils
 *
 * @author: feng.chuang
 * @date: 2020-03-31 20:35
 **/
public class DbUtils {

    public static UsersExample getUsersExample () {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        return usersExample;
    }


}
