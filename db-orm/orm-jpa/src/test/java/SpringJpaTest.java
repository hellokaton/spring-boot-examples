import io.github.biezhi.jpa.SpringJpaApplication;
import io.github.biezhi.jpa.User;
import io.github.biezhi.jpa.UserRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJpaApplication.class)
public class SpringJpaTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SpringJpaTest.class);

    @Autowired
    private UserRepository userRepository;

    @BeforeClass
    public static void beforeClass() {
        LoggingSystem.get(ClassLoader.getSystemClassLoader()).setLogLevel(Logger.ROOT_LOGGER_NAME, LogLevel.INFO);
    }

    @Before
    public void before() {
        userRepository.save(new User("jack"));
        userRepository.save(new User("rose"));
        userRepository.save(new User("tomcat"));
    }

    @Test
    public void testFindAll() {
        LOGGER.info("users is {}", userRepository.findAll());
    }

    @Test
    public void testFindOne() {
        LOGGER.info("user is {}", userRepository.findOne(1L));
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("jack222");
        userRepository.save(user);
        LOGGER.info("user is {}", userRepository.findOne(1L));
    }

    @Test
    public void testDelete() {
        userRepository.delete(1L);
        LOGGER.info("users is {}", userRepository.findAll());
    }

}