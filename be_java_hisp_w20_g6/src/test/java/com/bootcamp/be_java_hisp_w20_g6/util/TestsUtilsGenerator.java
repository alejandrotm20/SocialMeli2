package com.bootcamp.be_java_hisp_w20_g6.util;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import org.apache.catalina.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestsUtilsGenerator {
    public static FollowersCountResponseDto getUserWithFollowers(){
        FollowersCountResponseDto follower1 = new FollowersCountResponseDto(1, "pedrito", 2);
        return follower1;
    }

    public static UserModel getUserModel(){
        return new UserModel(1, "pedrito", List.of(2, 3),  List.of(2, 3));
    }


    public static UserModel getUserToFollow(){
        return new UserModel(1, "pedrito", new ArrayList<>(),  new ArrayList<>());
    }

    public static UserModel getUserFollow(){
        return new UserModel(2, "pablito", new ArrayList<>(),  new ArrayList<>());
    }

}
