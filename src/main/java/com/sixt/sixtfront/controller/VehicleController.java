package com.sixt.sixtfront.controller;

import java.util.List;

import ch.qos.logback.core.net.server.Client;
import com.sixt.sixtfront.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
class MainController {

    @Autowired
    private  RestTemplate restTemplate;

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

//    @RequestMapping(value = {"/vehicleList"}, method = RequestMethod.GET)
//    public List vehicleList() {
//
//        return restTemplate.getForObject(
//                "http://sixt-vehicle/vehicle", List.class);
//    }

    @RequestMapping(value = {"/vehicleList"}, method = RequestMethod.GET)
    public List<Vehicle> vehicleList(Model model) {
        String url = "http://sixt-vehicle/vehicle";
        List<Vehicle> getVehicleList = restTemplate.getForObject(url, List.class);
        model.addAttribute("vehicleList", getVehicleList);

        return getVehicleList;
    }

    @RequestMapping(value = {"/clientList"}, method = RequestMethod.GET)
    public List<Client> clientList(Model model) {
        String url = "http://sixt-client/client";
        List<Client> getClientList = restTemplate.getForObject(url, List.class);
        model.addAttribute("clientList", getClientList);

        return getClientList;
    }

//    @RequestMapping(value = {"/character/{id}"}, method = RequestMethod.GET)
//    public Character characterById() {
//
//        return restTemplate.getForObject(
//                "http://localhost:8081/character/{id}", Character.class);
//    }
//
//    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.GET)
//    public String showAddCharacter(Model model) {
//
//        CharacterForm characterForm = new CharacterForm();
//        model.addAttribute("characterForm", characterForm);
//
//        return "addCharacter";
//    }
//
//    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.POST)
//    public String saveCharacter(Model model, //
//                                @ModelAttribute("characterForm") CharacterForm characterForm) throws JSONException {
//
//        String name = characterForm.getName();
//        String gender = characterForm.getGender();
//
//        String url = "http://valentin-back/character";
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        JSONObject characterJsonObject = new JSONObject();
//        characterJsonObject.put("name", name);
//        characterJsonObject.put("gender", gender);
//        HttpEntity<String> request = new HttpEntity<>(characterJsonObject.toString(), headers);
//
//        if (name != null && name.length() > 0 //
//                && gender != null && gender.length() > 0) {
//
//            restTemplate.postForObject(url, request, Character.class);
//
//            return "redirect:/characterList";
//        }
//
//        model.addAttribute("errorMessage", errorMessage);
//        return "addCharacter";
//    }

}