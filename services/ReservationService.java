package com.example.bookingmt.services;

import com.example.bookingmt.entities.Reservation;
import com.example.bookingmt.entities.Room;
import com.example.bookingmt.entities.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {


    // add user in data
    void AddReservation(Reservation reservation , Long userId , Long roomId);

    // list user
   List<Reservation> GetAllRes();

    //get user by email
    Optional<Reservation> findById(Long id);


    // get user by id
   // Optional<User> findById(long id);

    // update user
    //void updateUser(User user);


    // delet User
   Boolean DeleteReservation(long id);
}
