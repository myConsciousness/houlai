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
import org.thinkit.houlai.catalog.TransitionType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * 画面遷移に関する操作を提供するクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageTransitionResolver {

    /**
     * コマンドの雛形
     */
    private static final String COMMAND_FORMAT = "%s/%s";

    /**
     * 引数として渡されたテンプレート名にリダイレクト方式で遷移するコマンドの文字列表現を返却します。
     *
     * @param templateName リダイレクト先のテンプレート名
     * @return リダイレクトコマンドの文字列表現
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static String redrectTo(@NonNull final TemplateName templateName) {
        return formatTransitionCommand(TransitionType.REDIRECT, templateName);
    }

    /**
     * 引数として渡されたテンプレート名にフォワード方式で遷移するコマンドの文字列表現を返却します。
     *
     * @param templateName フォワード先のテンプレート名
     * @return フォワードコマンドの文字列表現
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static String forwardTo(@NonNull final TemplateName templateName) {
        return formatTransitionCommand(TransitionType.FORWARD, templateName);
    }

    /**
     * 引数として渡された情報を基に遷移コマンドを生成し返却します。
     *
     * @param transitionType 遷移種別
     * @param templateName   テンプレート名
     * @return 遷移コマンド
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private static String formatTransitionCommand(@NonNull final TransitionType transitionType,
            @NonNull final TemplateName templateName) {
        return String.format(COMMAND_FORMAT, transitionType.getTag(), TemplateResolver.getName(templateName));
    }
}
