package org.videosharing.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    //todo probably should have been written on disk, saved link to the file here, check out postgresql docs if saving big files is alright for db
    @Lob
    private byte[] data;

    //todo replace with lombok builder
    public Video(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }
    //todo create date required for sorting
}
