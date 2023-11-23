package uz.yangaliev.userservice.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.yangaliev.userservice.dto.AuthorizationInfoDto;
import uz.yangaliev.userservice.entity.User;
import uz.yangaliev.userservice.exception.UserUnauthorizedException;
import uz.yangaliev.userservice.repository.interfaces.UserRepository;
import uz.yangaliev.userservice.service.interfaces.UserAuthorizationService;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {

    private final UserRepository userRepository;

    @Override
    public void checkUser(AuthorizationInfoDto registrationInfo) {
        Optional<User> optionalUser = userRepository.findById(registrationInfo.getId());
        String message;
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(registrationInfo.getPassword())) {
                return;
            } else {
                message = "Wrong password";
            }
        } else {
            message = "There is no user with id = %s".formatted(registrationInfo.getId());
        }
        throw new UserUnauthorizedException(message);
    }
}
