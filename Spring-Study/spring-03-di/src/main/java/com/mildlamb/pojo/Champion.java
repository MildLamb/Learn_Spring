package com.mildlamb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Champion {
    private String name;
    private Address address;
    private String[] alias;
    private List hobbies;
    private Map<String,String> skills;
    private Set<String> achievement;
    private Properties info;
    private String wife;

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                "\n, address=" + address.toString() +
                "\n, alias=" + Arrays.toString(alias) +
                "\n, hobbies=" + hobbies +
                "\n, skills=" + skills +
                "\n, achievement=" + achievement +
                "\n, info=" + info +
                "\n, wife='" + wife + '\'' +
                '}';
    }
}
