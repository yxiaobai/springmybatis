import com.entity.Student;
import com.entity.StudentDAO;
import com.entity.mapper.StudentMapper;
import com.entity.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Demo {






    @Test
    public void xx(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        StudentMapper sm = ctx.getBean("studentMapper",StudentMapper.class);

        //sm.save("赵七","北京");
        //sm.add("dd","zz111");

        //Student st = new Student();
        //st.setUname("李四六");
        //st.setAddress("郑州文化路");
        //sm.insert(st);

        System.out.println(sm.queryAll().size());
        System.out.println(sm.shows().size());
        ctx.close();
    }


    @Test
    public void cc(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        for(String s : ctx.getBeanDefinitionNames()){
            System.out.println(s);
        }

        System.out.println("----------------------------------------------------");
        StudentMapper sm = ctx.getBean("studentMapper",StudentMapper.class);
        for(Student st : sm.queryAll()){
            System.out.println(st.getUname());
        }
        System.out.println("----------------------------------------------------");
        StudentDAO sdao = ctx.getBean("studentdao",StudentDAO.class);
        for(Student st : sdao.query()){
            System.out.println(st.getUname());
        }
        System.out.println("----------------------------------------------------");
        System.out.println(sm==sdao.getSm());

        UserMapper um = ctx.getBean("userMapper",UserMapper.class);
        for(Map<String,Object> ss : um.query()){
            System.out.println(ss.get("uname"));
        }
        ctx.close();
    }


    @Test
    public void aa(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        StudentMapper sm = ctx.getBean("sm",StudentMapper.class);
        List<Student> sts = sm.queryAll();
        System.out.println(sts.size());
        for(Student s : sts){
            System.out.println(s.getAddress());
        }
        ctx.close();
    }


    @Test
    public void tt() throws SQLException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        //SqlSessionFactory sf = ctx.getBean("sf",SqlSessionFactory.class);
        StudentDAO sd = ctx.getBean("studentdao",StudentDAO.class);

        Student myst = sd.queryById(2);
        System.out.println(myst.getUname());
        System.out.println(myst.getAddress());

        System.out.println("------------------------");

        List<Student> sts = sd.query();
        for(Student s : sts){
            System.out.println(s.getUname());
        }
        ctx.close();
    }
}
