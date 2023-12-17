package dao;

import entity.Pet;

public class Dog extends Pet {
    private String dogBreed;

    public Dog(String name, int age, String breed, String dogBreed,int pet_id,int shelter_id) {
        super(pet_id,name, age, breed,shelter_id);
        this.dogBreed = dogBreed;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    @Override
    public String toString() {
        return "Dog [name=" + getName() + ", age=" + getAge() + ", breed=" + getBreed() + ", dogBreed=" + dogBreed + "]";
    }
}