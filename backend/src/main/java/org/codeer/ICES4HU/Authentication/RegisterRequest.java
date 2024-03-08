package org.codeer.ICES4HU.Authentication;

import org.codeer.ICES4HU.AuthenticationUser.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String name;
  private String surname;
  private String username;
  private String password;
  private Integer studentId;
  private Integer personnelId;
  private Role role;
}
