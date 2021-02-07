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

package org.thinkit.houlai.form;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ログイン画面で入力された情報を管理するフォームクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Data
@NoArgsConstructor(staticName = "newInstance")
public final class LoginForm implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = -3488239946936090774L;

    /**
     * ユーザーID
     */
    private String userId;

    /**
     * パスワード
     */
    private String password;

    /**
     * ログイン記憶
     */
    private boolean rememberMe;
}
