package com.aerztekasse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Timing {
    private Date startsAt;
    private Date endsAt;
}
