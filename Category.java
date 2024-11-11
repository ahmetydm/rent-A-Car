public class Category {
    private int id;
    private String name;
    private String description;
    private boolean isActive;


    public Category(int id, String name, String description, boolean isActive) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setActive(isActive);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
