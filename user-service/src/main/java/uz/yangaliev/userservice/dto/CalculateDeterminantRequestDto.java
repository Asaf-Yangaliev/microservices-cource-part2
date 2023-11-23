package uz.yangaliev.userservice.dto;

import lombok.Data;

@Data
public class CalculateDeterminantRequestDto {
    private AuthorizationInfoDto authorizationInfo;
    private int[][] matrix;
}
