package kr.leejonghyup.ovo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public int insertUserInfo(Map map) {
        return userRepository.insertUserInfo(map);
    }

    public List<User> emailCheck(String email) {
        return userRepository.emailCheck(email);
    }
}
