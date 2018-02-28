package demo.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name="Pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column
    public String name;

    @Column(length=5000)
    public String description;

    @Column
    public String sex;

    @Column
    public String age;

    @Column
    public String category;

//    @Column
//    public Blob image;



}
