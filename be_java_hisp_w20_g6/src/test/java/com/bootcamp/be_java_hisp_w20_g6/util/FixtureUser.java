package com.bootcamp.be_java_hisp_w20_g6.util;

import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class FixtureUser {
    public List <UserModel> listUsersTest;

    @BeforeEach
    void generatorUsers() {

        this.listUsersTest = List.of(
                new UserModel(1,"Diana", new ArrayList<Integer>() {{add(2);add(3);}}, new ArrayList<Integer>() {{add(2);add(3);}}),
                new UserModel(2,"Daniela", new ArrayList<Integer>() {{add(1);add(3);}}, new ArrayList<Integer>() {{add(1);add(3);}}),
                new UserModel(3,"David", new ArrayList<Integer>() {{add(1);add(2);}}, new ArrayList<Integer>() {{add(1);add(2);}})
        );
    }
}
