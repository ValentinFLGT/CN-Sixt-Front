package com.sixt.sixtfront.controller;

import java.util.List;

import ch.qos.logback.core.net.server.Client;
import com.sixt.sixtfront.form.VehicleForm;
import com.sixt.sixtfront.model.Vehicle;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/vehicleList"}, method = RequestMethod.GET)
    public List<Vehicle> vehicleList(Model model) {
        String url = "http://sixt-vehicle/vehicle";
        List<Vehicle> getVehicleList = restTemplate.getForObject(url, List.class);
        model.addAttribute("vehicleList", getVehicleList);

        return getVehicleList;
    }

    @RequestMapping(value = {"/vehicle/{id}"}, method = RequestMethod.GET)
    public Vehicle vehicleById(@PathVariable int id) {

        return restTemplate.getForObject(
                "http://sixt-vehicle/vehicle/{id}", Vehicle.class, id);
    }

    @RequestMapping(value = {"/addVehicle"}, method = RequestMethod.GET)
    public String showAddVehicle(Model model) {

        VehicleForm vehicleForm = new VehicleForm();
        model.addAttribute("vehicleForm", vehicleForm);

        return "addVehicle";
    }

    @RequestMapping(value = {"/addVehicle"}, method = RequestMethod.POST)
    public String saveVehicle(@ModelAttribute("vehicleForm") VehicleForm vehicleForm) throws JSONException {

        String licensePlate = vehicleForm.getLicensePlate();
        String type = vehicleForm.getType();
        String brand = vehicleForm.getBrand();
        String model = vehicleForm.getModel();
        String color = vehicleForm.getColor();
        Float rentPrice = vehicleForm.getRentPrice();
        Float kilometerPrice = vehicleForm.getKilometerPrice();
        Integer horsePower = vehicleForm.getHorsePower();

        String url = "http://sixt-vehicle/vehicle";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject vehicleJsonObject = new JSONObject();
        vehicleJsonObject.put("licensePlate", licensePlate);
        vehicleJsonObject.put("type", type);
        vehicleJsonObject.put("brand", brand);
        vehicleJsonObject.put("model", model);
        vehicleJsonObject.put("color", color);
        vehicleJsonObject.put("rentPrice", rentPrice);
        vehicleJsonObject.put("kilometerPrice", kilometerPrice);
        vehicleJsonObject.put("horsePower", horsePower);
        HttpEntity<String> request = new HttpEntity<>(vehicleJsonObject.toString(), headers);

        restTemplate.postForObject(url, request, Vehicle.class);

        return "addVehicle";
    }

    @RequestMapping(value = {"/clientList"}, method = RequestMethod.GET)
    public List<Client> clientList(Model model) {
        String url = "http://sixt-client/client";
        List<Client> getClientList = restTemplate.getForObject(url, List.class);
        model.addAttribute("clientList", getClientList);

        return getClientList;
    }

}