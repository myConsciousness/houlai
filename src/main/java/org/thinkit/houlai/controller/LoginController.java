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

package org.thinkit.houlai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thinkit.houlai.catalog.TemplateName;
import org.thinkit.houlai.form.LoginForm;
import org.thinkit.houlai.resolver.PageTransitionResolver;
import org.thinkit.houlai.resolver.TemplateResolver;

/**
 * 認証画面のイベント処理を管理するコントローラークラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Controller
public final class LoginController {

    /**
     * 基準パス
     */
    private static final String BASE_PATH = "/login";

    /**
     * ログイン画面を初期化し開設します。
     *
     * @param loginForm ログイン画面のフォーム
     * @return ログイン画面のリソース
     */
    @GetMapping(BASE_PATH)
    public String index(@ModelAttribute LoginForm loginForm) {
        return TemplateResolver.getName(TemplateName.LOGIN);
    }

    /**
     * 認証処理が完了した場合にダッシュボード画面へリダイレクトします。
     *
     * @return ダッシュボード画面へのリダイレクトコマンド
     */
    @PostMapping
    public String redirectDashboard() {
        return PageTransitionResolver.redrectTo(TemplateName.DASHBOARD);
    }
}
