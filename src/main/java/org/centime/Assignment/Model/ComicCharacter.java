package org.centime.Assignment.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMICCHARACTER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComicCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @Column(name = "parentId")
    Integer parentId;
    @Column(name = "name")
    String name;
    @Column(name = "color")
    String color;
}
