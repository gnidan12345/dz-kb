package api.models.args.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
}
