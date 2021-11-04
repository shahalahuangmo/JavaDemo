package groovy

import com.example.spockdemo.util.AddressResolutionUtil
import spock.lang.Specification
import spock.lang.Unroll


/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa* @Date 2021-11-04 22:39
 */
class AddressResolutionUtilTest extends Specification {

    @Unroll
    def "查询字符串中城市"() {
        expect: "when + then 的组合"
        AddressResolutionUtil.addressResolution(address) == result

        where: "表格方式测试不同的分支逻辑"
        address            || result
        "湖北省武汉市"           || ["province": "湖北省", "city": "武汉市"]
        "天津市天津市"           || ["province": "天津市", "city": "天津市"]
        "北京市北京市"           || ["province": "北京市", "city": "北京市"]
        "湖南省湘西自治州"         || ["province": "湖南省", "city": "湘西自治州"]
        "贵州省黔南布依族苗族自治州都匀市" || ["province": "贵州省", "city": "黔南布依族苗族自治州"]
        "新疆维吾尔自治区乌鲁木齐市"    || ["province": "新疆维吾尔自治区", "city": "乌鲁木齐市"]
        "新疆维吾尔自治区和田地区"     || ["province": "新疆维吾尔自治区", "city": "和田地区"]
        "新疆维吾尔自治区博尔塔拉蒙古自治州"     || ["province": "新疆维吾尔自治区", "city": "博尔塔拉蒙古自治州"]
    }
}