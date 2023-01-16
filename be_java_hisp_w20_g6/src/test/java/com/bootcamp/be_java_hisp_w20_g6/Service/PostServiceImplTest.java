package com.bootcamp.be_java_hisp_w20_g6.Service;


import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.exception.InvalidParamException;
import com.bootcamp.be_java_hisp_w20_g6.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Implement.PostServiceImpl;
import com.bootcamp.be_java_hisp_w20_g6.util.TestsUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceImplTest {

    @Mock
    PostRepository mockPostRepository;

    @InjectMocks
    PostServiceImpl mockPostServiceImpl;


    @Test
    @DisplayName("US-0009 - T-0005, Verificar el correcto ordenamiento por fecha")
    void shouldValidateOrderList(){

        //arrange
        List<PostResponseDTO> listPost = TestsUtilsGenerator.getPosts();

        //act
        List<PostResponseDTO> response = mockPostServiceImpl.returnOrderPostByDate(listPost,"date_asc");
        //assert

        assertInstanceOf(List.class, response);
    }

    @Test
    @DisplayName("US-0009 - T-0005, Verficar la no existencia del ordenamiento")
    void shouldHandleInvalidOrderException(){
        //arrange
        List<PostResponseDTO> listPost = TestsUtilsGenerator.getPosts();
        String typeSort = "orderInverse";
        //act and assert
        assertThrows(InvalidParamException.class,
                ()->mockPostServiceImpl.returnOrderPostByDate(listPost, typeSort));
    }

}
