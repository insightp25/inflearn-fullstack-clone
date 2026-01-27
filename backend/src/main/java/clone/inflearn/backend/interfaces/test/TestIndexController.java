package clone.inflearn.backend.interfaces.test;

import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestIndexController {

    @GetMapping("/")
    public String index(@AuthenticationPrincipal OAuth2User oAuth2User) {
        // 로그인한 유저의 정보를 Map 형태로 출력
        Map<String, Object> attributes = oAuth2User.getAttributes();
        return "로그인 성공! 유저 정보: " + attributes.toString();
    }
}
