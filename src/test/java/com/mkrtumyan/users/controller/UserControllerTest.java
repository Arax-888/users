package com.mkrtumyan.users.controller;

import com.mkrtumyan.users.persistence.User;
import com.mkrtumyan.users.persistence.UserRepository;
import com.mkrtumyan.users.persistence.UserResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Test
    void test_getAll_fail() {
        UserController userController = new UserController(new UserRepository() {

            @Override
            public List<User> findAll() {
                return null;
            }

            @Override
            public User save(User user) {
                return null;
            }

            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<User> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }
        });
        var response = userController.getAll();
        Assertions.assertThat(response.getStatusCode().equals(HttpStatus.NO_CONTENT));
        Assertions.assertThat(response.getBody() == null);
    }

    @Test
    void test_getAll_success() {
        UserController userController = new UserController(new UserRepository() {

            @Override
            public List<User> findAll() {

                return List.of(
                        new User(1L, "Ani", "Mkrtumyan", "ani@gmail.com"),
                        new User(2L, "Artur", "Poxosyan", "artur@gmail.com"),
                        new User(3L, "Anna", "Zanyan", "anna@gmail.com"));
            }

            @Override
            public List<User> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends User> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public User save(User user) {
                return null;
            }
        });
        var response = userController.getAll();
        var body = (List<UserResponse>) response.getBody();
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        assert body != null;
        Assertions.assertThat(body.size()).isEqualTo(3);
    }
}