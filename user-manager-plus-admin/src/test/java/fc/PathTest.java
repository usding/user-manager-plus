package fc;

import org.springframework.util.ClassUtils;

/**
 * 项目路径测试
 *
 * @author: feng.chuang
 * @date: 2020-04-06 10:11
 **/
public class PathTest {
    public static void main(String[] args) {
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
    }
}
