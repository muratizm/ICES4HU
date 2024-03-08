package org.codeer.ICES4HU.AuthenticationUser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static org.codeer.ICES4HU.AuthenticationUser.Permission.ADMIN_CREATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.ADMIN_DELETE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.ADMIN_READ;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.ADMIN_UPDATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.MANAGER_CREATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.MANAGER_DELETE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.MANAGER_READ;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.MANAGER_UPDATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.INSTRUCTOR_CREATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.INSTRUCTOR_DELETE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.INSTRUCTOR_READ;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.INSTRUCTOR_UPDATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.STUDENT_CREATE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.STUDENT_DELETE;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.STUDENT_READ;
import static org.codeer.ICES4HU.AuthenticationUser.Permission.STUDENT_UPDATE;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {

        ADMIN(Set.of(
                        ADMIN_READ,
                        ADMIN_UPDATE,
                        ADMIN_DELETE,
                        ADMIN_CREATE,
                        MANAGER_READ,
                        MANAGER_UPDATE,
                        MANAGER_DELETE,
                        MANAGER_CREATE,
                        INSTRUCTOR_READ,
                        INSTRUCTOR_UPDATE,
                        INSTRUCTOR_DELETE,
                        INSTRUCTOR_CREATE,
                        STUDENT_READ,
                        STUDENT_UPDATE,
                        STUDENT_DELETE,
                        STUDENT_CREATE)),
        MANAGER(Set.of(
                        MANAGER_READ,
                        MANAGER_UPDATE,
                        MANAGER_DELETE,
                        MANAGER_CREATE,
                        INSTRUCTOR_READ,
                        INSTRUCTOR_UPDATE,
                        INSTRUCTOR_DELETE,
                        INSTRUCTOR_CREATE,
                        STUDENT_READ,
                        STUDENT_UPDATE,
                        STUDENT_DELETE,
                        STUDENT_CREATE)),
        INSTRUCTOR(Set.of(
                        INSTRUCTOR_READ,
                        INSTRUCTOR_UPDATE,
                        INSTRUCTOR_DELETE,
                        INSTRUCTOR_CREATE)),
        STUDENT(Set.of(
                        STUDENT_READ,
                        STUDENT_UPDATE,
                        STUDENT_DELETE,
                        STUDENT_CREATE)),
        USER(Collections.emptySet());

        @Getter
        private final Set<Permission> permissions;

        public List<SimpleGrantedAuthority> getAuthorities() {
                var authorities = getPermissions()
                                .stream()
                                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                                .collect(Collectors.toList());
                authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
                return authorities;
        }
}
