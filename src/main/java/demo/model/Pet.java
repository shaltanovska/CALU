package demo.model;

import javax.persistence.*;
import java.sql.Blob;


@Entity
@Table(name="Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Column
    public String name;

    @Column(length=5000)
    public String description;

    @Column
    public String gender;

    @Column
    public String age;

    @Column
    public String category;

    @Column
    public String email;


    public Pet(String name,String description,String gender,String age,String category,String email){
        this.name=name;
        this.description=description;
        this.gender=gender;
        this.age=age;
        this.category=category;
        this.email=email;

    }

    public Pet(){}

//    @Column
//    public Blob image;



}
