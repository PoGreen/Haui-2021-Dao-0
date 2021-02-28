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
    private int carPark;

    @Column(name = "moto_park")
    private int motoPark;

    @Column(name = "floor_area")
    private int floorArea;

    @Column(name = "home_frontage")
    private int homeFrontage;

    @Column(name = "number_floor")
    private int numberFloor;

    @Column(name = "bedroom")
    private int bedroom;

    @Column(name = "function_room")
    private int functionRoom;

    @Column(name = "altar_room")
    private int altarRoom;

    @Column(name = "campus_area")
    private int campusArea;

    @Column(name = "direction")
    private String direction;

    @Column(name = "map")
    private String map;

    @Column(name = "electricity_price")
    private int electricityPrice;

    @Column(name = "water_price")
    private int waterPrice;

    @Column(name = "service_price")
    private int servicePrice;

    @Column(name = "home_depsist")
    private int homeDeposit;

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

    public int getCarPark() {
        return carPark;
    }

    public void setCarPark(int carPark) {
        this.carPark = carPark;
    }

    public int getMotoPark() {
        return motoPark;
    }

    public void setMotoPark(int motoPark) {
        this.motoPark = motoPark;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(int floorArea) {
        this.floorArea = floorArea;
    }

    public int getHomeFrontage() {
        return homeFrontage;
    }

    public void setHomeFrontage(int homeFrontage) {
        this.homeFrontage = homeFrontage;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getFunctionRoom() {
        return functionRoom;
    }

    public void setFunctionRoom(int functionRoom) {
        this.functionRoom = functionRoom;
    }

    public int getAltarRoom() {
        return altarRoom;
    }

    public void setAltarRoom(int altarRoom) {
        this.altarRoom = altarRoom;
    }

    public int getCampusArea() {
        return campusArea;
    }

    public void setCampusArea(int campusArea) {
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

    public int getElectricityPrice() {
        return electricityPrice;
    }

    public void setElectricityPrice(int electricityPrice) {
        this.electricityPrice = electricityPrice;
    }

    public int getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(int waterPrice) {
        this.waterPrice = waterPrice;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getHomeDeposit() {
        return homeDeposit;
    }

    public void setHomeDeposit(int homeDeposit) {
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
