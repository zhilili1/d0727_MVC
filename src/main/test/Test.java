import com.iwb.DAO.impl.UserDAOImpl;
import com.iwb.pojo.User;

public class Test {
    public static void main(String[] args) {
        User u =new User("1","sqc","123");
        UserDAOImpl us =new UserDAOImpl();
        System.out.println(us.verifyUsername("sqc"));

    }
}
