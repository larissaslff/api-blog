package com.larissa.blogapi.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErroMessage {
    private String message;
    private Integer code;
    private LocalDate time;
}
