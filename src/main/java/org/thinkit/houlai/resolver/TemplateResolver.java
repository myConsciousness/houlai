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

package org.thinkit.houlai.resolver;

import org.thinkit.houlai.catalog.TemplateName;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * テンプレートに関する操作を提供するクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TemplateResolver {

    /**
     * 引数として渡されたテンプレート名から文字列表現を取得し返却します。
     *
     * @param templateName テンプレート名
     * @return テンプレート名の文字列表現
     *
     * @exception NullPointerException 引数として {@code null} が渡されたば場合
     */
    public static String getName(@NonNull final TemplateName templateName) {
        return templateName.getTag();
    }
}
