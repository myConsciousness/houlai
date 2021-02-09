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
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thinkit.api.catalog.Catalog;
import org.thinkit.framework.content.ContentInvoker;
import org.thinkit.houlai.catalog.ResourceType;
import org.thinkit.houlai.content.ResourceTypeNameLoader;
import org.thinkit.houlai.entity.Resource;
import org.thinkit.houlai.form.ResourceOverviewForm;
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
     * 「Resource」テーブルを操作するサービス
     */
    @Autowired
    ResourceService resourceService;

    @GetMapping("resource/overview")
    public String index(Model model) {

        final Map<String, Object> resourceTypes = new LinkedMap<>();

        Arrays.asList(ResourceType.values()).forEach(resourceType -> {
            final String ResourceTypeName = ContentInvoker.of(ResourceTypeNameLoader.from(resourceType)).invoke()
                    .getResourceTypeName();
            resourceTypes.put(ResourceTypeName, String.valueOf(resourceType.getCode()));
        });

        model.addAttribute("resourceTypes", resourceTypes);
        model.addAttribute("resourceOverviewForm", ResourceOverviewForm.newInstance());

        return "resource_overview";
    }

    @PostMapping("resource/overview/search")
    public String search(Model model, @ModelAttribute ResourceOverviewForm resourceOverviewForm) {

        final ResourceType resourceType = Catalog.getEnum(ResourceType.class, resourceOverviewForm.getResourceType());

        if (resourceType == null) {
            throw new IllegalStateException();
        }

        final List<Resource> resources = this.resourceService.findOverview(resourceType,
                resourceOverviewForm.getResourceName(), resourceOverviewForm.getExtension());
        model.addAttribute("resources", resources);

        return "resource_overview";
    }
}
