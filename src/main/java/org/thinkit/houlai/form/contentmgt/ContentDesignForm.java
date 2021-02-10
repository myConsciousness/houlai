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
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * コンテンツ設計画面で入力された情報を管理するフォームクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Data
@NoArgsConstructor(staticName = "newInstance")
public final class ContentDesignForm implements Serializable {

    /**
     * シリアルバージョンUID
     */
    private static final long serialVersionUID = -1562012593464136896L;

    /**
     * パッケージ名
     */
    private String packageName;

    /**
     * コンテンツ名
     */
    private String contentName;

    /**
     * 説明
     */
    private String description;

    /**
     * 条件ID
     */
    private String conditionId;

    /**
     * コンテンツ設計行
     */
    private List<SelectionDesignRow> selectionDesignRows;

    /**
     * 選択行を追加します。
     */
    public void addSelectionRow() {
        selectionDesignRows.add(SelectionDesignRow.newIsntance());
    }

    /**
     * 引数として渡された {@code index} に紐づく入力行を削除します。
     *
     * @param index 画面で選択された選択リスト項目のインデックス
     */
    public void removeSelectionRow(int index) {
        if (selectionDesignRows.size() > 1) {
            selectionDesignRows.remove(index);
        }
    }
}
