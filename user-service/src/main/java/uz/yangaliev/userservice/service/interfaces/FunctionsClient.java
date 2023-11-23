package uz.yangaliev.userservice.service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.yangaliev.userservice.dto.DeterminantDto;
import uz.yangaliev.userservice.dto.MatrixDto;

@FeignClient(name = "functions-service", path = "/functions")
public interface FunctionsClient {

    @PostMapping("/matrix/determinant")
    DeterminantDto calculateDeterminantSC(@RequestBody MatrixDto matrixDto);
}
