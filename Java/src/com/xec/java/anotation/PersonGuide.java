package com.xec.java.anotation;

public class PersonGuide {

    private Long Id;
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement
    private String age;
    private String address;

   /* @OnetoMany(MappedBy="guide",CascadeType.PERSIST)
    private Set<Person> personSet=new HashSet<>();*/






    public PersonGuide(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonGuide(String firstName, String lastName, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0, 1)
                .toUpperCase() + this.firstName.substring(1);
        this.lastName = this.lastName.substring(0, 1)
                .toUpperCase() + this.lastName.substring(1);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
