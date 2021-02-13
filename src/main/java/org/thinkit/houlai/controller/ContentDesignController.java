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

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thinkit.houlai.form.contentmgt.ContentDesignForm;

/**
 * コンテンツ設計画面のイベント処理を管理するコントローラーです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Controller
public final class ContentDesignController {

    @GetMapping("content/design")
    public String index(@ModelAttribute ContentDesignForm contentDesignForm) {

        contentDesignForm.addSelectionRow();

        return "content_design";
    }

    @PostMapping(value = "content/design", params = "addSelectionRow")
    public String addSelectionRow(@ModelAttribute ContentDesignForm contentDesignForm) {
        contentDesignForm.addSelectionRow();
        return "content_design";
    }

    @PostMapping(value = "content/design", params = "removeSelectionRow")
    public String removeSelectionRow(@ModelAttribute ContentDesignForm contentDesignForm,
            final HttpServletRequest request) {

        final int removeRowIndex = Integer.valueOf(request.getParameter("removeSelectionRow"));
        contentDesignForm.removeSelectionRow(removeRowIndex);

        return "content_design";
    }
}
