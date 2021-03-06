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

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thinkit.api.catalog.Catalog;
import org.thinkit.houlai.catalog.ResourceType;
import org.thinkit.houlai.content.ResourceTypeNameMapper;
import org.thinkit.houlai.entity.Resource;
import org.thinkit.houlai.form.resourcemgt.ResourceOverviewForm;
import org.thinkit.houlai.service.ResourceService;

/**
 * リソース概要画面のイベントを管理するコントローラーです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@Controller
public final class ResourceOverviewController {

    /**
     * 基準パス
     */
    private static final String BASE_PATH = "/resource/overview";

    /**
     * 「Resource」テーブルを操作するサービス
     */
    @Autowired
    ResourceService resourceService;

    /**
     * リソース概要画面を初期化し開設します。
     *
     * @param model 画面リクエストマッピング
     * @return リソース概要画面のリソース
     */
    @GetMapping(BASE_PATH)
    public String index(@ModelAttribute ResourceOverviewForm resourceOverviewForm, Model model) {

        model.addAttribute("resourceTypes", this.createResourceTypeOptions());

        return "resource_overview";
    }

    /**
     * 画面に入力された値を基に検索処理を行いリソース概要画面を再読込します。
     *
     * @param model                画面リクエストマッピング
     * @param resourceOverviewForm リソース概要フォーム
     * @return リソース概要画面のリソース
     */
    @PostMapping(value = BASE_PATH, params = "search")
    public String search(Model model, @ModelAttribute ResourceOverviewForm resourceOverviewForm) {

        final ResourceType resourceType = Catalog.getEnum(ResourceType.class, resourceOverviewForm.getResourceType());

        if (resourceType == null) {
            throw new IllegalStateException();
        }

        final List<Resource> resources = this.resourceService.findOverview(resourceType,
                resourceOverviewForm.getResourceName(), resourceOverviewForm.getExtension());

        model.addAttribute("resourceTypes", this.createResourceTypeOptions());
        model.addAttribute("resources", resources);

        return "resource_overview";
    }

    /**
     * リソース種別のプルダウン要素を生成し返却します。
     *
     * @return リソース種別のプルダウン要素
     */
    private Map<String, Object> createResourceTypeOptions() {

        final Map<String, Object> resourceTypes = new LinkedHashMap<>();

        Arrays.asList(ResourceType.values()).forEach(resourceType -> {
            ResourceTypeNameMapper.from(resourceType).scan().forEach(resourceTypeName -> {
                resourceTypes.put(resourceTypeName.getResourceTypeName(), String.valueOf(resourceType.getCode()));
            });
        });

        return resourceTypes;
    }
}
