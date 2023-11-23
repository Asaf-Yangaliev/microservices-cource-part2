package uz.yangaliev.userservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.yangaliev.userservice.dto.DeterminantDto;
import uz.yangaliev.userservice.dto.CalculateDeterminantRequestDto;
import uz.yangaliev.userservice.dto.MatrixDto;
import uz.yangaliev.userservice.service.interfaces.FunctionsClient;
import uz.yangaliev.userservice.service.interfaces.UserAuthorizationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest-template/matrix")
public class MatrixRTController {

    private final UserAuthorizationService authorizationService;
    private final FunctionsClient mathFunctions;

    @PostMapping("/determinant")
    public DeterminantDto calculateDeterminant(@RequestBody CalculateDeterminantRequestDto matrix) {
        authorizationService.checkUser(matrix.getAuthorizationInfo());
        return DeterminantDto.builder()
                .determinant(mathFunctions.calculateDeterminantSC(new MatrixDto(matrix.getMatrix())).getDeterminant())
                .build();
    }
}
