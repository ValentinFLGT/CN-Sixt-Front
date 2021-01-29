package com.sixt.sixtfront.controller;

import ch.qos.logback.core.net.server.Client;
import com.sixt.sixtfront.model.RegisterForm;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = {"/clientList"}, method = RequestMethod.GET)
    public List<Client> clientList(Model model) {
        String url = "http://sixt-client/client";
        List<Client> getClientList = restTemplate.getForObject(url, List.class);
        model.addAttribute("clientList", getClientList);

        return getClientList;
    }

    @RequestMapping(value = { "/register" }, method = RequestMethod.GET)
    public String register(Model model) {

        RegisterForm registerForm = new RegisterForm();
        model.addAttribute("registerForm", registerForm);

        return "register";
    }

    @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
    public String saveClient(Model model, //
        @ModelAttribute("registerForm") RegisterForm registerForm) throws JSONException {

        String firstName = registerForm.getFirstName();
        String lastName = registerForm.getLastname();
        Date dateOfBirth = registerForm.getDateOfBirth();
        Integer licenseNumber = registerForm.getLicenseNumber();
        Date licenseAcquisitionDate = registerForm.getLicenseAcquisitionDate();

        String url = "http://sixt-client/client";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject avatarJsonObject = new JSONObject();
        avatarJsonObject.put("firstName", firstName);
        avatarJsonObject.put("lastName", lastName);
        avatarJsonObject.put("dateOfBirth", dateOfBirth);
        avatarJsonObject.put("licenseNumber", licenseNumber);
        avatarJsonObject.put("licenseAcquisitionDate", licenseAcquisitionDate);

        HttpEntity<String> request = new HttpEntity<>(avatarJsonObject.toString(), headers);

        restTemplate.postForObject(url, request, Client.class);
        return "redirect:/clientList";
    }
}
