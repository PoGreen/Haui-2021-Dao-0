package haui.estate.business.services;

import haui.estate.business.models.bos.SystemResponse;
import org.springframework.http.ResponseEntity;

public interface ILocationService {
    ResponseEntity<SystemResponse<Object>> getAllProvinces();
    ResponseEntity<SystemResponse<Object>> getDistrictsByProvince(int provinceId);
    ResponseEntity<SystemResponse<Object>> getWardsByDistrict(int districtsId);
    String getLocationByWard(int wardId);
}
