package haui.estate.business.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "buildingCategories")
public class BuildingCategory extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "building_category_father")
    private String buildingCategory;

    @OneToMany(mappedBy = "buildingCategory")
    private List<Building> buildings = new ArrayList<>();

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

    public String getBuildingCategory() {
        return buildingCategory;
    }

    public void setBuildingCategory(String buildingCategory) {
        this.buildingCategory = buildingCategory;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }
}
