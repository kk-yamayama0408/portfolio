package ky.practice.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashEncode {

    public static void encode(String plain_password) {
        String hash_password_ = new BCryptPasswordEncoder().encode(plain_password);
        System.out.println("ハッシュ化されたパスワード:" + hash_password_);
    }

}
