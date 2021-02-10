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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
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

    @GetMapping(value = "content/design")
    public String index(@ModelAttribute ContentDesignForm contentDesignForm) {

        final List<SelectionDesignRow> selectionDesignRows = new ArrayList<>();
        selectionDesignRows.add(SelectionDesignRow.newIsntance());
        contentDesignForm.setSelectionDesignRows(selectionDesignRows);

        return "content_design";
    }

    @PostMapping(value = "content/design", params = "addSelectionRow")
    public String addSelectionRow(@ModelAttribute ContentDesignForm contentDesignForm) {
        contentDesignForm.addSelectionRow();
        return "content_design";
    }

    @PostMapping(value = "content/design", params = "removeSelectionRow")
    public String removeSelectionRow(@ModelAttribute ContentDesignForm contentDesignForm, HttpServletRequest request) {
        contentDesignForm.removeSelectionRow(Integer.valueOf(request.getParameter("remove")));
        return "content_design";
    }
}
