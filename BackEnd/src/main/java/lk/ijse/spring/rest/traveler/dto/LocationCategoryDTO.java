package lk.ijse.spring.rest.traveler.dto;

public class LocationCategoryDTO {

    private String name;
    private String discription;

    public LocationCategoryDTO() {
    }

    public LocationCategoryDTO(String name, String discription) {
        this.setName(name);
        this.setDiscription(discription);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
