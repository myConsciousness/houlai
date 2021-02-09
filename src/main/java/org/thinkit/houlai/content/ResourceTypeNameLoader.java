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

package org.thinkit.houlai.content;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.thinkit.framework.content.Attribute;
import org.thinkit.framework.content.Condition;
import org.thinkit.framework.content.Content;
import org.thinkit.framework.content.annotation.ContentMapping;
import org.thinkit.houlai.catalog.ResourceType;
import org.thinkit.houlai.content.entity.ResourceTypeName;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * コンテンツ「リソース種別名称」を読み込むクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "from")
@ContentMapping(content = "org/thinkit/houlai/ResourceTypeName")
public final class ResourceTypeNameLoader implements Content<ResourceTypeName> {

    /**
     * リソース種別
     */
    @NonNull
    private ResourceType resourceType;

    /**
     * コンテンツ要素定数
     */
    @RequiredArgsConstructor
    private enum ContentAttribute implements Attribute {

        /**
         * リソース種別名称
         */
        RESOURCE_TYPE_NAME(Key.resourceTypeName);

        /**
         * 検索キー
         */
        private final Key key;

        @Override
        public String getString() {
            return this.key.name();
        }

        /**
         * キー要素
         */
        private enum Key {
            resourceTypeName;
        }
    }

    /**
     * コンテンツ条件定数
     */
    @RequiredArgsConstructor
    private enum ContentCondition implements Condition {

        /**
         * リソース種別コード
         */
        RESOURCE_TYPE_CODE(Key.resourceTypeCode);

        /**
         * 検索キー
         */
        private final Key key;

        @Override
        public String getString() {
            return this.key.name();
        }

        /**
         * キー要素
         */
        private enum Key {
            resourceTypeCode;
        }
    }

    @Override
    public ResourceTypeName execute() {
        return ResourceTypeName.builder()
                .resourceTypeName(this.loadContent(this).get(0).get(ContentAttribute.RESOURCE_TYPE_NAME.getString()))
                .build();
    }

    @Override
    public Set<Attribute> getAttributes() {
        return Set.of(ContentAttribute.RESOURCE_TYPE_NAME);
    }

    @Override
    public List<Map<Condition, String>> getConditions() {
        return List.of(Map.of(ContentCondition.RESOURCE_TYPE_CODE, String.valueOf(this.resourceType.getCode())));
    }
}
