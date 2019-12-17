package kr.ac.knou;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;
@Configuration(value="file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MyBatisTest {
 
    @Inject
    private SqlSessionFactory sqlFactory;
    
    @Test
    public void testFactory() {
        System.out.println(sqlFactory);
    }
    @Test
    public void testSession() {
        try (SqlSession session = sqlFactory.openSession()){
            System.out.println(session);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
}
 


