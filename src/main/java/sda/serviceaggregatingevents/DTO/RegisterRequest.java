package sda.serviceaggregatingevents.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotEmpty
    private String Name;

    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;


}
