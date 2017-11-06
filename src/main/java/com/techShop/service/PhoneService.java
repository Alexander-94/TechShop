package com.techShop.service;

import com.techShop.entity.PhoneStatus;
import com.techShop.entity.Phone;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr Ryzhkov on 31.10.2017.
 */
public interface PhoneService {
    Phone addNewPhone(Phone phone);

    boolean removePhone(long id);

    List<Phone> getAllAvailablePhones();

    List<Phone> getAllPhonesByStatus(PhoneStatus status);

    List<Phone> getAllPhones();

    Phone getPhoneByTitle(String title);

    Phone getPhoneById(long id);

    void updatePhone(long id, Map<String, String> mapWithProps);
}
