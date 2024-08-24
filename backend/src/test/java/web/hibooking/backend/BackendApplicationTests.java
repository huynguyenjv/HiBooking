package web.hibooking.backend;

import jakarta.xml.bind.DatatypeConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class BackendApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(BackendApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    void hash() throws NoSuchAlgorithmException{

        String password = "12345";
//        827CCB0EEA8A706C4C34A16891F84E7B
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte[] bytes = md.digest();

        String md5Hash = DatatypeConverter.printHexBinary(bytes);

        log.info("MD5 round 1 : {}",md5Hash);

        md.update(md5Hash.getBytes());

        bytes = md.digest();
        md5Hash = DatatypeConverter.printHexBinary(bytes);

        log.info("MD5 round 2 : {}",md5Hash);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        log.info("BCrypt round 1 : {}",passwordEncoder.encode(password));
        log.info("BCrypt round 2 : {}",passwordEncoder.encode(password));

    }

}
