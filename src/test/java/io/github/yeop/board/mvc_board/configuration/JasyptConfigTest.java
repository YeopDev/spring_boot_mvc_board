package io.github.yeop.board.mvc_board.configuration;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@TestConfiguration
class JasyptConfigTest {
    @Test
    void jasypt_encyrpt_and_decrypt_test() {
        String plainText = "";
        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword(getJasyptEncryptorPassword());

        String encryptedText = jasypt.encrypt(plainText);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println(encryptedText);

        assertThat(plainText).isEqualTo(decryptedText);
    }

    private String getJasyptEncryptorPassword() {
        try {
            ClassPathResource resource = new ClassPathResource("jasypt-encryptor-password.txt");
            return String.join("", Files.readAllLines(Paths.get(resource.getURI())));
        } catch (IOException e) {
            throw new RuntimeException("File Not found!");
        }
    }
}