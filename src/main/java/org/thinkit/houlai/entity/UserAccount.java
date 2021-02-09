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

package org.thinkit.houlai.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 「UserAccount」テーブルから取得したデータを格納するEntityクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Data
@NoArgsConstructor(staticName = "newInstance")
public final class UserAccount implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = -7089448129607446551L;

    /**
     * ユーザーID
     */
    private String userId;

    /**
     * パスワード
     */
    private String password;

    /**
     * ユーザー名（名前）
     */
    private String userFirstName;

    /**
     * ユーザー名（名字）
     */
    private String userLastName;
}
