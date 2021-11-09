package groovy

import com.example.spockdemo.entity.Person
import com.example.spockdemo.entity.TestEntity
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Title

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-03 8:24
 */
@Title("测试的标题")
@Narrative("""关于测试的大段文本描述""")
//Specification
class DemoTest extends Specification {

    //region Fields

    // Instance fields are a good place to store objects belonging to the specification’s fixture
    def obj = new TestEntity()

    //share an object between feature methods.
    @Shared
    TestEntity testEntity;

    //Static fields should only be used for constants. Otherwise shared fields are preferable,
    // because their semantics with respect to sharing are more well-defined.
    static final PI = 3.141592654

    //endregion fields

    //region Fixture Methods
    //Fixture methods are responsible for setting up and cleaning up the environment in which feature methods are run.
    def setupSpec() {}    // runs once -  before the first feature method
    def setup() {}        // runs before every feature method
    def cleanup() {}      // runs after every feature method
    def cleanupSpec() {}  // runs once -  after the last feature method

    //endregion Fixture Methods

    //region Feature Methods

    // Feature methods are the heart of a specification. They describe the features (properties, aspects)
    // that you expect to find in the system under specification.
    // By convention, feature methods are named with String literals.

    def "测试方法1"() {
        given: "给定一个前置条件"
        //TODO: code here
        def person

        and: "其他前置条件"
        //TODO: code here

        expect: "随处可用的断言"
        // An expect block is more limited than a then block in that it may only contain conditions and variable definitions.
        // It is useful in situations where it is more natural to describe stimulus and expected response in a single expression.
        //TODO: code here

        /* where: "产生的后置结果"
         //TODO: code here*/

        when: "当发生一个特定的事件"
        //TODO: code here

        and: "其他的触发条件"
        //TODO: code here

        then: "产生的后置结果"
        //TODO: code here

        and: "同时产生的其他结果"
        //TODO: code here

        cleanup: "清理运行后设置"
    }

    //endregion Feature Methods

    //region helper methods
    // Sometimes feature methods grow large and/or contain lots of duplicated code.
    // In such cases it can make sense to introduce one or more helper methods.

    def "person  matches preferred configuration1"() {
        when:
        def person = new Person(name: "yawn", age: 18, birthday: "1995-05-25")
        then:
        person.name == "yawn"
        person.age < 20
        person.birthday == "1995-05-25"
    }

    def "offered matches preferred configuration"() {
        when:
        def person = new Person(name: "yawn", age: 18, birthday: "1995-05-25")
        then:
        matchesPreferredConfiguration(person)
    }

    // helper methods
    def matchesPreferredConfiguration(person) {
        person.name == "yawn"
        person.age < 20
        person.birthday == "1995-05-25"
    }

    //endregion helper methods

}