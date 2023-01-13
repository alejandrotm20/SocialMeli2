package com.bootcamp.be_java_hisp_w20_g6.Implement;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import com.bootcamp.be_java_hisp_w20_g6.repository.UserRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Implement.UserServiceImpl;
import com.bootcamp.be_java_hisp_w20_g6.util.TestsUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserServiceImpl mockUserServiceImpl;

    @Test
    @DisplayName("US0002 - T-00007,  Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    void shoudlGetFollowersCountOk() {
        //arrange
        int id = 1;
        UserModel user = TestsUtilsGenerator.getUserModel();
        when(mockUserRepository.getUserById(id)).thenReturn(user);
        //act
        FollowersCountResponseDto actual = mockUserServiceImpl.getFollowersCount(id);
        //assert
        assertEquals(2, actual.getFollowers_count());
    }

    @Test
    @DisplayName("US0001 - T-0001, Verificar que el usuario a seguir exista. Camino Feliz :D")
    void shouldValidateUserFollowed(){
        //arrange
        UserModel user = TestsUtilsGenerator.getUserFollow();
        UserModel userToFollow = TestsUtilsGenerator.getUserToFollow();
        when(mockUserRepository.getUserById(1)).thenReturn(user);
        when(mockUserRepository.getUserById(2)).thenReturn(userToFollow);
        //act
        boolean actual = mockUserServiceImpl.followUser(user.getUser_id(), userToFollow.getUser_id());
        //assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("US0001 - T-0001, Verificar que el usuario a seguir no existe. Camino Muy triste :'(")
    void shouldThrowUserNotFound(){
        //arrange
        when(mockUserRepository.getUserById(9999)).thenReturn(null);
        //act
        //assert
        assertThrows(UserNotFoundException.class, ()->mockUserServiceImpl.followUser(2, 9999));
    }

}