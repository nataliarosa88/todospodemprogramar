package br.com.todospodemprogramar.app.services;

import br.com.todospodemprogramar.app.mock.UserData;
import br.com.todospodemprogramar.app.model.User;
import br.com.todospodemprogramar.app.repository.UserRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    private UserService service;

    private User returnedUser;

    @Before
    public void setup() {

        service = new UserService(repository);
        returnedUser = UserData.getUserMock(99999);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void dadoQualquerUsuario_QuandoSalvoOUsuario_entaoUsuarioEhSalvoERetornado() throws Exception {

        // given
        User user = UserData.getUserMock();
        when(repository.findByUsername(eq(user.getUsername()))).thenReturn(returnedUser);
        when(repository.save(eq(user))).thenReturn(user);

        // when
        User savedUser = service.saveMyUser(user);

        // then
        assertNotNull(savedUser);
        assertEquals(user, savedUser);
        verify(repository, times(1)).save(eq(user));
    }
}