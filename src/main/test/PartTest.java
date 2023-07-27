import com.iwb.DAO.impl.UserDAOImpl;
import com.iwb.pojo.User;
import org.junit.Test;

public class PartTest {
    @Test
public void run1()
    {

            UserDAOImpl us =new UserDAOImpl();
            System.out.println(us.verifyUsername("sqc"));
    }


}
