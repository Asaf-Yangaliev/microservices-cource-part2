package uz.yangaliev.functions.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeterminantInfoDto {
    private int determinant;
    private EnvironmentInfoDto environment;
}
