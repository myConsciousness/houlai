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

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.thinkit.houlai.entity.UserAccount;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ログインユーザーの認証管理を行うクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public final class LoginUserDetails extends User {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = -3659510960614730787L;

    /**
     * 「UserAccount」テーブルから取得したレコード
     */
    private final UserAccount userAccount;

    /**
     * ユーザーアカウントのユーザーIDとパスワードを照合しログイン認証を行います。
     *
     * @param userAccount 「UserAccount」テーブルから取得したレコード
     * @param role        権限
     */
    public LoginUserDetails(UserAccount userAccount, String role) {
        super(userAccount.getUserId(), userAccount.getPassword(), AuthorityUtils.createAuthorityList(role));
        this.userAccount = userAccount;
    }
}
