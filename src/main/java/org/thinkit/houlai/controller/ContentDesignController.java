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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thinkit.houlai.form.contentmgt.ContentDesignForm;
import org.thinkit.houlai.form.contentmgt.SelectionDesignRow;

/**
 * コンテンツデザイン画面のイベント処理を管理するコントローラーです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Controller
public final class ContentDesignController {

    @GetMapping("content/design")
    public String index(Model model) {

        final ContentDesignForm contentDesignForm = ContentDesignForm.newInstance();
        contentDesignForm.setSelectionDesignRows(List.of(SelectionDesignRow.newIsntance()));

        model.addAttribute("contentDesignForm", contentDesignForm);
        model.addAttribute("selectionDesigns", contentDesignForm.getSelectionDesignRows());

        return "content_design";
    }

    @PostMapping(value = "content/design", params = "addSelection")
    public String addList(@ModelAttribute ContentDesignForm contentDesignForm, Model model) {
        contentDesignForm.addSelectionRow();
        return "content_design";
    }

    @PostMapping(value = "content/design", params = "removeSelection")
    public String removeList(@ModelAttribute ContentDesignForm contentDesignForm, Model model,
            HttpServletRequest request) {
        contentDesignForm.removeSelectionRow(Integer.valueOf(request.getParameter("remove")));
        return "content_design";
    }
}
