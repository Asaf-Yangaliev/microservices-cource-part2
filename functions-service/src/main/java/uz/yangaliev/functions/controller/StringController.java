package uz.yangaliev.functions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.yangaliev.functions.dto.*;
import uz.yangaliev.functions.service.interfaces.SmilesErasureService;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/functions/string")
public class StringController {

    private final Environment environment;
    private final SmilesErasureService smilesErasure;

    private EnvironmentInfoDto environmentInfo = null;

    @PostMapping("/smiles-erasure")
    public SmilesErasureResultDto erasureSmiles(@RequestBody StringsDto stringsDto) {
        return SmilesErasureResultDto.builder()
                .result(smilesErasure.getResult(stringsDto.getStrings()))
                .environmentInfo(getEnvironmentInfo())
                .build();
    }

    private EnvironmentInfoDto getEnvironmentInfo() {
        if (environmentInfo == null) {
            environmentInfo = EnvironmentInfoDto.builder()
                    .port(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))))
                    .build();
        }
        return environmentInfo;
    }
}
