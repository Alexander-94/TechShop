package com.techShop.DAO;

import com.techShop.entity.PhoneStatus;
import com.techShop.entity.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Oleksandr Ryzhkov on 28.10.2017.
 */
public interface PhoneRepository extends CrudRepository<Phone, Long> {

    List<Phone> getPhoneByStatus(PhoneStatus status);

    Phone getById(long id);

    List<Phone> findAll();

    Phone save(Phone phone);

    // custom query example and return a stream
    @Query("select w from Phone w where w.title = :title")
    Phone getPhoneByTitle(@Param("title") String title);

    void delete(Phone phone);
}
