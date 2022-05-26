public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;


    public PersonBuilder setName(String name) {
        if (inputTextCorrect(name))
            throw new IllegalArgumentException("Имя не заполнено");
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() {

        if (name == null || surname == null)
            throw new IllegalStateException("не заполнены все обязательные поля");
        if (inputTextCorrect(name)) {
            throw new IllegalStateException("Имя не заполнено");
        }
        if (inputTextCorrect(surname)) {
            throw new IllegalStateException("Фамилия не заполнена");
        }
        if (age < 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным");
        }

        Person person = new Person(name, surname, age);
        if (!inputTextCorrect(address)) person.setAddress(address);

        return person;
    }

    private boolean inputTextCorrect(String text) {
        return text == null || text.trim().isEmpty();
    }

}