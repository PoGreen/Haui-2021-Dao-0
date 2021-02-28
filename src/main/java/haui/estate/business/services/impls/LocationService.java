package haui.estate.business.services.impls;

import haui.estate.business.models.bos.Response;
import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.entities.District;
import haui.estate.business.models.entities.Province;
import haui.estate.business.models.entities.Ward;
import haui.estate.business.models.responses.DistrictRp;
import haui.estate.business.models.responses.ProvinceRp;
import haui.estate.business.models.responses.WardRp;
import haui.estate.business.repositories.DistrictRepository;
import haui.estate.business.repositories.ProvinceRepository;
import haui.estate.business.repositories.WardRepository;
import haui.estate.business.services.ILocationService;
import haui.estate.business.services.mappers.LocationMapper;
import haui.estate.business.utils.Global;
import haui.estate.business.utils.StringRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocationService implements ILocationService {

    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public ResponseEntity<SystemResponse<Object>> getAllProvinces() {
        List<Province> provinces = provinceRepository.findAll();
        List<ProvinceRp> provinceRps = locationMapper.mapToProvinceRps(provinces);
        Map<String,Object> result = new HashMap<>();
        result.put(Global.PROVINCES,provinceRps);
        return Response.ok(result);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> getDistrictsByProvince(int provinceId) {
        Province province = provinceRepository.findById(provinceId).orElse(null);
        if(Objects.isNull(province)){
            return Response.badRequest(StringRp.PROVINCE_IS_FAKE);
        }
        List<District> districts = districtRepository.findByProvince_Id(provinceId);
        List<DistrictRp> districtRps = locationMapper.mapToDistrictRps(districts);
        Map<String,Object> result = new HashMap<>();
        result.put(Global.DISTRICTS,districtRps);
        return Response.ok(result);
    }

    @Override
    public ResponseEntity<SystemResponse<Object>> getWardsByDistrict(int districtId) {
        District district = districtRepository.findById(districtId).orElse(null);
        if(Objects.isNull(district)){
            return Response.badRequest(StringRp.DISTRICT_IS_FAKE);
        }
        List<Ward> wards = wardRepository.findByDistrict_Id(districtId);
        List<WardRp> wardRps = locationMapper.mapToWardRps(wards);
        Map<String,Object> result = new HashMap<>();
        result.put(Global.WARDS,wardRps);
        return Response.ok(result);
    }

}
