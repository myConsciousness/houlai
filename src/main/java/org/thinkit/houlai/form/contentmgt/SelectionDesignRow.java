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

package org.thinkit.houlai.form.contentmgt;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * コンテンツ設計画面で入力された行情報を管理するクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Data
@NoArgsConstructor(staticName = "newIsntance")
public final class SelectionDesignRow implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = -9180313577874603349L;

    /**
     * 条件ID
     */
    private String conditionId;
}
