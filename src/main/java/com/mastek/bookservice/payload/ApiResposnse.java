package com.mastek.bookservice.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class ApiResposnse {
    private String message;
    private HttpStatus status;
}
