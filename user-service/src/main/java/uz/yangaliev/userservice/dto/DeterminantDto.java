package uz.yangaliev.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeterminantDto {
    private int determinant;
    private EnvironmentInfoDto environment;
}
