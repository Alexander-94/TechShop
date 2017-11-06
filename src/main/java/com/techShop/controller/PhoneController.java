package com.techShop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techShop.entity.Phone;
import com.techShop.service.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/techshop/phone")
public class PhoneController {
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "ph", method = RequestMethod.GET)
    public String getPhoneByTitle(@RequestParam("title") String title) throws JsonProcessingException {
        Phone phoneByTitle = phoneService.getPhoneByTitle(title);
        return mapper.writeValueAsString(phoneByTitle);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public JsonNode getAllPhones() throws JsonProcessingException {
        return mapper.valueToTree(phoneService.getAllPhones());

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addNewPhone(@RequestBody JsonNode newPhone) throws JsonProcessingException {
        Phone phone = mapper.treeToValue(newPhone, Phone.class);
        if (phoneService.addNewPhone(phone) != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removePhone(@PathVariable("id") long id) {
        phoneService.removePhone(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updatePhone(@PathVariable("id") long id, @RequestBody JsonNode detailsToUpdate) throws JsonProcessingException {
        Map<String, String> mapWithProps = mapper.treeToValue(detailsToUpdate, Map.class);

        phoneService.updatePhone(id, mapWithProps);
    }
}

