package haui.estate.business.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "buildings")
public class Building extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "car_pard")
    private Integer carPark;

    @Column(name = "moto_park")
    private Integer motoPark;

    @Column(name = "floor_area")
    private Integer floorArea;

    @Column(name = "home_frontage")
    private Integer homeFrontage;

    @Column(name = "number_floor")
    private Integer numberFloor;

    @Column(name = "bedroom")
    private Integer bedroom;

    @Column(name = "function_room")
    private Integer functionRoom;

    @Column(name = "altar_room")
    private Integer altarRoom;

    @Column(name = "campus_area")
    private Integer campusArea;

    @Column(name = "direction")
    private String direction;

    @Column(name = "map")
    private String map;

    @Column(name = "electricity_price")
    private Integer electricityPrice;

    @Column(name = "frequence")
    private Integer frequence;

    @Column(name = "water_price")
    private Integer waterPrice;

    @Column(name = "service_price")
    private Integer servicePrice;

    @Column(name = "home_depsist")
    private Integer homeDeposit;

    @Column(name = "address")
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ward_id")
    private Ward ward;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_category_id")
    private BuildingCategory buildingCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private List<Image> images = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCarPark() {
        return carPark;
    }

    public void setCarPark(Integer carPark) {
        this.carPark = carPark;
    }

    public Integer getMotoPark() {
        return motoPark;
    }

    public void setMotoPark(Integer motoPark) {
        this.motoPark = motoPark;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public Integer getHomeFrontage() {
        return homeFrontage;
    }

    public void setHomeFrontage(Integer homeFrontage) {
        this.homeFrontage = homeFrontage;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Integer getBedroom() {
        return bedroom;
    }

    public void setBedroom(Integer bedroom) {
        this.bedroom = bedroom;
    }

    public Integer getFunctionRoom() {
        return functionRoom;
    }

    public void setFunctionRoom(Integer functionRoom) {
        this.functionRoom = functionRoom;
    }

    public Integer getAltarRoom() {
        return altarRoom;
    }

    public void setAltarRoom(Integer altarRoom) {
        this.altarRoom = altarRoom;
    }

    public Integer getCampusArea() {
        return campusArea;
    }

    public void setCampusArea(Integer campusArea) {
        this.campusArea = campusArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Integer getElectricityPrice() {
        return electricityPrice;
    }

    public void setElectricityPrice(Integer electricityPrice) {
        this.electricityPrice = electricityPrice;
    }

    public Integer getFrequence() {
        return frequence;
    }

    public void setFrequence(Integer frequence) {
        this.frequence = frequence;
    }

    public Integer getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(Integer waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Integer getHomeDeposit() {
        return homeDeposit;
    }

    public void setHomeDeposit(Integer homeDeposit) {
        this.homeDeposit = homeDeposit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public BuildingCategory getBuildingCategory() {
        return buildingCategory;
    }

    public void setBuildingCategory(BuildingCategory buildingCategory) {
        this.buildingCategory = buildingCategory;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
