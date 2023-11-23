package uz.yangaliev.functions.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.yangaliev.functions.calculator.MatrixCalculator;
import uz.yangaliev.functions.service.interfaces.MatrixFunctionsService;

@RequiredArgsConstructor
@Service
public class MatrixFunctionsServiceImpl implements MatrixFunctionsService {

    private final MatrixCalculator matrixCalculator;

    @Override
    public int determinant(int[][] matrix) {
        return matrixCalculator.determinant(matrix);
    }
}
