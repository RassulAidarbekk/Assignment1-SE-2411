class Person {
    String name;
    String surname;
    int age;
    boolean gender;

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public String toString() {
        String genderStr = gender ? "Male" : "Female";
        return String.format("Hi, I am %s %s, a %d-year-old %s.", name, surname, age, genderStr);
    }
}