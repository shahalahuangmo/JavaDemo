package groovy;

import com.example.spockdemo.util.AddressResolutionUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /5:57 下午
 */
@RunWith(Parameterized.class)
public class AddressResolutionUtilJunitTest {

    private String inputString;
    private Map<String, String> expectedResult;


    public AddressResolutionUtilJunitTest(String inputString, Map<String, String> expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {"湖北省武汉市", new HashMap<String, String>() {{
                    put("province", "湖北省");
                    put("city", "武汉市");
                }}},
                {"天津市天津市", new HashMap<String, String>() {{
                    put("province", "天津市");
                    put("city", "天津市");
                }}},
                {"湖南省湘西自治州", new HashMap<String, String>() {{
                    put("province", "湖南省");
                    put("city", "湘西自治州");
                }}},
                {"新疆维吾尔自治区乌鲁木齐市", new HashMap<String, String>() {{
                    put("province", "新疆维吾尔自治区");
                    put("city", "乌鲁木齐市");
                }}},
                {"新疆维吾尔自治区阿克苏地区", new HashMap<String, String>() {{
                    put("province", "新疆维吾尔自治区");
                    put("city", "阿克苏地区");
                }}},
                {"新疆维吾尔自治区巴音郭楞蒙古自治州", new HashMap<String, String>() {{
                    put("province", "新疆维吾尔自治区");
                    put("city", "巴音郭楞蒙古自治州");
                }}},
        });
    }

    @Test
    public void testPrimeNumberChecker() {
        Assert.assertEquals(expectedResult, AddressResolutionUtil.addressResolution(inputString));
    }
}
