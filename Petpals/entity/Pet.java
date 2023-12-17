package entity;

public class Pet {
    private String name;
    private int age;
    private String breed;
    private int pet_id;
    private int shelter_id;

    public Pet(int pet_id,String name, int age, String breed,int shelter_id) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.pet_id=pet_id;
        this.shelter_id=shelter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    public int getPet_id() {
        return pet_id;
    }

    public void setPet_id(int pet_id) {
        this.pet_id = pet_id;
    }
    public int getShelter_id() {
        return shelter_id;
    }

    public void setShelter_id(int shelter_id) {
        this.shelter_id = shelter_id;
    }


    @Override
    public String toString() {
        return "Pet [name=" + name + ", age=" + age + ", breed=" + breed + ", pet id =" + pet_id + ", shelter id=" + shelter_id +"]";
    }
}