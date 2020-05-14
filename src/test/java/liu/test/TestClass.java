package liu.test;

import liu.domain.User;
import liu.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestClass {
    public static void main(String[] args) {
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //解析配置文件的所有信息，保存在Configuration中，并返回DefaultSqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //SqlSession中包含了一个执行器对象
        SqlSession  sqlSession = sqlSessionFactory.openSession();
        //使用动态代理，使用MapperProxyFactory来创建
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.get();
//        User user = sqlSession.selectOne("liu.mappers.UserMapper.get");
        System.out.println(user);
    }
}
