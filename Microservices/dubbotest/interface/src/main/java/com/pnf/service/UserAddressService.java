package com.pnf.service;

import com.pnf.bean.UserAddress;

import java.util.List;

public interface UserAddressService {
    List<UserAddress> getUserAddressList(String userId);
}

