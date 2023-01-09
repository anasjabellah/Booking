package com.example.bookingmt.services.implementation;

import com.example.bookingmt.entities.Reservation;
import com.example.bookingmt.entities.Room;
import com.example.bookingmt.entities.User;
import com.example.bookingmt.enumeration.Status;
import com.example.bookingmt.repositories.ReservationRepository;
import com.example.bookingmt.repositories.RoomRepository;
import com.example.bookingmt.repositories.UserRepository;
import com.example.bookingmt.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;
    @Autowired
    private final UserRepository userRepository ;

    @Autowired
    private final RoomRepository roomRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserRepository userRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }


    @Override
    public void AddReservation(Reservation reservation, Long userId, Long roomId) {
        User user = userRepository.findById(userId).orElse(null);
        Room room = roomRepository.findById(roomId).orElse(null);
        reservation.setRoom(room);
        reservation.setClient(user);
        reservation.setStatus(Status.Encours);
        reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> GetAllRes() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Boolean DeleteReservation(long id) {

        reservationRepository.deleteById(id);

        if(reservationRepository.findById(id) == null){
            return Boolean.TRUE ;
        }else {
            return Boolean.FALSE ;
        }

    }

}
