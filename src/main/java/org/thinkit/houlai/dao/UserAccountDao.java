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

package org.thinkit.houlai.dao;

import org.apache.ibatis.annotations.Mapper;
import org.thinkit.houlai.entity.UserAccount;

import lombok.NonNull;

/**
 * 「User Account」テーブルとマッピングを行うDaoクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Mapper
public interface UserAccountDao {

    /**
     * 引数として渡された一意のユーザーIDに紐づくレコードを取得します。
     *
     * @param userId 一意のユーザーID
     * @return 引数として渡された一意のユーザーIDに紐づくレコード
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public UserAccount findByUserId(@NonNull final String userId);
}
