package com.techShop.service;

import com.techShop.DAO.PhoneRepository;
import com.techShop.entity.Phone;
import com.techShop.entity.PhoneStatus;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Oleksandr Ryzhkov on 29.10.2017.
 */
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public Phone addNewPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public boolean removePhone(long id) {
        try {
            Phone phone = phoneRepository.getById(id);
            phoneRepository.delete(phone);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Phone> getAllAvailablePhones() {
        return phoneRepository.getPhoneByStatus(PhoneStatus.AVAILABLE);
    }

    @Override
    public List<Phone> getAllPhonesByStatus(PhoneStatus status){
        return phoneRepository.getPhoneByStatus(status);
    }

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneByTitle(String title) {
        return phoneRepository.getPhoneByTitle(title);
    }

    @Override
    public Phone getPhoneById(long id) {
        return phoneRepository.getById(id);
    }

    @Override
    public void updatePhone(long id, Map<String, String> mapWithProps) {
        Phone phoneToUpdate = getPhoneById(id);

        for (Map.Entry<String, String> entry : mapWithProps.entrySet()) {
            if (StringUtils.isNoneEmpty(entry.getValue())) {
                switch (entry.getKey()) {
                    case "title":
                        phoneToUpdate.setTitle(entry.getValue());
                        break;
                    case "manufacturer":
                        phoneToUpdate.setManufacturer(entry.getValue());
                        break;
                    case "isDigital":
                        phoneToUpdate.setDigital(Boolean.valueOf(entry.getValue()));
                        break;
                    case "status":
                        phoneToUpdate.setStatus(PhoneStatus.valueOf(entry.getValue()));
                        break;
                }
            }
        }
        phoneRepository.save(phoneToUpdate);
    }
}
