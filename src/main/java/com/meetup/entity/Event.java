package com.meetup.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Event {
    @Id
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private String hostName;
    private LocalDateTime dateTime;
    private Byte[] image;
    private String venue;
}
