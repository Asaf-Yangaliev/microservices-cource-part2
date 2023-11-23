package uz.yangaliev.userservice.service.interfaces;

import uz.yangaliev.userservice.dto.AuthorizationInfoDto;

public interface UserAuthorizationService {
    void checkUser(AuthorizationInfoDto registrationInfo);
}
