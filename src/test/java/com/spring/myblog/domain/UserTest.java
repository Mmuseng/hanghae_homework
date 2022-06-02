package com.spring.myblog.domain;

import com.spring.myblog.dto.SignupRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Nested
    @DisplayName("닉네임 유효성 검사")
    class CreateUser {

        private String username;
        private String password;
        private String email;

        @BeforeEach
        void setup() {
            username = "user";
            password = "asdafo";
            email = "user123@naver.com";
        }

        @Test
        @DisplayName("정상 케이스")
        void CreateUser_Normal() {
            SignupRequestDto requestDto = new SignupRequestDto(
                    username, password, email
            );

            User user = new User(requestDto);

            assertNull(user.getId());
            assertEquals(username, user.getUsername());
            assertEquals(password, user.getPassword());
        }

        @Nested
        @DisplayName("실패 케이스")
        class FailCase {
            @Nested
            @DisplayName("닉네임")
            class username {
                @Test
                @DisplayName("3자 미만")
                void fail1() {
                    username = "u1";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("회원 닉네임이 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("특수문자")
                void fail2() {
                    username = "test!@#";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("회원 닉네임이 유효하지 않습니다.", exception.getMessage());
                }
            }

            @Nested
            @DisplayName("비밀번호")
            class password {
                @Test
                @DisplayName("1자 이상 4자 미만")
                void fail1 () {

                    password = "p1";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("패스워드가 유효하지 않습니다.", exception.getMessage());
                }

                @Test
                @DisplayName("null")
                void fail2() {
                    password = "";

                    SignupRequestDto requestDto = new SignupRequestDto(
                            username, password, email
                    );

                    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                        new User(requestDto);
                    });

                    assertEquals("패스워드가 유효하지 않습니다.", exception.getMessage());
                }
            }



        }


    }
}
