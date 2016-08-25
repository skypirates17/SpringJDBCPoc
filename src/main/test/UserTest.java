import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.poc.dao.UserDao;
import com.poc.dto.DataTransferObject;
import com.poc.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springconfig/dispatcher-servlet.xml")
public class UserTest {

	@Autowired
	private UserDao userService;
	
	@After
	public void destroy() {
		userService = null;
	}
	
	@Test
	public void testSingleCRUD() {
		//test insert single record
		DataTransferObject dto = new DataTransferObject();
		User user = new User();
		user.setId(33);
		dto.setUser(user);
		
		DataTransferObject dtoresponse = userService.find(dto);
		
		System.out.println(dtoresponse.getUser().getAddress()+dtoresponse.getUser().getAge()+dtoresponse.getUser().getName());
	}
	
}