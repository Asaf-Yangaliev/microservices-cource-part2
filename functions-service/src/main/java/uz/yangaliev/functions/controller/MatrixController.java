package uz.yangaliev.functions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.yangaliev.functions.dto.DeterminantInfoDto;
import uz.yangaliev.functions.dto.EnvironmentInfoDto;
import uz.yangaliev.functions.dto.MatrixDto;
import uz.yangaliev.functions.service.interfaces.MatrixFunctionsService;

import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("functions/matrix")
public class MatrixController {

    private final MatrixFunctionsService matrixFunctionsService;

    private final Environment environment;

    private EnvironmentInfoDto environmentInfo = null;

    @PostMapping("/determinant")
    public DeterminantInfoDto calculateDeterminantRT(@RequestBody MatrixDto matrixDto) {
        return DeterminantInfoDto.builder()
                .determinant(matrixFunctionsService.determinant(matrixDto.getMatrix()))
                .environment(getEnvironment())
                .build();
    }

    private EnvironmentInfoDto getEnvironment() {
        if (environmentInfo == null) {
            environmentInfo = EnvironmentInfoDto.builder()
                    .port(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))))
                    .build();
        }
        return environmentInfo;
    }
}
