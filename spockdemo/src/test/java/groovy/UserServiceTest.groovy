package groovy

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.example.spockdemo.entity.Order
import com.example.spockdemo.entity.UserInfo
import com.example.spockdemo.entity.UserInfoDTO
import com.example.spockdemo.exception.ApiException
import com.example.spockdemo.mapper.UserMapper
import com.example.spockdemo.service.impl.UserServiceImpl
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-05 21:57
 */
class UserServiceTest extends Specification {

    //类似于Mockito的@Mock
    @Collaborator
    UserMapper userMapper = Spy()

    //类似于Mockito的@InjectMocks
    @Subject
    UserServiceImpl userService


    def "queryById"() {
        given: "设置请求参数"
        UserInfo userInfo = new UserInfo(id: 1, age: 11, city: "北京市", userName: "test01")
        userMapper.getById(_) >> userInfo


        when: "设置事件"
        def entity = userService.getUserById(1)

        and:
        def dt = userService.getUserById(1)

        then: "验证结果"
        with(entity) {
            city == "北京市"
            userName == "test01"
            postCode == "100000"
        }
    }

    @IgnoreRest
    def "setOrderAmountByExchange"() {
        given:
        UserInfoDTO userInfoDTO = new UserInfoDTO(id: 1, age: 11, city: "北京市", userName: "test01", userOrders: [])
        Order order1 = new Order(id: 1, orderNo: "20211107001", amount: 100, country: "美元")
        Order order2 = new Order(id: 2, orderNo: "20211107002", amount: 100, country: "英镑")
        // << is a Groovy shorthand for List.add()
        userInfoDTO.userOrders << order1
        userInfoDTO.userOrders << order2

        when:
        userService.setOrderAmountByExchange(userInfoDTO)

        then:
        2 * userMapper.getExchangeByCountry(_) >> 0.15628 >> 0.11579
        // 2 * userMapper.getExchangeByCountry(_) 表示在for循环中一共调用了2次获取汇率的接口，验证调用了2次
        // userMapper.getExchangeByCountry(_) >> 0.15628 >> 0.11579 表示第一次调用返回0.1413，第二次调用返回0.1421

        and: "验证根据计算后的金额结果是否正确"

        with(userInfoDTO) {
            userOrders[0].exchangeAmount == 15.628
            userOrders[1].exchangeAmount == 11.579
        }
    }


    @Unroll
    def "验证用户信息的合法性: #expectedMessage #expectedErrCode "() {

        when: "调用校验用户方法"
        userService.validateUser(user)

        then: "捕获异常并设置需要验证的异常值"
        def exception = thrown(expectedException)
        exception.errorCode == expectedErrCode
        exception.errorMessage == expectedMessage

        where: "表格方式验证用户信息的合法性"
        user           || expectedException | expectedErrCode | expectedMessage
        getUser(10001) || ApiException      | "10001"         | "user is null"
        getUser(10002) || ApiException      | "10002"         | "user name is null"
        getUser(10003) || ApiException      | "10003"         | "user age is null"
        getUser(10004) || ApiException      | "10004"         | "user city is null"
        getUser(10005) || ApiException      | "10005"         | "user email is null"
        getUser(10006) || ApiException      | "10006"         | "user order is null"
        getUser(10007) || ApiException      | "10007"         | "order number is null"
        getUser(10008) || ApiException      | "10008"         | "order amount is null"
    }

    def getUser(errCode) {
        def user = new UserInfoDTO()
        def condition1 = {
            user.userName = "杜兰特"
        }
        def condition2 = {
            user.age = 20
        }
        def condition3 = {
            user.city = "15801833812"
        }
        def condition4 = {
            user.email = "男"
        }
        def condition5 = {
            user.userOrders = [new Order()]
        }
        def condition6 = {
            user.userOrders = [new Order(orderNo: "123456")]
        }

        switch (errCode) {
            case 10001:
                user = null
                break
            case 10002:
                user = new UserInfoDTO()
                break
            case 10003:
                condition1()
                break
            case 10004:
                condition1()
                condition2()
                break
            case 10005:
                condition1()
                condition2()
                condition3()
                break
            case 10006:
                condition1()
                condition2()
                condition3()
                condition4()
                break
            case 10007:
                condition1()
                condition2()
                condition3()
                condition4()
                condition5()
                break
            case 10008:
                condition1()
                condition2()
                condition3()
                condition4()
                condition5()
                condition6()
                break
        }
        return user
    }
}