package groovy

import com.example.spockdemo.entity.Person
import spock.lang.Specification

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-02 20:48
 */
class WithAndVerifyALLTest extends Specification {

    //with()取对象属性的值
    def "test person use with(p)"() {
        given: "init a person"
        Person p = new Person(name: "yawn", age: 18, birthday: "1995-05-25")
        expect: "测试p"
        with(p) {
            name == "yawn"
            age < 20
            birthday == "1995-05-25"
        }
    }

    //verifyAll()取对象属性的值
    def "test method caller use with(p)"() {
        given: "init a person"
        Person p = new Person(name: "yawn", age: 18, birthday: "1995-05-25")
        expect: "测试p"
        verifyAll(p) {
            name == "yawn"
            age < 20
            birthday == "1995-05-25"
        }
    }

    //verifyAll 校验多个表达式结果
    def "没有参数的 verifyAll"() {
        when:
        def z1 = Math.pow(1, 2)
        def z2 = Math.pow(2, 2)
        def z3 = Math.pow(2, 3)

        then:
        verifyAll {
            z1 == 1
            z2 == 4
            z3 == 8
        }
    }

}