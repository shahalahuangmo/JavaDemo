package com.example.spockdemo.service.impl;

import com.example.spockdemo.entity.Order;
import com.example.spockdemo.entity.UserInfo;
import com.example.spockdemo.entity.UserInfoDTO;
import com.example.spockdemo.exception.ApiException;
import com.example.spockdemo.mapper.UserMapper;
import com.example.spockdemo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Auther: pengnanfa
 * @Date: 2021/11/05 /6:29 下午
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfoDTO getUserById(Integer id) {
        UserInfo userInfo = userMapper.getById(id);
        UserInfoDTO dto = new UserInfoDTO();
        if (null == userInfo) {
            return dto;
        }
        BeanUtils.copyProperties(userInfo, dto);
        if ("上海市".equals(dto.getCity())) {
            dto.setPostCode("200000");
        }
        if ("北京市".equals(dto.getCity())) {
            dto.setPostCode("100000");
        }
        return dto;
    }


    /**
     * 根据汇率计算金额
     *
     * @param userInfoDTO
     */
    public void setOrderAmountByExchange(UserInfoDTO userInfoDTO) {
        if (null == userInfoDTO.getUserOrders() || userInfoDTO.getUserOrders().size() <= 0) {
            return;
        }
        for (Order order : userInfoDTO.getUserOrders()) {
            Double amount = order.getAmount();
            // 获取汇率(调用汇率接口)
            Double exchange = userMapper.getExchangeByCountry(order.getCountry());
            // 根据汇率计算金额
            double exchangeAmount = amount * exchange;
            order.setExchangeAmount(exchangeAmount);
        }
    }


    /**
     * 校验请求参数user是否合法
     *
     * @param user
     * @throws ApiException
     */
    public void validateUser(UserInfoDTO user) throws ApiException {
        if (user == null) {
            throw new ApiException("10001", "user is null");
        }
        if (null == user.getUserName() || "".equals(user.getUserName())) {
            throw new ApiException("10002", "user name is null");
        }
        if (user.getAge() == null) {
            throw new ApiException("10003", "user age is null");
        }
        if (null == user.getCity() || "".equals(user.getCity())) {
            throw new ApiException("10004", "user city is null");
        }
        if (null == user.getEmail() || "".equals(user.getEmail())) {
            throw new ApiException("10005", "user email is null");
        }
        if (null == user.getUserOrders() || user.getUserOrders().size() <= 0) {
            throw new ApiException("10006", "user order is null");
        }
        for (Order order : user.getUserOrders()) {
            if (null == order.getOrderNo() || "".equals(order.getOrderNo())) {
                throw new ApiException("10007", "order number is null");
            }
            if (null == order.getAmount()) {
                throw new ApiException("10008", "order amount is null");
            }
        }
    }

}
