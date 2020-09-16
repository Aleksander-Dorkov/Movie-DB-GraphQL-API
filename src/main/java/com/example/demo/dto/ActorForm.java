package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActorForm
{
    private Long actorId;
    private String firstName;
    private String lastName;
    private String address;
}
