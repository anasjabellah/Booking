package com.example.bookingmt.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@JsonIgnoreProperties(value={"roomList" }, allowSetters= true)
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String Name ;
    private String City ;
    private String Address ;

   @OneToOne
    private User manager ;

    private boolean isApproved;

    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    private List<Room> roomList;

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", City='" + City + '\'' +
                ", Address='" + Address + '\'' +
                ", manager=" + manager +
                ", isApproved=" + isApproved +
                '}';
    }
}
