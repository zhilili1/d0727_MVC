import com.iwb.DAO.CategoryDAO;
import com.iwb.DAO.impl.CategoryDAOImpl;
import com.iwb.DAO.impl.UserDAOImpl;
import com.iwb.pojo.Category;
import com.iwb.pojo.User;
import com.iwb.util.MD5Util;
import com.iwb.util.UUIDUtil;
import org.junit.Test;

public class PartTest {
    @Test
public void run1()
    {
//            UserDAOImpl us =new UserDAOImpl();
//            us.addUser(new User(UUIDUtil.uuid(),"zhili", MD5Util.getMD5("157")));

        CategoryDAO categoryDAO =new CategoryDAOImpl();
        categoryDAO.add(new Category(UUIDUtil.uuid(),"手机"));
        categoryDAO.add(new Category(UUIDUtil.uuid(),"电脑"));
        categoryDAO.add(new Category(UUIDUtil.uuid(),"衣服"));
        categoryDAO.add(new Category(UUIDUtil.uuid(),"零食"));
    }


}
