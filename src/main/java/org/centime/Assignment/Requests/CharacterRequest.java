package org.centime.Assignment.Requests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequest {
    Integer id;
    Integer parentId;
    String name;
    String color;
}
