package dao;

import entity.Pet;

public class Cat extends Pet{
	private String catColor;

    public Cat(String name, int age, String breed, String catColor,int pet_id,int shelter_id) {
    	super(pet_id,name, age, breed,shelter_id);
        this.catColor = catColor;
    }


    public String getCatColor() {
        return catColor;
    }

    public void setCatColor(String catColor) {
        this.catColor = catColor;
    }

    @Override
    public String toString() {
        return "Cat [name=" + getName() + ", age=" + getAge() + ", breed=" + getBreed() + ", catColor=" + catColor + "]";
    }
}