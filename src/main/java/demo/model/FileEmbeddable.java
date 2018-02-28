package demo.model;

import javax.persistence.Embeddable;
import java.sql.Blob;


@Embeddable
public class FileEmbeddable {

  public Blob data;

  public String fileName;

  public String contentType;

  public int size;
}
