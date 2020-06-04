//package com.myn.usercontrol.controller;
//
//import com.myn.usercontrol.dto.User;
//import com.myn.usercontrol.service.UserService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//
//@WebMvcTest(UserControllerImplTest.class)
//class UserControllerImplTest {
//    private static final User USER = getUser();
//    private static final User SAVE_USER = getSaveUser();
//
//    private static final Long id = 1L;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//
//    @Test
//    void showUsers() {
//
//    }
//
//    @Test
//    void showUser() {
//        when(userService.(email, password)).thenReturn(Optional.of(expected));
//
//        mockMvc.perform(post("/app/signin")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("email", email)
//                .param("password", password)
//        )
//                .andExpect(status().isFound())
//                .andExpect(redirectedUrl(PagesPaths.CATALOG_PATH))
//                .andExpect(request().sessionAttribute("user", hasProperty("email", is(email))))
//                .andExpect(request().sessionAttribute("user", hasProperty("password", is(password))));
//
//        ArgumentCaptor<String> emailArgument = ArgumentCaptor.forClass(String.class);
//        ArgumentCaptor<String> passwordArgument = ArgumentCaptor.forClass(String.class);
//        verify(userService, times(1)).signIn(emailArgument.capture(), passwordArgument.capture());
//        verifyNoMoreInteractions(userService);
//
//        assertEquals(email, emailArgument.getValue());
//        assertEquals(password, passwordArgument.getValue());
//    }
//
//    @Test
//    void createUser() {
//        when(userService.save(USER)).thenReturn(SAVE_USER);
//
//        mockMvc.perform(post("/user")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("user", USER)
//        )
//                .andExpect(status().isFound())
//                .andExpect(redirectedUrl(PagesPaths.CATALOG_PATH))
//                .andExpect(request().sessionAttribute("user", hasProperty("email", is(email))))
//                .andExpect(request().sessionAttribute("user", hasProperty("password", is(password))));
//
//        ArgumentCaptor<String> emailArgument = ArgumentCaptor.forClass(String.class);
//        ArgumentCaptor<String> passwordArgument = ArgumentCaptor.forClass(String.class);
//        verify(userService, times(1)).signIn(emailArgument.capture(), passwordArgument.capture());
//        verifyNoMoreInteractions(userService);
//
//        assertEquals(email, emailArgument.getValue());
//        assertEquals(password, passwordArgument.getValue());
//    }
//
//    @Test
//    void editUser() {
//    }
//
//    @Test
//    void delete() {
//    }
//
//    private static User getSaveUser() {
//        return User.builder()
//                .id(1L)
//                .firstName("Ivan")
//                .lastName("Zaichenko")
//                .birthDay("13-01-1999")
//                .login("ivan@gmail.com")
//                .password("12345")
//                .description("I am student")
//                .address("Yangelya")
//                .build();
//    }
//
//    private static User getUser() {
//        return User.builder()
//                .firstName("Ivan")
//                .lastName("Zaichenko")
//                .birthDay("13-01-1999")
//                .login("ivan@gmail.com")
//                .password("12345")
//                .description("I am student")
//                .address("Yangelya")
//                .build();
//    }
//}
