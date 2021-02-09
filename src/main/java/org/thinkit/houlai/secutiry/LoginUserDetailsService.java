/*
 * Copyright 2021 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.houlai.secutiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thinkit.houlai.entity.UserAccount;
import org.thinkit.houlai.service.UserAccountService;

import lombok.NonNull;

/**
 * ユーザーアカウントとログイン画面で入力された認証情報を照合するサービスクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Service
public final class LoginUserDetailsService implements UserDetailsService {

    /**
     * 「UserAccount」テーブルを操作するサービス
     */
    @Autowired
    UserAccountService userAccountService;

    @Override
    public UserDetails loadUserByUsername(@NonNull final String userId) throws UsernameNotFoundException {

        final UserAccount userAccount = this.userAccountService.findByUserId(userId);

        if (userAccount == null) {
            throw new UsernameNotFoundException("Wrong email or password");
        }

        final String role = "ROLE_ADMIN";

        return new LoginUserDetails(userAccount, role);
    }
}
