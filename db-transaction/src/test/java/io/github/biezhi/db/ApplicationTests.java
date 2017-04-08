package io.github.biezhi.db;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TxApplication.class)
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void test() throws Exception {
        // 创建10条记录
        userRepository.save(new User("AAA"));
        userRepository.save(new User("BBB"));
        userRepository.save(new User("CCC"));
//        userRepository.save(new User("DDDDDDD"));
        userRepository.save(new User("EEE"));
    }

    @After
    public void after() {
        System.out.println("\n\n");
        List<User> users = userRepository.findAll();
        System.out.println(users);
        System.out.println("USER SIZE: " + users.size());
        System.out.println("\n\n");
    }

}