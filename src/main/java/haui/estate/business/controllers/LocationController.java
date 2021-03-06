package haui.estate.business.controllers;

import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.services.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "locations")
public class LocationController {

    @Autowired
    private ILocationService iLocationService;

    @GetMapping(value = "/locations/provinces")
    public ResponseEntity<SystemResponse<Object>> getProvinces(){
        return iLocationService.getAllProvinces();
    }

    @GetMapping(value = "/locations/provinces/{id}/districts")
    public ResponseEntity<SystemResponse<Object>> getDistrictsByProvince(@PathVariable(name = "id") int provinceId){
        return iLocationService.getDistrictsByProvince(provinceId);
    }

    @GetMapping(value = "/locations/districts/{id}/wards")
    public ResponseEntity<SystemResponse<Object>> getWardByDistrict(@PathVariable(name = "id") int districtId){
        return iLocationService.getWardsByDistrict(districtId);
    }
}
