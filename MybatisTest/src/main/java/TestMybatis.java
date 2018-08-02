import com.example.entity.Person;
import com.example.mapper.PersonMapper;
import com.example.param.CustomPerson;
import com.example.vo.PersonVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author bestrow
 * @date 2018/8/1 20:50
 */
public class TestMybatis {

    public SqlSessionFactory getfactory() throws IOException {
        String filepath = "SqlMappingConfig.xml";
        InputStream in = Resources.getResourceAsStream(filepath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        return sqlSessionFactory;
    }

    @Test
    public void testinsert() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getfactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setName("zhangsan132121");
        person.setAddress("上海");
        person.setAge(16);
        person.setBirthday("05-04");
        personMapper.insertperson(person);
        System.out.println("id: " + person.getId());
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testquerypersonbyid() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getfactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.querypersonbyid(2);
        System.out.println(person.toString());
    }

    @Test
    public void testquerypersonbyname() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getfactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> personList = personMapper.querypersonbyname("zhang");
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

    @Test
    public void testdeletepersonbyid() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getfactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        personMapper.deletepersonbyid(3);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testupdatepersonbyid() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getfactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = new Person();
        person.setId(4);
        person.setName("zhangsan修改");
        person.setAge(35);
        person.setAddress("北京");
        person.setBirthday("09-08");
        personMapper.updatepersonbyid(person);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testquerypersonbyvo() throws IOException {
        SqlSessionFactory sqlSessionFactory = this.getfactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        PersonVo personVo= new PersonVo();
        CustomPerson customPerson = new CustomPerson();
        customPerson.setName("修改");
        customPerson.setBirthday("09-08");
        personVo.setCustomPerson(customPerson);
        List<Person> personList = personMapper.querypersonbyvo(personVo);
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }
}
