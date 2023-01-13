package com.bootcamp.be_java_hisp_w20_g6.Implement;

import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersCountResponseDto;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserServiceImpl mockUserServiceImpl;

    @Test
    @DisplayName("US0002 - T-00007,  Verificar que la cantidad de seguidores de un determinado usuario sea correcta.")
    void getFollowersCount() {
        //arrange
        int id = 1;
        UserModel user = TestsUtilsGenerator.getUserModel();
        when(mockUserRepository.getUserById(id)).thenReturn(user);
        //act
        FollowersCountResponseDto actual = mockUserServiceImpl.getFollowersCount(id);
        //assert
        assertEquals(2, actual.getFollowers_count());
    }

}