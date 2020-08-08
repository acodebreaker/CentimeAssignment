package org.centime.Assignment.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name="CHARACTER")
public class Character {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
Integer id;
Integer parentId;
String name;
String color;
}
