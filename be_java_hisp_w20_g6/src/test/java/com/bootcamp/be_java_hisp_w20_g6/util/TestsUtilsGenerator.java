package com.bootcamp.be_java_hisp_w20_g6.util;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.model.ProductModel;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestsUtilsGenerator {
    public static List<UserModel> ListUsersModelWithFollowers(){
        return List.of(
                new UserModel(1,"Diana", new ArrayList<Integer>() {{add(2);add(3);}}, new ArrayList<Integer>() {{add(2);add(3);}}),
                new UserModel(2,"Daniela", new ArrayList<Integer>() {{add(1);add(3);}}, new ArrayList<Integer>() {{add(1);add(3);}}),
                new UserModel(3,"David", new ArrayList<Integer>() {{add(1);add(2);}}, new ArrayList<Integer>() {{add(1);add(2);}})
        );

    }
    public static List<UserModel> ListUsersModelWithOutFollowers(){
        return List.of(
                new UserModel(1,"Diana", new ArrayList<>() , new ArrayList<>() ),
                new UserModel(2,"Daniela", new ArrayList<>(), new ArrayList<>()),
                new UserModel(3,"David", new ArrayList<>(), new ArrayList<>())
        );

    }
    public static UserModel getUserWithFollowers(int index){
        return ListUsersModelWithFollowers().get(index);
    }
    public static UserModel getUserWithOutFollowers(int index){
        return ListUsersModelWithOutFollowers().get(index);
    }

    public static List<UserResponseDto> getListUserRespondeDTOWithFollowers(){
        return ListUsersModelWithFollowers().stream()
                .map(u->new UserResponseDto(u.getUser_id(),u.getUser_name())).collect(Collectors.toList());
    }

    public static List<PostResponseDTO> getPosts() {
        return new ArrayList<>(
                Arrays.asList(
                        new PostResponseDTO(1, 1, LocalDate.of(2023, 1, 13),
                            new ProductModel(1, "Silla", "Gamer", "Racer", "Red & Black", "Special Edition"),
                        100, 1500.5),
                        new PostResponseDTO(1, 2, LocalDate.of(2023, 1, 15),
                            new ProductModel(1, "Silla", "Gamer", "Racer", "Red & Black", "Special Edition"),
                            100, 1500.50),
                        new PostResponseDTO(1, 1, LocalDate.of(2023, 1, 17),
                            new ProductModel(1, "Silla", "Gamer", "Racer", "Red & Black", "Special Edition"),
                            100, 1500.50)
                )
        );
    }
}
