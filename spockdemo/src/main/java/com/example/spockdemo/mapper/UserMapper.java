package com.example.spockdemo.mapper;

import com.example.spockdemo.entity.UserInfo;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:30 下午
 */
@Component
public class UserMapper {
    public UserInfo getById(Integer id){
        return  new UserInfo();
    }

    /**
     * 获取其他国家的汇率
     *
     * @param country
     * @return
     */
    public double getExchangeByCountry(String country) {
        switch (country) {
            case "韩元":
                return 184.70;
            case "美元":
                return 0.15628;
            case "日元":
                return 17.721;
            case "英镑":
                return 0.11579;
            case "欧元":
                return 0.13515;
            default:
                return 1;
        }

    }
}
