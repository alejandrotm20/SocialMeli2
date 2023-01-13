package com.bootcamp.be_java_hisp_w20_g6.util;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;

import java.util.List;

public class TestsUtilsGenerator {
    public static FollowersCountResponseDto getUserWithFollowers(){
        FollowersCountResponseDto follower1 = new FollowersCountResponseDto(1, "pedrito", 2);
        return follower1;
    }

    public static UserModel getUserModel(){
        return new UserModel(1, "pedrito", List.of(2, 3),  List.of(2, 3));
    }
}
