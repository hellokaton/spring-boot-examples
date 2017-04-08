import io.github.biezhi.jdbc.SpringJdbcApplication;
import io.github.biezhi.jdbc.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringJdbcApplication.class)
public class TestJdbcTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestJdbcTemplate.class);

    @Autowired
    private UserService userSerivce;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void before() {
        jdbcTemplate.execute("create TABLE `user`(id INT AUTO_INCREMENT, name VARCHAR)");
        userSerivce.create("jack");
        userSerivce.create("rose");
    }

    @Test
    public void testList() {
        LOGGER.info("users is {}", userSerivce.getUsers());
    }

    @Test
    public void testGetById() {
        LOGGER.info("user is {}", userSerivce.getById(1));
    }

    @Test
    public void testDelete() {
        userSerivce.delete(1);
        LOGGER.info("users is {}", userSerivce.getUsers());
    }

}
