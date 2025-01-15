package pl.mefjuuuu.encryptionapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class CipherRequest {

    private String mode;

    private final String cipherType;

    private Map<String, Object> options;
}
