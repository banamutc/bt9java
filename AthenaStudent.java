package Buoi9;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;

public class AthenaStudent {
    private String id;
    private String name;
    private String numberPhone;
    private String nameClass;
    private LocalDate dateOfBirth;
    private List<Integer> score;
    private Boolean paid;

    public AthenaStudent() {
    }

    public AthenaStudent(String id, String name, String numberPhone, String nameClass, LocalDate dateOfBirth, List<Integer> score, Boolean paid) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.nameClass = nameClass;
        this.dateOfBirth = dateOfBirth;
        this.score = score;
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Athena{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", nameClass='" + nameClass + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", score=" + score +
                ", paid=" + paid +
                '}';
    }

    public List<AthenaStudent> collect(Collector<Object,?, List<Object>> toList) {
        return null;
    }
}
