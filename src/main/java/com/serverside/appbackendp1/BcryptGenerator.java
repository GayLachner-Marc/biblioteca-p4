
package com.serverside.appbackendp1;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGenerator {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        String password = "BibliotecaP3-Dev-2026!";

        String[] emails = {
                "lucia.garcia@example.com",
                "marc.puig@example.com",
                "andrea.valero@example.com",
                "javier.martin@example.com",
                "sara.fernandez@example.com"
        };

        System.out.println("-- Actualización de contraseñas de desarrollo");
        System.out.println("USE biblioteca;");

        for (String email : emails) {

            String hash = encoder.encode(password);

            System.out.println(
                    "UPDATE usuarios SET password = '" + hash
                            + "' WHERE email = '" + email + "';"
            );

            System.out.println(
                    "-- Verificación: " +
                            encoder.matches(password, hash)
            );
        }
    }
}
