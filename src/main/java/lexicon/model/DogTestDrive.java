package lexicon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DogTestDrive {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(1, "a"));
        dogs.add(new Dog(2, "b"));
        dogs.add(new Dog(3, "c"));
        System.out.println(dogs.contains(new Dog(1, "aa")));
    }
}


class Dog {
    private final int id;
    private final String name;

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
