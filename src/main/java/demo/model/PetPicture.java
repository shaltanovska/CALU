package demo.model;

import javax.persistence.*;

/**
 * Created by Aleksandar on 25.06.2017.
 */
@Entity
@Table(name = "pet_pictures")
public class PetPicture {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer id;

  @Embedded
  public FileEmbeddable picture;

  @ManyToOne
  public Pet pet;

}
