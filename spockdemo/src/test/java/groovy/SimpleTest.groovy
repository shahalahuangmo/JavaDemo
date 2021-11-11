package groovy

import com.example.spockdemo.entity.Person
import com.example.spockdemo.entity.TestEntity
import org.mockito.Mockito
import spock.lang.Shared
import spock.lang.Specification

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-02 20:48
 */
class SimpleTest extends Specification {
    @Shared
    TestEntity testEntity


    def "mock test"() {
        given:
        testEntity = Mockito.mock(TestEntity.class)
        expect:
        testEntity.method1() == 0
        testEntity.name == null
        testEntity.number == 0
    }

    def "stub test"() {
        given:
        testEntity = Mockito.mock(TestEntity.class)
        //Stub往往和Mock一起行动。相当于在这里定义method1的行为
        //这行代码的意思是，命令testEntity的method1方法被调用时返回5。这种重新定义的行为叫做stub
        Mockito.when(testEntity.method1()).thenReturn(5)
        expect:
        testEntity.method1() == 5
        testEntity.method2() == null
    }

    def "spy test"() {
        given:
        testEntity = Mockito.spy(TestEntity.class)
        Mockito.when(testEntity.method1()).thenReturn(5)
        expect:
        testEntity.method1() == 5
        testEntity.method2() == "hello"
    }


    def "spock mock"() {
        given:
        TestEntity testEntity1 = Mock()  //或者 def classa = Mock(ClassA)
        TestEntity testEntity2 = Stub() // 或者 def classb = Stub(ClassB)
        TestEntity testEntity3 = Spy() //或者 def classc = Spy(ClassC)

        TestEntity testEntity4 = Mock() {
            method1() >> 5
        }
    }

    def "number of call mock test"() {
        given:
        TestEntity testEntity = Mock(TestEntity) {
            method1() >> 5
        }
        when:
        //TODO:执行一些操作，让testEntity的method1方法被调用两次
        testEntity.method1()
        testEntity.method1()
        then:
        //Spock语法，意思是判断classa中的method1方法是否被调用了两侧
        3 * testEntity.method1()
    }

    def "number of call stub test"() {
        given:
        TestEntity testEntity = Stub(TestEntity) {
            method1() >> 5
        }
        when:
        //TODO:执行一些操作，让testEntity的method1方法被调用两次
        testEntity.method1()
        testEntity.method1()
        then:
        //Spock语法，意思是判断classa中的method1方法是否被调用了两侧
        1 * testEntity.method1()
    }

    def "spy " (){
        given:
          def  moc = Mock(Person)
          def spy = Spy(Person)

        when:
         def mes = spy.get()

        then:
          mes == "name"
          // spy.get()
    }

}