package com.aurelion.tawfiqapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Data
@ToString
public class User extends RealmObject {

    @PrimaryKey
    int id;
    String login;
    String pass;

}
