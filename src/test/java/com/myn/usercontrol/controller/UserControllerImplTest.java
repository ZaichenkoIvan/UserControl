package com.myn.usercontrol.controller;

import com.myn.usercontrol.dto.User;
import com.myn.usercontrol.service.InitializationDataForTest;
import com.myn.usercontrol.service.UserService;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerImplTest {
    private static final Long EXIST_ID = 1L;

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserControllerImpl userController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new ExceptionHandlerController()).build();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void showUsers() throws Exception {
        addPagination();

        ModelAndView mav = mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andReturn().getModelAndView();

        Map<String, Object> model = Objects.requireNonNull(mav).getModel();

        verify(userService).getPageUsers(anyInt(), anyInt());
        verifyNoMoreInteractions(userService);
        assertThat(model.get("user"), notNullValue());
        assertThat(((Page<User>) model.get("users")).getContent(), IsCollectionWithSize.hasSize(1));
    }

    @Test
    public void createUser() throws Exception {
        addPagination();

        User user = InitializationDataForTest.getUser();

        mockMvc.perform(post("/user")
                .flashAttr("user", user))
                .andExpect(view().name("redirect:/user"));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        verify(userService).save(userCaptor.capture());
        verify(userService).getPageUsers(anyInt(), anyInt());

//        assertThat(userCaptor.getValue(), is(InitializationDataForTest.getUser()));
        assertThat(userCaptor.getValue(), notNullValue());
    }

    @Test
    public void updateUser() throws Exception {
        addPagination();
        when(userService.findById(EXIST_ID)).thenReturn(new User());

        ModelAndView mav = mockMvc.perform(get("/user/edit/{id}", EXIST_ID))
                .andExpect(status().isOk())
                .andExpect(view().name("users"))
                .andReturn().getModelAndView();

        Map<String, Object> model = Objects.requireNonNull(mav).getModel();

        verify(userService).findById(EXIST_ID);

        assertThat(model.get("user"), notNullValue());
    }

    private void addPagination() {
        when(userService.getPageUsers(anyInt(), anyInt())).thenReturn(new PageImpl<>(singletonList(new User())));
    }
}
