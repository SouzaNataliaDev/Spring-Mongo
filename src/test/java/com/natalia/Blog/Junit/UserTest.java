package com.natalia.Blog.Junit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.natalia.Blog.model.UserRequest;
import com.natalia.Blog.model.UserResponse;
import com.natalia.Blog.persistence.entity.User;
import com.natalia.Blog.persistence.repository.UserRepository;
import com.natalia.Blog.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
class UserTest {

    @InjectMocks
    private UserServiceImpl userServiceIpml;

    @Mock
    private UserRepository repository;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    private UserRequest request;

    private User userTest;

    private User user;

    private Optional<User> op;

    private List<UserResponse> list = new ArrayList<>();


    @BeforeEach
    public void setUp() {
        request = new UserRequest();
        request.setName("teste");
        request.setEmail("teste@gmail.com");
        request.setBirthDate(LocalDate.of(2008, 04, 12));
        request.setPosts(List.of());

        userTest = new User();
        userTest.setId("23746");
        userTest.setName("teste");
        userTest.setEmail("teste@gmail.com");
        userTest.setBirthDate(LocalDate.of(2008, 04, 12));
        userTest.setSecondKey("shhsjadj");


    }

    @Test
    public void createDeveCriarUmNovoUser() {
        when(repository.save(any())).thenReturn(user);
        UserResponse response = userServiceIpml.create(request);
        verify(repository).save(userCaptor.capture());

        assertEquals("teste", userCaptor.getValue().getName());
        assertEquals("teste@gmail.com", userCaptor.getValue().getEmail());
        assertEquals(LocalDate.of(2008, 04, 12), userCaptor.getValue().getBirthDate());
        assertNotNull(response);
    }

    @Test
    public void getAllDeveListarTodosUser() {

        when(repository.findAll()).thenReturn(List.of(userTest));
        List<UserResponse> list = userServiceIpml.getAll();
        assertFalse(list.isEmpty());

    }

    @Test
    public void findByIdDeveRetornarUmUsuarioPorId() {
        when(repository.findById(any())).thenReturn(Optional.of(userTest));
        Optional<User> op = userServiceIpml.findById(userTest.getId());
        assertNotNull(op);
        assertEquals("23746", userTest.getId());

    }

    @Test
    public void deleteByIdDeveDeletarUmUser() {
        when(repository.findById(any())).thenReturn(Optional.of(userTest));
        doNothing().when(repository).deleteById(userTest.getId());
        userServiceIpml.deleteById(userTest.getId());
        verify(repository, times(1)).deleteById(userTest.getId());

    }
}