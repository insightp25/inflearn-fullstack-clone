package clone.inflearn.backend.interfaces.test;

import clone.inflearn.backend.domain.test.TestService;
import clone.inflearn.backend.domain.test.model.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public ResponseEntity<Test> test() {
        return ResponseEntity
            .ok()
            .body(testService.create());
    }
}
