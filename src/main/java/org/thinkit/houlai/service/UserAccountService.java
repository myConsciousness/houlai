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

package org.thinkit.houlai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thinkit.houlai.dao.UserAccountDao;
import org.thinkit.houlai.entity.UserAccount;

import lombok.NonNull;

/**
 * 「Resource」テーブルの操作を定義したサービスクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Service
public final class UserAccountService {

    /**
     * 「UserAccount」テーブルとマッピングを行うDao
     */
    @Autowired
    UserAccountDao userAccountDao;

    /**
     * 引数として渡された一意のユーザーIDに紐づくレコードを取得します。
     *
     * @param userId 一意のユーザーID
     * @return 引数として渡された一意のユーザーIDに紐づくレコード
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public UserAccount findById(@NonNull final String userId) {
        return this.userAccountDao.findByUserId(userId);
    }
}
