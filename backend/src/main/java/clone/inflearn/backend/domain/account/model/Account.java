package clone.inflearn.backend.domain.account.model;

import clone.inflearn.backend.domain.account.enums.AccountRole;
import java.util.Set;
import lombok.Builder;

@Builder
public record Account(
    Long id,
    String email,
    String password,
    Set<AccountRole> roles
) {

}
