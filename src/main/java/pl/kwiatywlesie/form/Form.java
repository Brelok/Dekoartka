package pl.kwiatywlesie.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String surname;
    private String name;
    private String phoneNumber;
    private String email;
    private String subject;
    private String date;
    private String message;
    private String[] services;

    public Form(String name, String surname, String phoneNumber, String email, String subject, String date, String message) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subject = subject;
        this.date = date;
        this.message = message;
    }

    public Form(String name, String surname, String phoneNumber, String email, String subject, String date, String message, String[] services) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.subject = subject;
        this.date = date;
        this.services = services;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", services=" + Arrays.toString(services) +
                '}';
    }
}
