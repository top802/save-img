package top.example.img.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String firstName;

    @Column(name = "created_date")
    private Date createdDate;



}
