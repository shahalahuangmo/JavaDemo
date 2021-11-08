package groovy;

import com.example.spockdemo.entity.UserInfo;
import com.example.spockdemo.entity.UserInfoDTO;
import com.example.spockdemo.mapper.UserMapper;
import com.example.spockdemo.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-05 21:57
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceJavaTest {
    //@Mock：创建一个Mock。
    //@InjectMocks：创建一个实例，其余用@Mock（或@Spy）注解创建的mock将被注入到用该实例中。
    //userService 被标记了 @InjectMocks，在 setUp方法中 执行 MockitoAnnotations.openMocks(this); 的时候，会将标记了 @Mock 或 @Spy 的属性注入到 service 中
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserMapper userMapper;

   /* @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }*/

    @Test
    public void getUserById() {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setAge(11);
        userInfo.setCity("北京市");
        userInfo.setUserName("test01");
        when(userMapper.getById(1)).thenReturn(userInfo);
        UserInfoDTO userInfoDTO = userService.getUserById(1);

        Assert.assertEquals("北京市", userInfoDTO.getCity());
        Assert.assertEquals("test01", userInfoDTO.getUserName());
        Assert.assertEquals("100000", userInfoDTO.getPostCode());
    }
}
