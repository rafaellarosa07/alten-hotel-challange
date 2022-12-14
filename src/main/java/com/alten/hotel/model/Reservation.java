package com.alten.hotel.model;

import com.alten.hotel.enumaration.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "NUMBER", nullable = false)
  private Long number;

  @Column(name = "DATE_CHECK_IN", nullable = false)
  private LocalDateTime dateCheckIn;

  @Column(name = "DATE_CHECK_OUT", nullable = false)
  private LocalDateTime dateCheckOut;

  @ManyToOne
  @JoinColumn(name = "USER_ID", nullable = false)
  private User user;

  @OneToOne
  @JoinColumn(name = "ROOM_ID", nullable = false)
  private Room room;

  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", nullable = false)
  private ReservationStatus status;

}
