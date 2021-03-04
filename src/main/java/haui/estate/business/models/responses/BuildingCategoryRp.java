package haui.estate.business.models.responses;

public class BuildingCategoryRp {

    private String name;
    private String id;
    private String description;
    private String buildingCategory;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getBuildingCategory() {
        return buildingCategory;
    }

    public void setBuildingCategory(String buildingCategory) {
        this.buildingCategory = buildingCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
