package com.lookify.mvc.models;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 5)
    private String title;
    @NotBlank(message = "Must Not Be Null")
    @Size(min = 5)
    private String artist;
    @NotNull
    @Max(value = 10)
    @Min(value = 1)
    private int rating;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    public Song() {
    }
}