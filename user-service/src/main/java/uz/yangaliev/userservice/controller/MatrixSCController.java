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
@RequestMapping("/spring-cloud/matrix")
public class MatrixSCController {

    private final UserAuthorizationService authorizationService;
    private final FunctionsClient mathFunctions;

    @PostMapping("/determinant")
    public DeterminantDto calculateDeterminant(@RequestBody CalculateDeterminantRequestDto matrixInfo) {
        authorizationService.checkUser(matrixInfo.getAuthorizationInfo());
        return mathFunctions.calculateDeterminantSC(new MatrixDto(matrixInfo.getMatrix()));
    }
}
