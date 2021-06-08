package esi.atl.g54027.repository.dto;

public class StudentDto extends Dto<Integer> {

    private final String firstName;
    private final String lastName;

    public StudentDto(int matricule, String firstName, String lastName) {
        super(matricule);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
