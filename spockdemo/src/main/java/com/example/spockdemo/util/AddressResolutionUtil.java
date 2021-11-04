package com.example.spockdemo.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Description:
 * </p>
 *
 * @Author pengnanfa
 * @Date 2021-11-04 22:38
 */
public class AddressResolutionUtil {
    /**
     * 解析地址
     *
     * @param address
     * @return
     * @author lin
     */
    public static Map<String, String> addressResolution(String address) {
        String provinceCityRegex = "(?<province>[^省]+^自治区|.*?自治区|.*?省|.*?行政区|.*?市)" +
                "(?<city>上海城区|北京城区|天津城区|重庆城区|重庆郊县|[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|香港岛|九龙|新界|澳门半岛|离岛|.*?市|.*?县)";
        Matcher matcher = Pattern.compile(provinceCityRegex).matcher(address);
        String province, city;
        Map<String, String> row = new LinkedHashMap<>(2);
        while (matcher.find()) {
            province = matcher.group("province");
            row.put("province", province == null ? null : province.trim());
            city = matcher.group("city");
            row.put("city", city == null ? null : city.trim());
        }
        return row;
    }
}
