package com.david.spring_angular.repositories;

import com.david.spring_angular.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepository extends JpaRepository<User, Integer> {

    // select * from _user where firsname = 'ali'
    List<User> findAllByFirstname(String firstname);

    // select * from _user where firsname like '%Ali%'
    List<User> findAllByFirstnameContaining(String firstname);

    // select * from _user where firsname ilike '%Ali%'
    List<User> findAllByFirstnameContainingIgnoreCase(String firstname);

    // select * from _user u inner join account a on u.id = a.id_user and a.iban = "DE123456789"
    List<User> findAllByAccountIban(String iban);

    // select * from _user where firstname = '%ali%' and email = "bouali.pro@gmail.com"
    User findAllByFirstnameContainingIgnoreCaseAndEmail(String firstname, String email);

    @Query("from User where firstname = :fn")
    List<User> searchByFirstname(@Param("fn") String firstname);

    @Query("from User where firstname = '%:firstname%'")
    List<User> searchByFirstnameContaining(String firstname);

    @Query("from User u inner join Account a on u.id = a.user.id where a.iban = :iban")
    List<User> searchByIban(String iban);

    @Query(value = "select * from _user u inner join account a on u.id = a.id_user and a.iban", nativeQuery = true)
    List<User> searchByIbanNative(String iban);

}
