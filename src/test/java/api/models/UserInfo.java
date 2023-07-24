package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private String role;
    private  boolean is_ldap_user;
    private String name;
    private String email;
    private String google_id;
    private String github_id;
    private boolean notifications_enabled;


    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

