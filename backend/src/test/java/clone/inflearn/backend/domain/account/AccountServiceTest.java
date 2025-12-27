package clone.inflearn.backend.domain.account;

import static org.assertj.core.api.Assertions.assertThat;

import clone.inflearn.backend.domain.account.enums.AccountRole;
import clone.inflearn.backend.domain.account.model.Account;
import clone.inflearn.backend.domain.account.port.AccountRepository;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void findByUsername() {
        // given
        String username = "johndoe@email.com";
        String password = "johndoe";

        Account account = Account.builder()
            .email(username)
            .password(password)
            .roles(Set.of(AccountRole.ADMIN, AccountRole.USER))
            .build();

        this.accountRepository.save(account);

        // when
        UserDetailsService userDetailsService = (UserDetailsService)accountService;
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // then
        assertThat(userDetails.getPassword()).isEqualTo(password);
    }
}