package com.natalia.Blog.Junit;

import com.natalia.Blog.domain.Client;
import com.natalia.Blog.repository.ClientRepository;
import com.natalia.Blog.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class UserTest {

    @InjectMocks
    private ClientService userService;

    @Mock
    private ClientRepository repository;

    @Captor
    private ArgumentCaptor<Client> userCaptor;


    private Client userTest;

    private Client user;

    private Optional<Client> op;


    @BeforeEach
    public void setUp() {

//        userTest = User.builder()
//                .id("23746")
//                .name("Teste Natalia")
//                .email("teste@gmail.com")
//                .birthDate(LocalDate.of(2008, 04, 12))
//                .build();
    }

    @Test
    public void createDeveCriarUmNovoUser() {
        when(repository.save(any())).thenReturn(user);
        verify(repository).save(userCaptor.capture());

        assertEquals("Teste Natalia", userCaptor.getValue().getName());
        assertEquals("teste@gmail.com", userCaptor.getValue().getEmail());
        assertEquals(LocalDate.of(2008, 04, 12), userCaptor.getValue());
    }

    @Test
    public void getAllDeveListarTodosUser() {
        when(repository.findAll()).thenReturn(List.of(userTest));
        List<Client> list = userService.getAll();
        assertFalse(list.isEmpty());

    }

//    @Test
//    public void findByIdDeveRetornarUmUsuarioPorId() {
//        when(repository.findById(any())).thenReturn(Optional.of(userTest));
//        Optional<Client> op = userService.findById(userTest.getId());
//        assertTrue(op.isPresent());
//        assertEquals("23746", userTest.getId());
//
//    }

    @Test
    public void deleteByIdDeveDeletarUmUser() {
        when(repository.findById(any())).thenReturn(Optional.of(userTest));
        doNothing().when(repository).deleteById(userTest.getId());
        userService.deleteById(userTest.getId());
        verify(repository, times(1)).deleteById(userTest.getId());

    }
}